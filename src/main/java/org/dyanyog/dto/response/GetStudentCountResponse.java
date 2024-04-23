package org.dyanyog.dto.response;

import org.springframework.stereotype.Component;

@Component
public class GetStudentCountResponse {
	private long studentCount;

	public long getStudentCount() {
		return studentCount;
	}

	public void setStudentCount(long studentCount) {
		this.studentCount = studentCount;
	}
}
