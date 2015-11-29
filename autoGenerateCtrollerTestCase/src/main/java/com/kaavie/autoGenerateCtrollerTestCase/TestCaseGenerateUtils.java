package com.kaavie.autoGenerateCtrollerTestCase;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


/** 
* @author 作者 :kaavie 
* @version 创建时间：2015年11月27日 下午7:49:09 
* 类说明   测试用例生成工具类
*/
public class TestCaseGenerateUtils  {

	/**
	 * 
	 * @作者 kaavie
	 * @创建时间 Date:2015年11月28日下午1:49:36
	 * @输入
	 * @预计输出  通过注解生成对应的一些保存测试用例
	 * @remark:通过注解生成对应的一些保存测试用例
	 * @param classObject ctroller中使用的一些需要验证的类
	 * @param url save请求的url
	 * @return 
	 */
	public static void generateTest(Class classObject, String url) {
		Map<String, List<Map<String, String>>> fieldMap = new HashMap<String, List<Map<String, String>>>();
		String[] fieldNames = null;
		// 循环获取对应的取值
		if (classObject != null) {
			Field[] fields = classObject.getDeclaredFields();
			if (fields != null) {
				fieldNames = new String[fields.length];
				for (int i = 0; i < fields.length; i++) {
					Field field = fields[i];
					List<Map<String, String>> typeParamMapList = new ArrayList<Map<String, String>>();
					String fieldName = field.getName();
					fieldNames[i] = fieldName;
					String fieldType = field.getType().getName();

					System.out.println("属性名字:" + fieldName + "属性类型" + fieldType);
					NotBlank notBlank = field.getAnnotation(NotBlank.class);
					String notBlankStr = "NotBlank";
					if (notBlank != null) {
						// 生成一个save的null方法
						Map<String, String> typeParamMap = new HashMap<String, String>();
						typeParamMap.put("fieldType", fieldType);
						typeParamMap.put("type", "NotBlank");
						typeParamMap.put("notBlank", "true");
						typeParamMapList.add(typeParamMap);
						// fieldMap.put(fieldName, typeParamMap);
					}
					Length length = field.getAnnotation(Length.class);
					if (length != null) {
						Map<String, String> typeParamMap = new HashMap<String, String>();
						typeParamMap.put("fieldType", fieldType);
						typeParamMap.put("type", "Length");
						int min = length.min();
						System.out.println("the min value is " + min);
						if (min != 0) {
							typeParamMap.put("minLength", String.valueOf(min));
						}
						int max = length.max();
						System.out.println("the max value is " + max);
						typeParamMap.put("maxLength", String.valueOf(max));
						typeParamMapList.add(typeParamMap);
						// fieldMap.put(fieldName, typeParamMap);
					}

					fieldMap.put(fieldName, typeParamMapList);
				}
			}

			// 代码模板
			String className = classObject.getName();
			className = className.substring(0, 1).toUpperCase() + className.substring(1);
			String methodName = "Save";
			String methodStr = " \n @Test \n @Transactional \n public void test%s%s%s() throws Exception{\n MvcResult mr = this.mockMvc.perform(MockMvcRequestBuilders.post(\"%s\")%s.headers(headers)).andReturn(); \n"
					+ "String result = mr.getResponse().getContentAsString(); \n Gson gson = new Gson(); \n"
					+ "ResponseJSON json = new ResponseJSON(); \n json = gson.fromJson(result, json.getClass());\n Assert.isTrue(json.getStatus() != null && %s.toString().equals(json.getStatus())); "
					+ " \n\n }\n";
			String params = "\n.param(\"%s\", \"%s\")";
			// System.out.println(
			// String.format(methodStr, methodName, upFieldName, notBlankStr,
			// url, fieldName));

			// 通过对应的map来生成代码
			StringBuffer paramsBuffer = new StringBuffer();

			if (fieldNames != null && fieldNames.length > 0) {

				for (String fieldName : fieldNames) {
					paramsBuffer.append(String.format(params, fieldName, 1));

				}
				System.out.println(paramsBuffer.toString());
			}
			String paramsStr = paramsBuffer.toString();
			// 默认生成全参数的方法
			String succStatus = "ResStatus.SUCCESS";

			if (fieldMap != null && !fieldMap.isEmpty()) {
				String noParamStatus = "ResStatus.PARAMCOMPLETE";
				Set<String> fieldNameKeys = fieldMap.keySet();
				for (String fieldName : fieldNameKeys) {
					List<Map<String, String>> fieldPropertyList = fieldMap.get(fieldName);
					String upFieldName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
					// 这里要判断null
					for (Map<String, String> fieldProperty : fieldPropertyList) {
						String typeName = fieldProperty.get("type");
						int index = new StringBuffer(paramsStr).indexOf(fieldName);
						int startIndex = index + fieldName.length() + 4;
						int endIndex = startIndex + 1;

						switch (typeName) {
						case "NotBlank":
							StringBuffer thisSB = new StringBuffer(paramsStr).replace(startIndex, endIndex, "");
							System.out.println(String.format(methodStr, methodName, upFieldName, typeName, url, thisSB,
									noParamStatus));
							break;
						case "Length":
							// 获取min值
							int commonLength = 0;
							String minStr = fieldProperty.get("minLength");
							if (minStr != null) {
								int minLength = Integer.valueOf(minStr);
								if (commonLength == 0) {
									commonLength = minLength;
								}
								minLength -= 1;
								StringBuffer paramsValue = new StringBuffer("");
								for (int i = 0; i < minLength; i++) {

									paramsValue.append("1");
								}
								StringBuffer minSb = new StringBuffer(paramsStr).replace(startIndex, endIndex,
										paramsValue.toString());
								StringBuffer typeNameMin = new StringBuffer(typeName);
								typeNameMin.append("min");
								System.out.println(String.format(methodStr, methodName, upFieldName, typeNameMin, url,
										minSb, noParamStatus));
							}
							// 获取max值
							String maxStr = fieldProperty.get("maxLength");
							if (maxStr != null) {
								int maxLength = Integer.valueOf(maxStr);
								if (commonLength == 0) {
									commonLength = maxLength;
								}
								maxLength += 1;
								StringBuffer paramsValue = new StringBuffer("");
								for (int i = 0; i < maxLength; i++) {

									paramsValue.append("1");
								}
								StringBuffer maxSb = new StringBuffer(paramsStr).replace(startIndex, endIndex,
										paramsValue.toString());
								StringBuffer typeNameMax = new StringBuffer(typeName);
								typeNameMax.append("max");
								System.out.println(String.format(methodStr, methodName, upFieldName, typeNameMax, url,
										maxSb, noParamStatus));
							}

							if (commonLength != 0) {
								StringBuffer paramsValue = new StringBuffer();
								for (int i = 0; i < commonLength; i++) {

									paramsValue.append("1");
								}
								paramsBuffer = new StringBuffer(paramsStr).replace(startIndex, endIndex,
										paramsValue.toString());
							}

							// 修改allParams方法中对应的参数为正常
							break;
						}

						// System.out.println(thisSB);
					}
				}

			}

			System.out.println(String.format(methodStr, methodName, "All", "Params", url, paramsBuffer, succStatus));

		}

	}

	public static void main(String[] args) {

		//generateTest(MerchantSaveRequest.class, "/mct/life/merchant/save.do");
	}

	

}
