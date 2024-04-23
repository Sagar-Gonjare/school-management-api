package org.dyanyog.dto.response;

import org.springframework.stereotype.Component;

@Component
public class ExamData {
	
	private long srNo;
	private String examName;
	private String className;
	private String subject;
	private String examDate;
	private long fullMarks;
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
	public String getExamDate() {
		return examDate;
	}
	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}
}
