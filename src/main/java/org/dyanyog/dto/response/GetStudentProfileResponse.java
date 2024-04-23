package org.dyanyog.dto.response;

import org.springframework.stereotype.Component;

@Component
public class GetStudentProfileResponse {
	
	private long grnNumber;
	private String studentProfileImage;
	private String studentFirstName;
	private String studentLastName;
	private String applyClass;
	
	public String getStudentFirstName() {
		return studentFirstName;
	}
	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}
	public String getStudentLastName() {
		return studentLastName;
	}
	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}
	public long getGrnNumber() {
		return grnNumber;
	}
	public void setGrnNumber(long grnNumber) {
		this.grnNumber = grnNumber;
	}
	public String getStudentProfileImage() {
		return studentProfileImage;
	}
	public void setStudentProfileImage(String studentProfileImage) {
		this.studentProfileImage = studentProfileImage;
	}
	public String getApplyClass() {
		return applyClass;
	}
	public void setApplyClass(String applyClass) {
		this.applyClass = applyClass;
	}
}
