package org.khmeracademy.akd.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Document {
	@JsonProperty("DOC_ID")
	private String docID;
	
	@JsonProperty("TITLE")
	private String title;
	
	@JsonProperty("DES")
	private String des;
	
	@JsonProperty("EMBEDED_LINK")
	private String embedLink;
	
	@JsonProperty("THUMBNAIL_URL")
	private String thumbnailURL;
	
	@JsonProperty("EXPORT_LINK")
	private String exportLink;
	
	@JsonProperty("VIEW")
	private int view;
	
	@JsonProperty("SHARE")
	private int share;
	
	@JsonProperty("CREATED_DATE")
	private String createdDate;
	
	@JsonProperty("DOC_TYPE_NUM")
	private int docTypeNum;
	
	@JsonProperty("USER_ID")
	private int userID;
	
	@JsonProperty("CAT_ID")
	private String catID;
	
	@JsonProperty("STATUS")
	private int status;
	
	
	
	public String getDocID() {
		return docID;
	}
	public void setDocID(String docID) {
		this.docID = docID;
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
	
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
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
	public String getCatID() {
		return catID;
	}
	public void setCatID(String catID) {
		this.catID = catID;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getExportLink() {
		return exportLink;
	}
	public void setExportLink(String exportLink) {
		this.exportLink = exportLink;
	}	
	public String getThumbnailURL() {
		return thumbnailURL;
	}
	public void setThumbnailURL(String thumbnailURL) {
		this.thumbnailURL = thumbnailURL;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getEmbedLink() {
		return embedLink;
	}
	public void setEmbedLink(String embedLink) {
		this.embedLink = embedLink;
	}
	
	
	
}
