package org.dyanyog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Table
@Entity
public class TotalFees {
	@Id
	@Column
	private long srNo;
	@Column
	private long totalFees;
	
	public long getSrNo() {
		return srNo;
	}
	public void setSrNo(long srNo) {
		this.srNo = srNo;
	}
	public long getTotalFees() {
		return totalFees;
	}
	public void setTotalFees(long totalFees) {
		this.totalFees = totalFees;
	}
}
