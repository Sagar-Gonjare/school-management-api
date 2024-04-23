package org.dyanyog.dto.response;

import org.springframework.stereotype.Component;

@Component
public class GetTeacherProfileResponse {
	
	private Long teacherId;
	private String teacherFirstName;
	
	private String teacherLastName;
	private String teacherProfileImage;
	
	public Long getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherFirstName() {
		return teacherFirstName;
	}
	public void setTeacherFirstName(String teacherFirstName) {
		this.teacherFirstName = teacherFirstName;
	}
	public String getTeacherLastName() {
		return teacherLastName;
	}
	public void setTeacherLastName(String teacherLastName) {
		this.teacherLastName = teacherLastName;
	}
	public String getTeacherProfileImage() {
		return teacherProfileImage;
	}
	public void setTeacherProfileImage(String teacherProfileImage) {
		this.teacherProfileImage = teacherProfileImage;
	}
}
