package org.dyanyog.dto.response;

import org.springframework.stereotype.Component;
@Component
public class TeacherData {
	private Long teacherId;

	private String firstName;
	
	private String lastName;
	
	private String education;
	
	private String teacherProfileImage ;

	private String teachingExperience;
	
	private String mobile;
	
	private String email;
	
	private String address;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getTeachingExperience() {
		return teachingExperience;
	}

	public void setTeachingExperience(String teachingExperience) {
		this.teachingExperience = teachingExperience;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherProfileImage() {
		return teacherProfileImage;
	}

	public void setTeacherProfileImage(String teacherProfileImage) {
		this.teacherProfileImage = teacherProfileImage;
	}

	
	
}
