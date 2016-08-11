package org.khmeracademy.akd.response;



import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseList<T> extends Response {
	@JsonProperty("DATA")
	public List<T> data;
	
	@JsonProperty("PAGING")
	public Paging paging;
	
	public List<T> getData()
	{
		return data;
	}
	
	public void setData(ArrayList doc)
	{
		this.data=doc;
	}
	
	public Paging getPaging()
	{
		return paging;
	}
	
	
}
