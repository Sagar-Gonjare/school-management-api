package org.dyanyog.dto.response;

import org.springframework.stereotype.Component;

@Component
public class GetTimetableImageResponse 
{
	private String className;
	private String timetableImage;
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getTimetableImage() {
		return timetableImage;
	}
	public void setTimetableImage(String timetableImage) {
		this.timetableImage = timetableImage;
	}
}
