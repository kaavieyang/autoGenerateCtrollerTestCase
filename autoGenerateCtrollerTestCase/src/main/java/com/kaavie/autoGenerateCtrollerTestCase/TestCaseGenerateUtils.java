package com.kaavie.autoGenerateCtrollerTestCase;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author 作者 :kaavie
 * @version 创建时间：2015年11月27日 下午7:49:09 类说明 测试用例生成工具类
 */
public class TestCaseGenerateUtils {
	// 当前可以处理的annotation类型
	private static Class[] objects = new Class[] { Length.class, NotBlank.class, Pattern.class };
	private static String handleMethodPrfix = "handle";
	private static String generateMethodPrfix = "generate";
	private static String methodName = "Save";
	private static String methodStr = " \n @Test \n @Transactional \n public void test%s%s%s() throws Exception{\n MvcResult mr = this.mockMvc.perform(MockMvcRequestBuilders.post(\"%s\")%s.headers(headers)).andReturn(); \n"
			+ "String result = mr.getResponse().getContentAsString(); \n Gson gson = new Gson(); \n"
			+ "ResponseJSON json = new ResponseJSON(); \n json = gson.fromJson(result, json.getClass());\n Assert.isTrue(json.getStatus() != null && %s.toString().equals(json.getStatus())); "
			+ " \n\n }\n";
	private static String params = "\n.param(\"%s\", \"%s\")";

	/**
	 * 
	 * @作者 kaavie
	 * @创建时间 Date:2015年11月28日下午1:49:36
	 * @输入
	 * @预计输出 通过注解生成对应的一些保存测试用例
	 * @remark:通过注解生成对应的一些保存测试用例
	 * @param classObject
	 *            ctroller中使用的一些需要验证的类
	 * @param url
	 *            save请求的url
	 * @return
	 */
	public static void generateTest(Class classObject, String url) {
		GenerateMethod generateMethod = new GenerateMethod();
		Map<String, List<Map<String, String>>> fieldMap = new HashMap<String, List<Map<String, String>>>();
		String[] fieldNames = null;
		// 循环获取对应的取值
		if (classObject != null) {
			Field[] fields = classObject.getDeclaredFields();
			if (fields != null) {
				fieldNames = new String[fields.length];
				for (int i = 0; i < fields.length; i++) {
					Field field = fields[i];

					String fieldName = field.getName();
					fieldNames[i] = fieldName;
					String fieldType = field.getType().getName();

				//	System.out.println("属性名字:" + fieldName + "属性类型" + fieldType);
					// 处理生成map
					if (objects != null) {
						for (Class object : objects) {
							Annotation annotation = field.getAnnotation(object);
							if (annotation != null) {
								List<Map<String, String>> typeParamMapList = fieldMap.get(field.getName());
								if (typeParamMapList == null) {
									typeParamMapList = new ArrayList<Map<String, String>>();
								}
								String annotationName = annotation.annotationType().getSimpleName();
								// 这里用反射主要是使代码变得更加灵活
								Method[] methods = GenerateMethod.class.getDeclaredMethods();
								if (methods != null) {
									for (Method method : methods) {

										if (method.getName().equals(handleMethodPrfix + annotationName)) {
											try {
												Object returnObject = method.invoke(generateMethod, annotation, field);
												if (returnObject != null) {
													typeParamMapList.addAll((List<Map<String, String>>) returnObject);
													fieldMap.put(field.getName(), typeParamMapList);
												}
											} catch (IllegalAccessException e) {
												e.printStackTrace();
											} catch (IllegalArgumentException e) {
												e.printStackTrace();
											} catch (InvocationTargetException e) {
												e.printStackTrace();
											}

										} else {
											// System.out.println("目前还有"+annotationName+"注解的代码没有自动生成,请联系制作者：kaavieyang@163.com");
										}

									}
								}

							}
						}
					}

				}
			}

			// 代码模板
			String className = classObject.getName();
			className = className.substring(0, 1).toUpperCase() + className.substring(1);

			// 通过对应的map来生成代码
			StringBuffer paramsBuffer = new StringBuffer();

			if (fieldNames != null && fieldNames.length > 0) {

				for (String fieldName : fieldNames) {
					paramsBuffer.append(String.format(params, fieldName, 1));

				}
			//	System.out.println(paramsBuffer.toString());
			}
			String paramsStr = paramsBuffer.toString();
			// 默认生成全参数的方法

			String succStatus = "ResStatus.SUCCESS";
			String noParamStatus = "ResStatus.PARAMCOMPLETE";
			if (fieldMap != null && !fieldMap.isEmpty()) {

				Set<String> fieldNameKeys = fieldMap.keySet();
				for (String fieldName : fieldNameKeys) {
					List<Map<String, String>> fieldPropertyList = fieldMap.get(fieldName);
					String upFieldName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
					// 这里要判断null
					for (Map<String, String> fieldProperty : fieldPropertyList) {
						String typeName = fieldProperty.get("type");
						Method[] methods = GenerateMethod.class.getDeclaredMethods();
						if (methods != null) {
							for (Method method : methods) {
								if (method.getName().equals(generateMethodPrfix + typeName)) {
									try {
										Object returnObject = method.invoke(generateMethod, fieldProperty, paramsStr,
												fieldName, methodStr, methodName, upFieldName, typeName, url,
												noParamStatus,paramsBuffer);
										if (returnObject != null) {
											paramsBuffer = new StringBuffer((String) returnObject);
										}
									} catch (IllegalAccessException e) {
										e.printStackTrace();
									} catch (IllegalArgumentException e) {
										e.printStackTrace();
									} catch (InvocationTargetException e) {
										e.printStackTrace();
									}
								}
							}
						}
					}
				}

			}

			System.out.println(String.format(methodStr, methodName, "All", "Params", url, paramsBuffer, succStatus));

		}

	}

	public static void main(String[] args) {
		generateTest(TestClass.class, "/mct/life/merchant/save.do");
	}

}
