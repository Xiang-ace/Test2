package cn.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class User {
	private Integer id;
	private String userCode;
	private String userName;
	private String userPassword;
	private Integer gender;
	private Date birthday;
	private String phone;
	private String address;
	private Integer userRole;
	private Integer createdBy;
	private Date creationDate;
	private Integer age;
	private Roler role;

	private Integer modifyBy;
	private Date modifyDate;
	
	private String userPhoto;//用户头像
	
	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	public User() {
		super();
	}

	public User(Integer id, String userName, Integer gender, Date birthday,
			String phone, String address, Integer userRole) {
		super();
		this.id = id;
		this.userName = userName;
		this.gender = gender;
		this.birthday = birthday;
		this.phone = phone;
		this.address = address;
		this.userRole = userRole;
	}
	
	public User(Integer id, String userCode, String userName,
			String userPassword, Integer gender, Date birthday, String phone,
			String address, Integer userRole, Integer createdBy,
			Date creationDate, Integer modifyBy,
			Date modifyDate, String userPhoto) {
		super();
		this.id = id;
		this.userCode = userCode;
		this.userName = userName;
		this.userPassword = userPassword;
		this.gender = gender;
		this.birthday = birthday;
		this.phone = phone;
		this.address = address;
		this.userRole = userRole;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
		this.userPhoto = userPhoto;
	}

	public Roler getRole() {
		return role;
	}

	public void setRole(Roler role) {
		this.role = role;
	}

	public Integer getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Integer getAge() {
		//用当前时间减去出生日期获取年龄
		Calendar c1 = Calendar.getInstance();
		c1.setTime(new Date());
		Calendar c2 = Calendar.getInstance();
		c2.setTime(birthday);
		this.age = c1.get(Calendar.YEAR) - c2.get(Calendar.YEAR);
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(birthday != null){
			return sdf.format(birthday);
		}
		return null;
	}

	public void setBirthday(String birthday) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		this.birthday = sdf.parse(birthday);
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getUserRole() {
		return userRole;
	}

	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userCode=" + userCode + ", userName="
				+ userName + ", userPassword=" + userPassword + ", gender="
				+ gender + ", birthday=" + birthday + ", phone=" + phone
				+ ", address=" + address + ", userRole=" + userRole
				+ ", createdBy=" + createdBy + ", creationDate=" + creationDate
				+ ", age=" + age + ", role=" + role + ", modifyBy=" + modifyBy
				+ ", modifyDate=" + modifyDate + ", userPhoto=" + userPhoto
				+ "]";
	}

}
