package org.dyanyog.dto.response;

import org.springframework.stereotype.Component;

@Component
public class MarksEntryData {

	private long grnNumber;
	private String marathi;
	private String hindi;
	private String english;
	private String science;
	private String maths;
	
	
	public long getGrnNumber() {
		return grnNumber;
	}
	public void setGrnNumber(long grnNumber) {
		this.grnNumber = grnNumber;
	}
	public String getMarathi() {
		return marathi;
	}
	public void setMarathi(String marathi) {
		this.marathi = marathi;
	}
	public String getHindi() {
		return hindi;
	}
	public void setHindi(String hindi) {
		this.hindi = hindi;
	}
	public String getEnglish() {
		return english;
	}
	public void setEnglish(String english) {
		this.english = english;
	}
	public String getScience() {
		return science;
	}
	public void setScience(String science) {
		this.science = science;
	}
	public String getMaths() {
		return maths;
	}
	public void setMaths(String maths) {
		this.maths = maths;
	}
	
	
	
	
}
