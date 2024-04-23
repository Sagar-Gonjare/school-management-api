package org.dyanyog.controller;

import org.dyanyog.dto.request.FeesRequest;
import org.dyanyog.dto.response.FeesResponse;
import org.dyanyog.service.FeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeesController {
   @Autowired 
   FeesService service;
   
   @PostMapping(path = "fees/api/v1/entry",produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
   public ResponseEntity<FeesResponse>createEntry(@RequestBody FeesRequest request){
		
		return service.createEntry(request);
	}
   
   @GetMapping("fees/api/v1/show/{grnNumber}")
	public FeesResponse getFees(@PathVariable long grnNumber) 
	{
		return service.getFees(grnNumber);
	}
}
