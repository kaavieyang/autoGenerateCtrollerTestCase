package com.kaavie.autoGenerateCtrollerTestCase;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author 作者 :kaavie
 * @version 创建时间：2015年11月29日 下午1:49:30 类说明
 */
public class GenerateMethod {

	private String allMethodStr = new String();

	public List<Map<String, String>> handleNotBlank(Annotation annotation, Field field) {
		NotBlank notBlank = (NotBlank) annotation;
		List<Map<String, String>> typeParamMapList = new ArrayList<Map<String, String>>();
		Map<String, String> typeParamMap = new HashMap<String, String>();
		typeParamMap.put("fieldType", field.getType().getName());
		typeParamMap.put("type", notBlank.annotationType().getSimpleName());
		typeParamMap.put("notBlank", "true");
		typeParamMapList.add(typeParamMap);
		return typeParamMapList;

	}

	public List<Map<String, String>> handleLength(Annotation annotation, Field field) {
		Length length = (Length) annotation;
		List<Map<String, String>> typeParamMapList = new ArrayList<Map<String, String>>();
		Map<String, String> typeParamMap = new HashMap<String, String>();
		typeParamMap.put("fieldType", field.getType().getName());
		typeParamMap.put("type", length.annotationType().getSimpleName());
		int min = length.min();
		int max = length.max();
		if (min != 0) {
			typeParamMap.put("minLength", String.valueOf(min));
		}
		typeParamMap.put("maxLength", String.valueOf(max));
		typeParamMapList.add(typeParamMap);
		return typeParamMapList;
	}

	public List<Map<String, String>> handlePattern(Annotation annotation, Field field) {
		Pattern pattern = (Pattern) annotation;
		List<Map<String, String>> typeParamMapList = new ArrayList<Map<String, String>>();
		Map<String, String> typeParamMap = new HashMap<String, String>();
		typeParamMap.put("fieldType", field.getType().getName());
		typeParamMap.put("type", pattern.annotationType().getSimpleName());
		String patternStr = pattern.regexp();
		typeParamMap.put("regexp", patternStr);
		typeParamMapList.add(typeParamMap);
		return typeParamMapList;
	}

	public String generateNotBlank(Map<String, String> fieldProperty, String paramsStr, String fieldName,
			String methodStr, String methodName, String upFieldName, String typeName, String url,
			String noParamStatus,StringBuffer paramsBuffer) {
		int index = new StringBuffer(paramsStr).indexOf(fieldName);
		int startIndex = index + fieldName.length() + 4;
		int endIndex = startIndex + 1;
		StringBuffer thisSB = new StringBuffer(paramsStr).replace(startIndex, endIndex, "");
		System.out.println(String.format(methodStr, methodName, upFieldName, typeName, url, thisSB, noParamStatus));
		return paramsBuffer.toString();
	}

	public String generateLength(Map<String, String> fieldProperty, String paramsStr, String fieldName,
			String methodStr, String methodName, String upFieldName, String typeName, String url,
			String noParamStatus,StringBuffer paramsBuffer) {
		int index = new StringBuffer(paramsStr).indexOf(fieldName);
		int startIndex = index + fieldName.length() + 4;
		int endIndex = startIndex + 1;
		// 获取min值
		int commonLength = 0;
		String minStr = fieldProperty.get("minLength");
		if (minStr != null) {
			int minLength = Integer.valueOf(minStr);
			if (commonLength == 0) {
				commonLength = minLength;
			}
			minLength -= 1;

			StringBuffer minSb = new StringBuffer(paramsStr).replace(startIndex, endIndex,
					generateStringLength(minLength));
			StringBuffer typeNameMin = new StringBuffer(typeName);
			typeNameMin.append("Min");
			System.out
					.println(String.format(methodStr, methodName, upFieldName, typeNameMin, url, minSb, noParamStatus));
		}
		// 获取max值
		String maxStr = fieldProperty.get("maxLength");
		if (maxStr != null) {
			int maxLength = Integer.valueOf(maxStr);
			if (commonLength == 0) {
				commonLength = maxLength;
			}
			maxLength += 1;
			StringBuffer maxSb = new StringBuffer(paramsStr).replace(startIndex, endIndex,
					generateStringLength(maxLength));
			StringBuffer typeNameMax = new StringBuffer(typeName);
			typeNameMax.append("Max");
			System.out
					.println(String.format(methodStr, methodName, upFieldName, typeNameMax, url, maxSb, noParamStatus));
		}
		if (commonLength != 0) {
			int paramsBufferIndex = paramsBuffer.indexOf(fieldName);
			int paramsBufferStartIndex = paramsBufferIndex + fieldName.length() + 4;
			int paramsBufferEndIndex = paramsBufferStartIndex + 1;
			
			paramsBuffer = paramsBuffer.replace(paramsBufferStartIndex, paramsBufferEndIndex,
					generateStringLength(commonLength));
			return paramsBuffer.toString();
		}

		return paramsBuffer.toString();
	}

	public String generatePattern(Map<String, String> fieldProperty, String paramsStr, String fieldName,
			String methodStr, String methodName, String upFieldName, String typeName, String url,
			String noParamStatus,StringBuffer paramsBuffer) {
		String regexp=fieldProperty.get("regexp");
		int index = new StringBuffer(paramsStr).indexOf(fieldName);
		int startIndex = index + fieldName.length() + 4;
		int endIndex = startIndex + 3;
		StringBuffer thisSB = new StringBuffer(paramsStr).replace(startIndex, endIndex, "请填写不匹配正则表达式的内容\")//表达式为"+regexp);
		System.out.println(String.format(methodStr, methodName, upFieldName, typeName, url, thisSB, noParamStatus));
		int paramsBufferIndex = paramsBuffer.indexOf(fieldName);
		int paramsBufferStartIndex = paramsBufferIndex + fieldName.length() + 4;
		int paramsBufferEndIndex = paramsBufferStartIndex + 3;
		
		 paramsBuffer = paramsBuffer.replace(paramsBufferStartIndex, paramsBufferEndIndex, "请填写匹配正则表达式的内容\")//表达式为"+regexp);
		return paramsBuffer.toString();
	}

	public String getAllMethodStr() {

		return this.allMethodStr;
	}

	private String generateStringLength(int length) {
		StringBuffer sb = new StringBuffer();
		if (length > 0) {
			int divisor = length / 10;
			int mode = length % 10;
			String tenLengthStr = "1111111111";
			String oneLengthStr = "1";
			if (divisor > 0) {
				for (int i = 0; i < divisor; i++) {
					sb.append(tenLengthStr);
				}
			}
			if (mode > 0) {
				for (int i = 0; i < mode; i++) {
					sb.append(oneLengthStr);
				}

			}
		}

		return sb.toString();
	}
}
