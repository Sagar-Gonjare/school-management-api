package org.dyanyog.controller;


import java.util.List;

import org.dyanyog.dto.request.NoticeCreateRequest;
import org.dyanyog.dto.request.NoticeUpdateRequest;
import org.dyanyog.dto.response.NoticeResponse;
import org.dyanyog.entity.Notice;
import org.dyanyog.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeController {
	@Autowired 
	NoticeService service;
	
	@PostMapping(path = "notice/api/v1/create",produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<NoticeResponse>scheduled(@RequestBody NoticeCreateRequest request){
		
		return service.savedata(request);
	}
	
	
	@GetMapping(path = "notice/api/v1/show")
	public List<Notice> getNotice(){
		return service.getNotice();
	}

	
	@PutMapping(path="school/api/v1/notice/update")
	public NoticeResponse updateSchedule(@RequestBody NoticeUpdateRequest request) {
		System.out.println(request.getTitle());
		NoticeResponse response=new NoticeResponse();
		
		response.setMessage("Schedule Updated");
		response.setStatus("Success");
		
		return response;
	}
	
	/*
	@DeleteMapping(path="school/api/v1/notice/delete")
	public NoticeResponse deleteProduct(@RequestBody NoticeDeleteRequest request) {
		//System.out.println(request.getProductName());
		service.deleteNotice(request);
		NoticeResponse response=new NoticeResponse();
		
		response.setMessage("Deleted Successfully");
		response.setStatus("Success");
		System.out.println("Successfully Deleted");
		return response;
	}
	*/
}