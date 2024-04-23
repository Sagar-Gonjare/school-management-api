package org.dyanyog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table 
@Component
public class Teacher {
	@Id
	@Column
	@GeneratedValue
	private Long teacherId;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String education;
	@Lob
	private String teacherProfileImage;
	@Column
	private String teachingExperience;
	@Column
	private String mobile;
	@Column
	private String email;
	@Column
	private String address;
	public Long getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}
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
	public String getTeacherProfileImage() {
		return teacherProfileImage;
	}
	public void setTeacherProfileImage(String teacherProfileImage) {
		this.teacherProfileImage = teacherProfileImage;
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
	
	
	

}