package org.khmeracademy.akd.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Category {
	@JsonProperty("CAT_ID")
	private String catID;
	
	@JsonProperty("CAT_NAME")
	private String catName;
	
	@JsonProperty("CREATED_DATE")	
	private String createdDate;
	
	@JsonProperty("REMARK")
	private String remark;
	
	@JsonProperty("PARENT_ID")
	private String parentID;
	
	@JsonProperty("STATUS")
	private int status;
	
	@JsonProperty("ICON")
	private String icon;
	
	@JsonProperty("SUB_CATEGORIES")
	private List<Category> subCategories;
	
	@JsonProperty("DOCUMENTS")
	private List<Document> documents;
	
	public Category() {
		
	}
	 
	
	public String getCatID() {
		return catID;
	}
	public void setCatID(String catID) {
		this.catID = catID;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
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
	public String getParentID() {
		return parentID;
	}
	public void setParentID(String parentID) {
		this.parentID = parentID;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}


	public String getIcon() {
		return icon;
	}


	public void setIcon(String icon) {
		this.icon = icon;
	}


	public List<Document> getDocuments() {
		return documents;
	}


	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}
	
}
