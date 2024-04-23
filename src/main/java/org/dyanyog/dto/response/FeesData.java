package org.dyanyog.dto.response;



import org.springframework.stereotype.Component;

@Component
public class FeesData {
	private long grnNumber;
    private long totalFees;
    private long paidFees;
    private long remainingFees;
    
    
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
