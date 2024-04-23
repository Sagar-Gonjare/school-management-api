package org.dyanyog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.stereotype.Component;


@Entity
@Component
public class Fees {
    @Id
    @Column
    private long grnNumber;
    @Column
    private long totalFees;
    @Column 
    private long paidFees;
    @Column
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
