package org.dyanyog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Table
@Entity
public class Timetable
{
	
	@Column
	private String className;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "timetable_srno")
	@Column
	private long srNo;
	
	@Lob
	private String timetableImage;
	

	public String getClassName() 
	{
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public long getSrNo() {
		return srNo;
	}
	public void setSrNo(long srNo) {
		this.srNo = srNo;
	}
	public String getTimetableImage() {
		return timetableImage;
	}
	public void setTimetableImage(String timetableImage) {
		this.timetableImage = timetableImage;
	}	
}
