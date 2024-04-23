package org.dyanyog.controller;

import java.util.List;

import org.dyanyog.dto.request.LeaveRequest;
import org.dyanyog.dto.response.LeaveResponse;
import org.dyanyog.entity.LeaveEntity;
import org.dyanyog.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeaveController {

	@Autowired
	LeaveService service;
	
	
	@PostMapping(path = "leave/api/v1/create",produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<LeaveResponse>savedata(@RequestBody LeaveRequest request) {
			
			return service.savedata(request);
	}
	
	
	@PostMapping(path = "leave/api/v1/approve",produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<LeaveResponse>approveLeave(@RequestBody LeaveRequest request) {
			
			return service.approveLeave(request);
	}
	
	
	@GetMapping(path = "leavedata/api/v1/get")
	public List<LeaveEntity>getLeave(){
		return service.getLeaveDetails();
	}
}
