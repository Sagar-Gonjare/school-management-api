package org.dyanyog.controller;

import org.dyanyog.dto.request.TeacherRequest;
import org.dyanyog.dto.response.GetStudentProfileResponse;
import org.dyanyog.dto.response.GetTeacherCountResponse;
import org.dyanyog.dto.response.GetTeacherProfileResponse;
import org.dyanyog.dto.response.TeacherResponse;
import org.dyanyog.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {
	@Autowired 
	TeacherService service;
	
	@PostMapping(path = "teacher/api/v1/admission",produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<TeacherResponse>teacherprofile(@RequestBody TeacherRequest request){
		
		return service.savedata(request);
	}
	
	@GetMapping(path="teacher/api/v1/teacherProfile/{teacherId}")
	public ResponseEntity<GetTeacherProfileResponse> getTeacherProfile(@PathVariable long teacherId) {
		
		return service.getTeacherProfile(teacherId);
	}
	
	@GetMapping(path="teacher/api/v1/teacherCount")
	public ResponseEntity<GetTeacherCountResponse> getTeacherCount() {
		
		return service.getTeacherCount();
	}
}