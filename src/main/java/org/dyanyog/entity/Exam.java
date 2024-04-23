package org.dyanyog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table
public class Exam {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "exam_srno")
	private long srNo;
	
	@Column
	private String examName;
	
	@Column
	private String className;
	
	@Column
	private String subject;
	
	@Column
	private String examDate;
	
	@Column
	private long fullMarks;
	
	@Column
	private long passingMarks;
	
	
	public long getSrNo() {
		return srNo;
	}

	public void setSrNo(long srNo) {
		this.srNo = srNo;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getExamDate() {
		return examDate;
	}

	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}

	public long getFullMarks() {
		return fullMarks;
	}

	public void setFullMarks(long fullMarks) {
		this.fullMarks = fullMarks;
	}

	public long getPassingMarks() {
		return passingMarks;
	}

	public void setPassingMarks(long passingMarks) {
		this.passingMarks = passingMarks;
	}	
}
