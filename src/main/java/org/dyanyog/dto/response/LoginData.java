package org.dyanyog.dto.response;

import org.springframework.stereotype.Component;

@Component
public class LoginData {
	
	private String mobileNumber;
	private String role;

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}