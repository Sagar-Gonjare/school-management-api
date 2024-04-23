package org.dyanyog.dto.request;

import org.springframework.stereotype.Component;

@Component
public class TotalFeesRequest {
    private long totalFees;

	public long getTotalFees() {
		return totalFees;
	}

	public void setTotalFees(long totalFees) {
		this.totalFees = totalFees;
	}
}
