package org.dyanyog.dto.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class LoginResponse 
{
	private String status;
	private String message;
	private long grnNumber;
	@Autowired
	private LoginData data;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LoginData getData() {
		return data;
	}
	public void setData(LoginData data) {
		this.data = data;
	}
	
	public long getGrnNumber() {
		return grnNumber;
	}
	
	public void setGrnNumber(long grnNumber) {
		this.grnNumber = grnNumber;
	}

}
