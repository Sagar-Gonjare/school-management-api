package org.dyanyog.dto.request;



import org.springframework.stereotype.Component;

@Component
public class FeesRequest {
	private long grnNumber;
    private long paidFees;
    //private long totalFees;
   // private long remainingFees;
	public long getGrnNumber() {
		return grnNumber;
	}
	public void setGrnNumber(long grnNumber) {
		this.grnNumber = grnNumber;
	}
	public long getPaidFees() {
		return paidFees;
	}
	public void setPaidFees(long paidFees) {
		this.paidFees = paidFees;
	}
    
	
}
