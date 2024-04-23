package org.dyanyog.dto.response;

import org.springframework.stereotype.Component;
@Component
public class TeacherResponse {
	private String status;
	private String massage;

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMassage() {
		return massage;
	}
	public void setMassage(String massage) {
		this.massage = massage;
	}
	
	
}