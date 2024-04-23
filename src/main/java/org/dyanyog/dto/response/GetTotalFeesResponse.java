package org.dyanyog.dto.response;

import org.springframework.stereotype.Component;

@Component
public class GetTotalFeesResponse {
	
	private long totalFees;

	public long getTotalFees() {
		return totalFees;
	}
	public void setTotalFees(long totalFees) {
		this.totalFees = totalFees;
	}
}
