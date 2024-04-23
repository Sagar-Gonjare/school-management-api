package org.dyanyog.controller;


import org.dyanyog.dto.request.MarksEntryRequest;
import org.dyanyog.dto.response.MarksEntryResponse;
import org.dyanyog.dto.response.ViewMarksByGetResponse;
import org.dyanyog.service.MarksEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarksEntryController {

	@Autowired
	MarksEntryService service;
	
	@PostMapping(path = "result/api/v1/marksentry",produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<MarksEntryResponse>marksentry(@RequestBody MarksEntryRequest request){
	
		return service.marksEntry(request);
	}
	
	
	@GetMapping("result/api/v1/marksview/{grnNumber}")
	public ViewMarksByGetResponse viewMarksByGrnNumber(@PathVariable long grnNumber) 
	{
		return service.getMarksByGrnNumber(grnNumber);
	}
}
