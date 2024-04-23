package org.dyanyog.dto.response;


import org.springframework.stereotype.Component;

@Component
public class NoticeData {
	
	private String date;
	
	
	private String title;
	
	
	private String description;


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

}
