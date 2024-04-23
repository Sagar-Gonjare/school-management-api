package org.dyanyog.dto.response;

import org.springframework.stereotype.Component;

@Component
public class GetTeacherCountResponse {
	private long teacherCount;

	public long getTeacherCount() {
		return teacherCount;
	}

	public void setTeacherCount(long teacherCount) {
		this.teacherCount = teacherCount;
	}
}
