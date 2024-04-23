package org.dyanyog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Table
@Entity
public class Student 
{
	@Id
	@Column
	@GeneratedValue
	private long grnNumber;
	
	@Column
	private String studentFirstName;
	
	@Column
	private String fatherFirstName;
	
	@Column
	private String motherFirstName;
	
	@Column
	private String lastName;
	
	@Column
	private String parentMobileNumber;
	
	@Column
	private String address;
	
	@Column
	private String studentBirthDate;
	 
	@Column
	private String gender;
	
	@Column
	private String applyClass;
	
	@Column
	private String previousSchoolName;
	
	@Column
	private String studentMobileNumber;
	
	@Column
	private String email;
	
	@Lob
    private String profileImage;

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public long getGrnNumber() {
		return grnNumber;
	}

	public void setGrnNumber(long grnNumber) {
		this.grnNumber = grnNumber;
	}

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

	public Student orElse(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
}
