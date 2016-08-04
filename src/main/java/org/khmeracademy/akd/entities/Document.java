package org.khmeracademy.akd.entities;

public class Document {
	private int docID;
	private String name;
	private int view;
	private int share;
	private String URL;
	private String createdDate;
	private String remark;
	private int docTypeNum;
	private int userID;
	private int catID;
	private int status;
	
	public int getDocID() {
		return docID;
	}
	public void setDocID(int docID) {
		this.docID = docID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	public int getShare() {
		return share;
	}
	public void setShare(int share) {
		this.share = share;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
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
	public int getDocTypeNum() {
		return docTypeNum;
	}
	public void setDocTypeNum(int docTypeNum) {
		this.docTypeNum = docTypeNum;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getCatID() {
		return catID;
	}
	public void setCatID(int catID) {
		this.catID = catID;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}
