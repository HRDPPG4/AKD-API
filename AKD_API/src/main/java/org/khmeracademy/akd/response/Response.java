package org.khmeracademy.akd.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {
	@JsonProperty("CODE")
	public String code=ResponseCode.FAIL;
	
	@JsonProperty("MESSAGE")
	public String message;
	
	public String getCode()
	{
		return code;
	}
	
	public void setCode(String code)
	{
		this.code=code;
	}
	
}
