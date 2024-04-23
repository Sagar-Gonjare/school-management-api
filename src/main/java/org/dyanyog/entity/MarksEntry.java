package org.dyanyog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Table
@Entity
public class MarksEntry {
	
	
	@Column
	@Id
	private long grnNumber;
	
	
	@Column
	private String marathi;
	
	@Column
	private String english;
	
	@Column
	private String hindi;

	@Column
	private String science;
	
	@Column
	private String maths;
	
	@Column
	private String studentFirstName;
	
	

	
	public String getStudentFirstName() {
		return studentFirstName;
	}

	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}

	public long getGrnNumber() {
		return grnNumber;
	}

	public void setGrnNumber(long grnNumber) {
		this.grnNumber = grnNumber;
	}

	public String getMarathi() {
		return marathi;
	}

	public void setMarathi(String marathi) {
		this.marathi = marathi;
	}

	public String getEnglish() {
		return english;
	}

	public void setEnglish(String english) {
		this.english = english;
	}

	public String getHindi() {
		return hindi;
	}

	public void setHindi(String hindi) {
		this.hindi = hindi;
	}

	public String getScience() {
		return science;
	}

	public void setScience(String science) {
		this.science = science;
	}

	public String getMaths() {
		return maths;
	}

	public void setMaths(String maths) {
		this.maths = maths;
	}
	
	
	
}
