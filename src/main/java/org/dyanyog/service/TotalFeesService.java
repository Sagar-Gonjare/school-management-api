package org.dyanyog.service;

import org.dyanyog.dto.request.TotalFeesRequest;
import org.dyanyog.dto.response.FeesResponse;
import org.dyanyog.dto.response.GetTotalFeesResponse;
import org.dyanyog.dto.response.TotalFeesResponse;
import org.dyanyog.entity.TotalFees;
import org.dyanyog.repository.TotalFeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TotalFeesService {
	@Autowired
	TotalFeesRepository totalFeesRepo;
	@Autowired
	TotalFees totalFees;
	@Autowired
	TotalFeesRequest totalFeesRequest;
	@Autowired
	TotalFeesResponse response;
	@Autowired
	GetTotalFeesResponse getTotalFeesResponse;
	
	
	public ResponseEntity<TotalFeesResponse> updateTotalFees(TotalFeesRequest request) {
		
		response = new TotalFeesResponse();
		totalFees = new TotalFees();
		long srNo = 1;
		
		if (null == totalFeesRepo.findBySrNo(srNo)) {
			totalFees.setSrNo(srNo);
			totalFees.setTotalFees(request.getTotalFees());
			
			totalFees = totalFeesRepo.save(totalFees);
			
			response.setSrNo(totalFees.getSrNo());
			response.setTotalFees(totalFees.getTotalFees());
			response.setStatus("Success");
			response.setMessage("Total Fees Updated");
		}
		
		srNo = 1;
		totalFees = totalFeesRepo.findBySrNo(srNo);
		
		totalFees.setSrNo(1);
		totalFees.setTotalFees(request.getTotalFees());
		
		totalFees = totalFeesRepo.save(totalFees);
		
		response.setSrNo(totalFees.getSrNo());
		response.setTotalFees(totalFees.getTotalFees());
		response.setStatus("Success");
		response.setMessage("Total Fees Updated");
		
		return ResponseEntity .status(HttpStatus.CREATED).body(response);
	}
	
	
	public GetTotalFeesResponse getTotalFees() {
		   
		long srNo = 1;
		totalFees = totalFeesRepo.findBySrNo(srNo);
		
		getTotalFeesResponse.setTotalFees(totalFees.getTotalFees());
		
		return getTotalFeesResponse;
	}
}
