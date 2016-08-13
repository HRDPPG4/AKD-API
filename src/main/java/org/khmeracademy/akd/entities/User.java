package org.khmeracademy.akd.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	@JsonProperty("USER_ID")
	private int userID;
	
	@JsonProperty("USER_NAME")
	private String name;
	
	@JsonProperty("PASSWORD")
	private String password;
	
	@JsonProperty("EMAIL")
	private String email;
	
	@JsonProperty("PHONE")
	private String phone;
	
	@JsonProperty("CREATED_DATE")
	private String createdDate;
	
	@JsonProperty("REMARK")
	private String remark;
	
	@JsonProperty("STATUS")
	private int status;
	
	@JsonProperty("USER_ROLE")
	private String role;
	
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
