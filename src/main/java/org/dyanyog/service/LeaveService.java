package org.dyanyog.service;

import java.util.List;

import org.dyanyog.dto.request.LeaveRequest;
import org.dyanyog.dto.response.LeaveResponse;
import org.dyanyog.entity.LeaveEntity;
import org.dyanyog.entity.Student;
import org.dyanyog.repository.LeaveRepository;
import org.dyanyog.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LeaveService {

	@Autowired
	LeaveEntity leave;
	@Autowired
	LeaveRepository leaveRepo;
	@Autowired
	LeaveResponse leaveResponse;
	@Autowired
	LeaveRequest leaveRequest;
	@Autowired
	Student student;
	@Autowired
	StudentRepository studentRepo;
	
	
	public ResponseEntity <LeaveResponse> savedata (LeaveRequest request){
		
		leaveResponse = new LeaveResponse ();
		leave = new LeaveEntity();
		
		 
		if(null!=leaveRepo.findByGrnNumber(request.getGrnNumber()))
		return getConflictResponse();
		
		student = studentRepo.findByGrnNumber(request.getGrnNumber());

		leave.setGrnNumber(request.getGrnNumber());
		leave.setStudentFirstName(student.getStudentFirstName());
		leave.setStudentLastName(student.getLastName());
		leave.setFromDate(request.getFromDate());
		leave.setToDate(request.getToDate());
		leave.setReason(request.getReason());
		leave.setStatus(request.getStatus());
		
		leave=leaveRepo.save(leave);
		
		leaveResponse.setStatus("Success");
		leaveResponse.setMessage("Leave Applied Successfully");

		return ResponseEntity .status(HttpStatus.CREATED).body(leaveResponse);
	}
	
	
	public ResponseEntity <LeaveResponse> approveLeave (LeaveRequest request){
		
		leaveResponse = new LeaveResponse ();
		leave = new LeaveEntity();
		
		 
		if(null==leaveRepo.findByGrnNumber(request.getGrnNumber()))
		return getConflictErrorResponse();

		leave = leaveRepo.findByGrnNumber(request.getGrnNumber());
		
		leave.setStatus(request.getStatus());
		
		leave=leaveRepo.save(leave);
		
		leaveResponse.setStatus("Success");
		leaveResponse.setMessage("Leave Approved Successfully");

		return ResponseEntity .status(HttpStatus.CREATED).body(leaveResponse);
	}
	
	
	public List<LeaveEntity>getLeaveDetails(){
		return leaveRepo.findAll();
	}
	

	private ResponseEntity<LeaveResponse> getConflictResponse() {
		
		LeaveResponse response = new LeaveResponse();
		response.setStatus("Error");
		response.setMessage("You have already pending Leave Application");

		return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
	}
	
	
	private ResponseEntity<LeaveResponse> getConflictErrorResponse() {
		
		LeaveResponse response = new LeaveResponse();
		response.setStatus("Error");
		response.setMessage("No such aplication from this GRN Number");

		return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
	}

	
	
}
