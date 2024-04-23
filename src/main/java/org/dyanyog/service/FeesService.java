package org.dyanyog.service;

import org.dyanyog.dto.request.FeesRequest;
import org.dyanyog.dto.response.AdmissionResponse;
import org.dyanyog.dto.response.FeesResponse;
import org.dyanyog.dto.response.MarksEntryResponse;
import org.dyanyog.dto.response.TotalFeesResponse;
import org.dyanyog.dto.response.ViewMarksByGetResponse;
import org.dyanyog.entity.Fees;
import org.dyanyog.entity.Student;
import org.dyanyog.entity.TotalFees;
import org.dyanyog.repository.FeesRepository;
import org.dyanyog.repository.StudentRepository;
import org.dyanyog.repository.TotalFeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FeesService {
	@Autowired 	
	FeesRepository feesRepo;
	@Autowired
	Fees fees;
	@Autowired 
	FeesResponse response;
	@Autowired
	Student student;
	@Autowired
	StudentRepository studentRepo;
	@Autowired
	FeesRequest request;
	@Autowired
	TotalFeesRepository totalFeesRepo;
	@Autowired
	TotalFees totalFees;
	@Autowired
	TotalFeesResponse totalFeesResponse;
	

	//static long totalFees=60000;
	
		
	public ResponseEntity<FeesResponse> createEntry(FeesRequest request) {
		response=new FeesResponse();
		fees =new Fees();
		
		long srNo = 1;
		totalFees = totalFeesRepo.findBySrNo(srNo);
		
		if(null==studentRepo.findByGrnNumber(request.getGrnNumber())) {   
			  return getConflictErrorResponse();
		}  
		
		fees = feesRepo.findByGrnNumber(request.getGrnNumber());
		
		if (null == feesRepo.findByGrnNumber(request.getGrnNumber())) {
			fees =new Fees();
			fees.setGrnNumber(request.getGrnNumber());
			fees.setTotalFees(totalFees.getTotalFees());
			fees.setPaidFees(0);
			fees.setRemainingFees(totalFees.getTotalFees());
			fees= feesRepo.save(fees);
			
			long paidFees = request.getPaidFees() + fees.getPaidFees();
			System.out.println(paidFees);
			
			
			long remainingFees = totalFees.getTotalFees() - paidFees;
			System.out.println(remainingFees);
			
			fees.setGrnNumber(request.getGrnNumber());
			fees.setPaidFees(paidFees);
			fees.setRemainingFees(remainingFees);
			fees.setTotalFees(totalFees.getTotalFees());
			
			fees= feesRepo.save(fees);
			

			response.setMessage("Fees Update Successfully");
			response.setStatus("Success");
			response.setGrnNumber(fees.getGrnNumber());
			response.setPaidFees(fees.getPaidFees());
			response.setRemainingFees(fees.getRemainingFees());
			response.setTotalFees(fees.getTotalFees());
			
			
			return ResponseEntity .status(HttpStatus.CREATED).body(response);
		}
			
		long paidFees = request.getPaidFees() + fees.getPaidFees();
		System.out.println(paidFees);
		
		long remainingFees = totalFees.getTotalFees()- paidFees;
		System.out.println(remainingFees);
		
		fees.setGrnNumber(request.getGrnNumber());
		fees.setPaidFees(paidFees);
		fees.setRemainingFees(remainingFees);
		fees.setTotalFees(totalFees.getTotalFees());
		
		fees= feesRepo.save(fees);

		response.setMessage("Fees Update Successfully");
		response.setStatus("Success");
		response.setGrnNumber(fees.getGrnNumber());
		response.setPaidFees(fees.getPaidFees());
		response.setRemainingFees(fees.getRemainingFees());
		response.setTotalFees(fees.getTotalFees());
		
		return ResponseEntity .status(HttpStatus.CREATED).body(response);
	}
	
	
	public FeesResponse getFees(long grnNumber) {
		   
		student=studentRepo.findByGrnNumber(grnNumber);
		
		
		if (null== studentRepo.findByGrnNumber(grnNumber)) {
			return getConflictStudentNotExistResponse(); 
		}
		
		if (null== feesRepo.findByGrnNumber(grnNumber)) {
			return getConflictEntireFeesPendingResponse(); 
		}
	         
		fees=feesRepo.findByGrnNumber(grnNumber); 
		
		response.setMessage("Fees Update Successfully");
		response.setStatus("Success");
		response.setGrnNumber(fees.getGrnNumber());
		response.setPaidFees(fees.getPaidFees());
		response.setRemainingFees(fees.getRemainingFees());
		response.setTotalFees(fees.getTotalFees());
				
		return response;
	}
	
	

	private ResponseEntity<FeesResponse> getConflictErrorResponse() {
		
		FeesResponse response = new FeesResponse();
		response.setStatus("Error");
		response.setMessage("Student Not Exist");

		return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
	
	
	private FeesResponse getConflictStudentNotExistResponse() {
	   	 
		FeesResponse response = new FeesResponse();
	   	response.setStatus("Error");
	   	response.setMessage("Student Not Exist");

	   	return response;
	}
	 
	private FeesResponse getConflictEntireFeesPendingResponse() {
	   	 
		FeesResponse response = new FeesResponse();
		response.setStatus("Success");
		response.setMessage("Entire Fee is pending");
		
		return response;
	}
	
}
