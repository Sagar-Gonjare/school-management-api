package org.dyanyog.dto.request;

import org.springframework.stereotype.Component;

@Component
public class TimetableRequest 
{
	private String timetableImage;
	private String className;
	public String getTimetableImage() {
		return timetableImage;
	}
	public void setTimetableImage(String timetableImage) {
		this.timetableImage = timetableImage;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
}
