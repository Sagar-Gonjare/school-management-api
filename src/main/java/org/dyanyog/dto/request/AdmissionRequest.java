package org.dyanyog.dto.request;

import org.springframework.stereotype.Component;

@Component
public class AdmissionRequest 
{
	private String studentFirstName;
	private String fatherFirstName;
	private String motherFirstName;
	private String lastName;
	private String parentMobileNumber;
	private String address;
	private String studentBirthDate;
	private String gender;
	private String applyClass;
	private String previousSchoolName;
	private String studentMobileNumber;
	private String email;
	private String profileImage;

	public String getStudentFirstName() {
		return studentFirstName;
	}
	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}
	public String getFatherFirstName() {
		return fatherFirstName;
	}
	public void setFatherFirstName(String fatherFirstName) {
		this.fatherFirstName = fatherFirstName;
	}
	public String getMotherFirstName() {
		return motherFirstName;
	}
	public void setMotherFirstName(String motherFirstName) {
		this.motherFirstName = motherFirstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getParentMobileNumber() {
		return parentMobileNumber;
	}
	public void setParentMobileNumber(String parentMobileNumber) {
		this.parentMobileNumber = parentMobileNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStudentBirthDate() {
		return studentBirthDate;
	}
	public void setStudentBirthDate(String studentBirthDate) {
		this.studentBirthDate = studentBirthDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getApplyClass() {
		return applyClass;
	}
	public void setApplyClass(String applyClass) {
		this.applyClass = applyClass;
	}
	public String getPreviousSchoolName() {
		return previousSchoolName;
	}
	public void setPreviousSchoolName(String previousSchoolName) {
		this.previousSchoolName = previousSchoolName;
	}
	public String getStudentMobileNumber() {
		return studentMobileNumber;
	}
	public void setStudentMobileNumber(String studentMobileNumber) {
		this.studentMobileNumber = studentMobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
}
