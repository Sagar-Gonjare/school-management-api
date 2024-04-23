package org.dyanyog.dto.request;

import org.springframework.stereotype.Component;

@Component
public class LoginRequest 
{
	private String mobileNumber;
	private String passcode;
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPasscode() {
		return passcode;
	}
	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}

}
