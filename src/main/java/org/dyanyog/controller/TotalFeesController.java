package org.dyanyog.controller;

import org.dyanyog.dto.request.TotalFeesRequest;
import org.dyanyog.dto.response.GetTotalFeesResponse;
import org.dyanyog.dto.response.TotalFeesResponse;
import org.dyanyog.service.TotalFeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TotalFeesController {
	@Autowired 
	   TotalFeesService service;
	   
	@PostMapping(path = "totalFees/api/v1/update",produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<TotalFeesResponse>updateTotalFees(@RequestBody TotalFeesRequest request){
		
		return service.updateTotalFees(request);
	}
	   
	@GetMapping("totalFees/api/v1/getTotalFees" )
	public GetTotalFeesResponse getTotalFees() 
	{
		return service.getTotalFees();
	}   
}
