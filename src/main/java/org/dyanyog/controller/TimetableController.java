package org.dyanyog.controller;

import org.dyanyog.dto.request.TimetableRequest;
import org.dyanyog.dto.response.GetTimetableImageResponse;
import org.dyanyog.dto.response.TimetableResponse;
import org.dyanyog.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimetableController 
{
	@Autowired
	TimetableService service;
	
	@PostMapping(path = "timetable/api/v1/create",produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<TimetableResponse>timetable(@RequestBody TimetableRequest request){
	
		return service.timetable(request);
	}
	
	@GetMapping(path="timetable/api/v1/show/{className}")
	public ResponseEntity<GetTimetableImageResponse> gettimetableImage(@PathVariable String className) {
			
		return service.gettimetableImage(className);
	}
	
}
