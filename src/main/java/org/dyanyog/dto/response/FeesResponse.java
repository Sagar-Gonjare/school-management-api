package org.dyanyog.dto.response;

import org.springframework.stereotype.Component;

@Component
public class FeesResponse {

	private String status;
	private String message;
	private long grnNumber;
    private long totalFees;
    private long paidFees;
    private long remainingFees;
    
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getGrnNumber() {
		return grnNumber;
	}
	public void setGrnNumber(long grnNumber) {
		this.grnNumber = grnNumber;
	}
	public long getTotalFees() {
		return totalFees;
	}
	public void setTotalFees(long totalFees) {
		this.totalFees = totalFees;
	}
	public long getPaidFees() {
		return paidFees;
	}
	public void setPaidFees(long paidFees) {
		this.paidFees = paidFees;
	}
	public long getRemainingFees() {
		return remainingFees;
	}
	public void setRemainingFees(long remainingFees) {
		this.remainingFees = remainingFees;
	}
    
	

}
