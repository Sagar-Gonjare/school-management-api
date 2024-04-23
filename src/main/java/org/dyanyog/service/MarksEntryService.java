package org.dyanyog.service;

import java.util.List;

import org.dyanyog.dto.request.MarksEntryRequest;
import org.dyanyog.dto.response.MarksEntryData;
import org.dyanyog.dto.response.MarksEntryResponse;
import org.dyanyog.dto.response.ViewMarksByGetResponse;
import org.dyanyog.dto.response.ViewMarksByGetResponseForGrnNumber;
import org.dyanyog.entity.MarksEntry;
import org.dyanyog.entity.Student;
import org.dyanyog.repository.MarksEntryRepository;
import org.dyanyog.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MarksEntryService {

	@Autowired
	MarksEntryRepository marksRepo;
	@Autowired
	MarksEntry marksEntry;
	@Autowired
	MarksEntryResponse marksResponse;
	@Autowired
	MarksEntryRequest request;
	@Autowired
	List<MarksEntryData> marksEntryData;
	@Autowired
	ViewMarksByGetResponse viewMarksResponse;
	@Autowired
	StudentRepository studentRepo;
	@Autowired
	Student student;
	@Autowired
	ViewMarksByGetResponseForGrnNumber viewMarksResp;
	

	
	public ResponseEntity<MarksEntryResponse> marksEntry(MarksEntryRequest request) {
  		marksResponse = new MarksEntryResponse();

  		marksEntry=new MarksEntry();
  		
  		if(null==studentRepo.findByGrnNumber(request.getGrnNumber())) {   
			  return getConflictErrorMarksEntryResponse();
		}  
  		
  		if (null!= marksRepo.findByGrnNumber(request.getGrnNumber())) {
  			
  			marksEntry=marksRepo.findByGrnNumber(request.getGrnNumber()); 
  			
  			marksEntry.setGrnNumber(request.getGrnNumber());
  	  		marksEntry.setEnglish(request.getEnglish());
  	  		marksEntry.setHindi(request.getHindi());
  	  		marksEntry.setMarathi(request.getMarathi());
  	  		marksEntry.setMaths(request.getMaths());
  	  		marksEntry.setScience(request.getScience());
  	  		marksEntry=marksRepo.save(marksEntry);
  			marksResponse.setStatus("Success");
  			marksResponse.setMessage("Marks Updated");
  			return ResponseEntity.status(HttpStatus.CREATED).body(marksResponse);
  			//return getConflictMarksEntryResponse();
  		}
          
  		  
  		marksEntry.setGrnNumber(request.getGrnNumber());
  		marksEntry.setEnglish(request.getEnglish());
  		marksEntry.setHindi(request.getHindi());
  		marksEntry.setMarathi(request.getMarathi());
  		marksEntry.setMaths(request.getMaths());
  		marksEntry.setScience(request.getScience());
  		marksEntry=marksRepo.save(marksEntry);
		marksResponse.setStatus("Success");
		marksResponse.setMessage("Marks Entered Successfully");
		return ResponseEntity.status(HttpStatus.CREATED).body(marksResponse);

		
	}
	
	public ViewMarksByGetResponse getMarksByGrnNumber(long grnNumber) {
		  		   
		student=studentRepo.findByGrnNumber(grnNumber);
		
		if (null== studentRepo.findByGrnNumber(grnNumber)) {
			return getConflictMarksEntry1Response(); 
		}
		
		if (null== marksRepo.findByGrnNumber(grnNumber)) {
			return getConflictMarksEntry2Response(); 
		}
	         
		marksEntry=marksRepo.findByGrnNumber(grnNumber); 
		
		viewMarksResponse.setStatus("Success");
		viewMarksResponse.setMessage("Data Fetch Successfully");
		viewMarksResponse.setGrnNumber(marksEntry.getGrnNumber());
		viewMarksResponse.setStudentFirstName(student.getStudentFirstName());
		viewMarksResponse.setEnglish(marksEntry.getEnglish());
		viewMarksResponse.setHindi(marksEntry.getHindi());
		viewMarksResponse.setMarathi(marksEntry.getMarathi());
		viewMarksResponse.setMaths(marksEntry.getMaths());
		viewMarksResponse.setScience(marksEntry.getScience());
				
		return viewMarksResponse;
	}
  
	
    private ResponseEntity<MarksEntryResponse> getConflictErrorMarksEntryResponse() {
		
		MarksEntryResponse response = new MarksEntryResponse();
		response.setStatus("Error");
		response.setMessage("Student Not Exist");

		return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
 
    
    private ViewMarksByGetResponse getConflictMarksEntry1Response() {
	 
	 ViewMarksByGetResponse response = new ViewMarksByGetResponse();
		response.setStatus("Error");
		response.setMessage("Student Not Exist");

		return response;
    }
    
    private ViewMarksByGetResponse getConflictMarksEntry2Response() {
   	 
   	 ViewMarksByGetResponse response = new ViewMarksByGetResponse();
   		response.setStatus("Error");
   		response.setMessage("Marks has not entered yet");

   		return response;
    }
}