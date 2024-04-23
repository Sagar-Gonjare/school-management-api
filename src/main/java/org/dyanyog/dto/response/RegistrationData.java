package org.dyanyog.dto.response;

import org.springframework.stereotype.Component;

@Component
public class RegistrationData 
{
	private String mobileNumber;
	private long grnNumber;
	private String passcode;
	private String role;
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public long getGrnNumber() {
		return grnNumber;
	}
	public void setGrnNumber(long grnNumber) {
		this.grnNumber = grnNumber;
	}
	public String getPasscode() {
		return passcode;
	}
	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
