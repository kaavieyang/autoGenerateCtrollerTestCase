package com.kaavie.autoGenerateCtrollerTestCase;

import junit.framework.Assert;

/**
 * @author 作者 :kaavie
 * @version 创建时间：2015年11月29日 下午4:12:19 类说明
 */
public class MyTestCase { 
	 @Test 
	 @Transactional 
	 public void testSaveMnameLengthMax() throws Exception{
	 MvcResult mr = this.mockMvc.perform(MockMvcRequestBuilders.post("/mct/life/merchant/save.do")
	.param("modifySet", "1")
	.param("serialVersionUID", "1")
	.param("id", "1")
	.param("createDate", "1")
	.param("type", "1")
	.param("source", "1")
	.param("isAnonymous", "1")
	.param("address", "1")
	.param("longitude", "1")
	.param("latitude", "1")
	.param("mname", "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111")
	.param("phone", "1")
	.param("mobile", "1")
	.param("expense", "1")
	.param("businessHours", "1")
	.param("pic", "1")
	.param("remark", "1")
	.param("distance", "1")
	.param("collectNum", "1")
	.param("grade", "1").headers(headers)).andReturn(); 
	String result = mr.getResponse().getContentAsString(); 
	 Gson gson = new Gson(); 
	ResponseJSON json = new ResponseJSON(); 
	 json = gson.fromJson(result, json.getClass());
	 Assert.isTrue(json.getStatus() != null && ResStatus.PARAMCOMPLETE.toString().equals(json.getStatus()));  

	 }

	 
	 @Test 
	 @Transactional 
	 public void testSaveMnameNotBlank() throws Exception{
	 MvcResult mr = this.mockMvc.perform(MockMvcRequestBuilders.post("/mct/life/merchant/save.do")
	.param("modifySet", "1")
	.param("serialVersionUID", "1")
	.param("id", "1")
	.param("createDate", "1")
	.param("type", "1")
	.param("source", "1")
	.param("isAnonymous", "1")
	.param("address", "1")
	.param("longitude", "1")
	.param("latitude", "1")
	.param("mname", "")
	.param("phone", "1")
	.param("mobile", "1")
	.param("expense", "1")
	.param("businessHours", "1")
	.param("pic", "1")
	.param("remark", "1")
	.param("distance", "1")
	.param("collectNum", "1")
	.param("grade", "1").headers(headers)).andReturn(); 
	String result = mr.getResponse().getContentAsString(); 
	 Gson gson = new Gson(); 
	ResponseJSON json = new ResponseJSON(); 
	 json = gson.fromJson(result, json.getClass());
	 Assert.isTrue(json.getStatus() != null && ResStatus.PARAMCOMPLETE.toString().equals(json.getStatus()));  

	 }

	 
	 @Test 
	 @Transactional 
	 public void testSaveSourcePattern() throws Exception{
	 MvcResult mr = this.mockMvc.perform(MockMvcRequestBuilders.post("/mct/life/merchant/save.do")
	.param("modifySet", "1")
	.param("serialVersionUID", "1")
	.param("id", "1")
	.param("createDate", "1")
	.param("type", "1")
	.param("source", "请填写不匹配正则表达式的内容")//表达式为^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}[0-9xX]$
	.param("isAnonymous", "1")
	.param("address", "1")
	.param("longitude", "1")
	.param("latitude", "1")
	.param("mname", "1")
	.param("phone", "1")
	.param("mobile", "1")
	.param("expense", "1")
	.param("businessHours", "1")
	.param("pic", "1")
	.param("remark", "1")
	.param("distance", "1")
	.param("collectNum", "1")
	.param("grade", "1").headers(headers)).andReturn(); 
	String result = mr.getResponse().getContentAsString(); 
	 Gson gson = new Gson(); 
	ResponseJSON json = new ResponseJSON(); 
	 json = gson.fromJson(result, json.getClass());
	 Assert.isTrue(json.getStatus() != null && ResStatus.PARAMCOMPLETE.toString().equals(json.getStatus()));  

	 }

	 
	 @Test 
	 @Transactional 
	 public void testSaveAddressLengthMax() throws Exception{
	 MvcResult mr = this.mockMvc.perform(MockMvcRequestBuilders.post("/mct/life/merchant/save.do")
	.param("modifySet", "1")
	.param("serialVersionUID", "1")
	.param("id", "1")
	.param("createDate", "1")
	.param("type", "1")
	.param("source", "1")
	.param("isAnonymous", "1")
	.param("address", "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111")
	.param("longitude", "1")
	.param("latitude", "1")
	.param("mname", "1")
	.param("phone", "1")
	.param("mobile", "1")
	.param("expense", "1")
	.param("businessHours", "1")
	.param("pic", "1")
	.param("remark", "1")
	.param("distance", "1")
	.param("collectNum", "1")
	.param("grade", "1").headers(headers)).andReturn(); 
	String result = mr.getResponse().getContentAsString(); 
	 Gson gson = new Gson(); 
	ResponseJSON json = new ResponseJSON(); 
	 json = gson.fromJson(result, json.getClass());
	 Assert.isTrue(json.getStatus() != null && ResStatus.PARAMCOMPLETE.toString().equals(json.getStatus()));  

	 }

	 
	 @Test 
	 @Transactional 
	 public void testSaveAddressNotBlank() throws Exception{
	 MvcResult mr = this.mockMvc.perform(MockMvcRequestBuilders.post("/mct/life/merchant/save.do")
	.param("modifySet", "1")
	.param("serialVersionUID", "1")
	.param("id", "1")
	.param("createDate", "1")
	.param("type", "1")
	.param("source", "1")
	.param("isAnonymous", "1")
	.param("address", "")
	.param("longitude", "1")
	.param("latitude", "1")
	.param("mname", "1")
	.param("phone", "1")
	.param("mobile", "1")
	.param("expense", "1")
	.param("businessHours", "1")
	.param("pic", "1")
	.param("remark", "1")
	.param("distance", "1")
	.param("collectNum", "1")
	.param("grade", "1").headers(headers)).andReturn(); 
	String result = mr.getResponse().getContentAsString(); 
	 Gson gson = new Gson(); 
	ResponseJSON json = new ResponseJSON(); 
	 json = gson.fromJson(result, json.getClass());
	 Assert.isTrue(json.getStatus() != null && ResStatus.PARAMCOMPLETE.toString().equals(json.getStatus()));  

	 }

	 
	 @Test 
	 @Transactional 
	 public void testSaveAllParams() throws Exception{
	 MvcResult mr = this.mockMvc.perform(MockMvcRequestBuilders.post("/mct/life/merchant/save.do")
	.param("modifySet", "1")
	.param("serialVersionUID", "1")
	.param("id", "1")
	.param("createDate", "1")
	.param("type", "1")
	.param("source", "请填写匹配正则表达式的内容")//表达式为^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}[0-9xX]$
	.param("isAnonymous", "1")
	.param("address", "111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111")
	.param("longitude", "1")
	.param("latitude", "1")
	.param("mname", "111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111")
	.param("phone", "1")
	.param("mobile", "1")
	.param("expense", "1")
	.param("businessHours", "1")
	.param("pic", "1")
	.param("remark", "1")
	.param("distance", "1")
	.param("collectNum", "1")
	.param("grade", "1").headers(headers)).andReturn(); 
	String result = mr.getResponse().getContentAsString(); 
	 Gson gson = new Gson(); 
	ResponseJSON json = new ResponseJSON(); 
	 json = gson.fromJson(result, json.getClass());
	 Assert.isTrue(json.getStatus() != null && ResStatus.SUCCESS.toString().equals(json.getStatus()));  

	 }

}
