package org.dyanyog.controller;

import org.dyanyog.dto.request.AdmissionRequest;
import org.dyanyog.dto.response.AdmissionResponse;
import org.dyanyog.dto.response.GetStudentCountResponse;
import org.dyanyog.dto.response.GetStudentProfileResponse;
import org.dyanyog.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	@Autowired
	StudentService service;
	
	@PostMapping(path = "student/api/v1/admission",produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<AdmissionResponse>admission(@RequestBody AdmissionRequest request){
		
		return service.admission(request);
	}
	
	@GetMapping(path="student/api/v1/studentProfile/{grnNumber}")
	public ResponseEntity<GetStudentProfileResponse> getStudentProfile(@PathVariable long grnNumber) {
		
		return service.getStudentProfile(grnNumber);
	}
	
	@GetMapping(path="student/api/v1/studentCount")
	public ResponseEntity<GetStudentCountResponse> getStudentCount() {
		
		return service.getStudentCount();
	}
}