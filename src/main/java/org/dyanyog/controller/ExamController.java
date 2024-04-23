package org.dyanyog.controller;

import java.util.List;

import org.dyanyog.dto.request.ExamRequest;
import org.dyanyog.dto.response.ExamResponse;
import org.dyanyog.entity.Exam;
import org.dyanyog.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExamController {

	@Autowired
	ExamService service;
	@PostMapping(path = "exam/api/v1/create",produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<ExamResponse>exam(@RequestBody ExamRequest request){
	
		return service.createExam(request);
	}
	
	@GetMapping(path = "exam/api/v1/show")
	public List<Exam> getExam(){
		return service.getExam();
	}
}
