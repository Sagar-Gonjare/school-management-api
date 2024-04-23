package org.dyanyog.dto.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdmissionResponse 
{
	private String status;
	private String message;
	@Autowired
	private AdmissionData data;
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
	public AdmissionData getData() {
		return data;
	}
	public void setData(AdmissionData data) {
		this.data = data;
	}
	

}
