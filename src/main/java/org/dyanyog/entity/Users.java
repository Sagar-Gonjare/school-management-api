package org.dyanyog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Table
@Entity
public class Users 
{

	@Id
	@Column
	private String mobileNumber;
	
	@Column
	private long grnNumber;
	
	@Column
	private String passcode;

	@Column
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
