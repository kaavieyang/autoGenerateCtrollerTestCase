package com.kaavie.autoGenerateCtrollerTestCase;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/** 
* @author 作者 :kaavie 
* @version 创建时间：2015年11月29日 下午12:00:07 
* 类说明   测试生成是否生效
*/
public class TestClass {
	


	/**
	 * 
	 */
	
	public Set<String> modifySet=new HashSet<String>();
	private static final long serialVersionUID = 8926119711730830203L;
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 创建日间<br>
	 */
	private Date createDate = new Date();

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	/**
	 * <br>
	 * 说明:商家类别：1：餐饮；2：停车；3：住宿<br>
	 * 属性名: type<br>
	 * 类型: Integer<br>
	 * 数据库字段:type<br>
	 * 
	 * @author haipenge<br>
	 */
	private Integer type = 1;

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * <br>
	 * 说明:商家来源<br>
	 * 属性名: source<br>
	 * 类型: String<br>
	 * 数据库字段:source<br>
	 * 
	 * @author haipenge<br>
	 */
	@Pattern(regexp="^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}[0-9xX]$")
	private String source = "系统";

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * <br>
	 * 说明:是否匿名推荐<br>
	 * 属性名: isAnonymous<br>
	 * 类型: Boolean<br>
	 * 数据库字段:is_anonymous<br>
	 * 
	 * @author haipenge<br>
	 */
	private Boolean isAnonymous = false;

	public Boolean getIsAnonymous() {
		return isAnonymous;
	}

	public void setIsAnonymous(Boolean isAnonymous) {
		this.isAnonymous = isAnonymous;
	}

	/**
	 * <br>
	 * 说明:商家地址<br>
	 * 属性名: address<br>
	 * 类型: String<br>
	 * 数据库字段:address<br>
	 * 
	 * @author haipenge<br>
	 */
	@NotBlank(message="{merchant.address.notBlank}")
	@Length(max=255,message="{merchant.address.lengthLimit}")
	private String address = "";

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		modifySet.add("address");
		this.address = address;
	}

	/**
	 * <br>
	 * 说明:经度<br>
	 * 属性名: longitude<br>
	 * 类型: Double<br>
	 * 数据库字段:longitude<br>
	 * 
	 * @author haipenge<br>
	 */
	private Double longitude = 0d;

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		modifySet.add("longitude");
		this.longitude = longitude;
	}

	/**
	 * <br>
	 * 说明:纬度<br>
	 * 属性名: latitude<br>
	 * 类型: Double<br>
	 * 数据库字段:latitude<br>
	 * 
	 * @author haipenge<br>
	 */
	private Double latitude = 0d;

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		modifySet.add("latitude");
		this.latitude = latitude;
	}

	/**
	 * <br>
	 * 说明:商家名称<br>
	 * 属性名: mname<br>
	 * 类型: String<br>
	 * 数据库字段:mname<br>
	 * 
	 * @author haipenge<br>
	 */
	@NotBlank(message="{merchant.mname.notBlank}")
	@Length(max=255,message="{merchant.mname.lengthLimit}")
	private String mname ;

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		modifySet.add("mname");
		this.mname = mname;
	}

	/**
	 * <br>
	 * 说明:座机<br>
	 * 属性名: phone<br>
	 * 类型: String<br>
	 * 数据库字段:phone<br>
	 * @Pattern(regexp="(d+-)?(d{4}-?d{7}|d{3}-?d{8}|^d{7,8})(-d+)?")
	 * @author haipenge<br>
	 */
	private String phone;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		modifySet.add("phone");
		this.phone = phone;
	}

	/**
	 * <br>
	 * 说明:手机<br>
	 * 属性名: mobile<br>
	 * 类型: String<br>
	 * 数据库字段:mobile<br>
	 * 
	 * @author haipenge<br>
	 */
	private String mobile ;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		modifySet.add("mobile");
		this.mobile = mobile;
	}

	/**
	 * <br>
	 * 说明:人均消费<br>
	 * 属性名: expense<br>
	 * 类型: Float<br>
	 * 数据库字段:expense<br>
	 * 
	 * @author haipenge<br>
	 */
	private Float expense = 0f;

	public Float getExpense() {
		return expense;
	}

	public void setExpense(Float expense) {
		this.expense = expense;
	}

	/**
	 * <br>
	 * 说明:营业时间<br>
	 * 属性名: businessHours<br>
	 * 类型: String<br>
	 * 数据库字段:business_hours<br>
	 * 
	 * @author haipenge<br>
	 */
	private String businessHours = "";

	public String getBusinessHours() {
		return businessHours;
	}

	public void setBusinessHours(String businessHours) {
		this.businessHours = businessHours;
	}

	/**
	 * <br>
	 * 说明:图片<br>
	 * 属性名: pic<br>
	 * 类型: String<br>
	 * 数据库字段:pic<br>
	 * 
	 * @author haipenge<br>
	 */
	private String pic = "";

	public String getPic() {
		return this.pic;
	}

	public String getPicBase64() {
		return pic;
	}

	public void setPic(String pic) {
		modifySet.add("pic");
		this.pic = pic;
	}

	/**
	 * <br>
	 * 说明:备注<br>
	 * 属性名: remark<br>
	 * 类型: String<br>
	 * 数据库字段:remark<br>
	 * 
	 * @author haipenge<br>
	 */
	private String remark = "";

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		modifySet.add("remark");
		this.remark = remark;
	}


	/**
	 * 商家与用户的距离
	 */
	private Double distance = 0d;

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}





	/**
	 * <br>
	 * 说明:收藏数<br>
	 * 属性名: collectNum<br>
	 * 类型: int <br>
	 * 数据库字段:collect_num<br>
	 * 
	 * @author haipenge<br>
	 */
	private Integer collectNum=0;

	public Integer getCollectNum() {
		return collectNum;
	}

	public void setCollectNum(Integer collectNum) {
		this.collectNum = collectNum;
	}

	/**
	 * <br>
	 * 说明:评分<br>
	 * 属性名: grade<br>
	 * 类型: Double<br>
	 * 数据库字段:grade<br>
	 * 
	 * @author haipenge<br>
	 */
	private Double grade=0.0;

	public Double getGrade() {
		return grade;
	}

	public void setGrade(Double grade) {
		this.grade = grade;
	}



}
