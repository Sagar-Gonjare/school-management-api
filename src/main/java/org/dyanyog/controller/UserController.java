package org.dyanyog.controller;

import org.dyanyog.dto.request.LoginRequest;
import org.dyanyog.dto.request.RegistrationRequest;
import org.dyanyog.dto.response.LoginResponse;
import org.dyanyog.dto.response.RegistrationResponse;
import org.dyanyog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController 
{
	@Autowired
	UserService service;
	
	@PostMapping(path = "user/api/v1/registration",produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<RegistrationResponse>registration(@RequestBody RegistrationRequest request){
	
		return service.registration(request);
	}
	
	@PostMapping(path = "user/api/v1/login",produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<LoginResponse>login(@RequestBody LoginRequest request){
		
		return service.login(request);
	}

}
