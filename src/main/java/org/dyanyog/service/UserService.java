package org.dyanyog.service;

import org.dyanyog.dto.request.LoginRequest;
import org.dyanyog.dto.request.RegistrationRequest;
import org.dyanyog.dto.response.LoginData;
import org.dyanyog.dto.response.LoginResponse;
import org.dyanyog.dto.response.RegistrationData;
import org.dyanyog.dto.response.RegistrationResponse;
import org.dyanyog.entity.Student;
import org.dyanyog.entity.Teacher;
import org.dyanyog.entity.Users;
import org.dyanyog.repository.StudentRepository;
import org.dyanyog.repository.TeacherRepository;
import org.dyanyog.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
	@Autowired
	UsersRepository userRepo;
	@Autowired
	StudentRepository studentRepo;
	@Autowired
	Users user;
	@Autowired
	Student student;
	@Autowired
	Teacher teacher;
	@Autowired
	TeacherRepository teacherRepo;
	@Autowired
	RegistrationResponse registrationResponse;
	@Autowired
	LoginResponse loginResponse;
	

	public ResponseEntity<RegistrationResponse> registration(RegistrationRequest request) {

		registrationResponse = new RegistrationResponse();
		registrationResponse.setData(new RegistrationData());
		user = new Users();
		
		student = studentRepo.findByStudentMobileNumber(request.getMobileNumber());
		
		if (null == studentRepo.findByParentMobileNumber(request.getMobileNumber())
				&& null == studentRepo.findByStudentMobileNumber(request.getMobileNumber())
				&& null == teacherRepo.findByMobile(request.getMobileNumber()))
			return getConflictInvalidMobNoResponse();
		
		if (null != userRepo.findByMobileNumber(request.getMobileNumber()))
			return getConflictDuplicateMobNoResponse();
		
		if (student != null && (student.getGrnNumber() != (request.getGrnNumber()))) {
			return getConflictIncorrectGrnNoResponse();
		}
		
		teacher = teacherRepo.findByMobile(request.getMobileNumber());
		if (teacher != null && (teacher.getTeacherId() != (request.getGrnNumber()))) {
			return getConflictIncorrectGrnNoResponse();
		}
		
		/*s
	 	exam = examRepo.findByExamName(request.getExamName()); 
		if((exam.getExmaName != (request.getExamName())
				|| exam.getClassName != (request.getClassName()) 
				|| exam.getDate != (request.getDate()))
				&& exam.findByExamName != (request.getExamName()))
		*/
		
		user.setMobileNumber(request.getMobileNumber());
		user.setGrnNumber(request.getGrnNumber());
		user.setPasscode(request.getPasscode());
		
		if (null != studentRepo.findByParentMobileNumber(request.getMobileNumber())) {
			user.setRole("Student");
		}
		
		if (null != studentRepo.findByStudentMobileNumber(request.getMobileNumber())){
			user.setRole("Student");
		}
		
		if (null != teacherRepo.findByMobile(request.getMobileNumber())){
			user.setRole("Teacher");
		}

		user = userRepo.save(user);

		registrationResponse.setStatus("Success");
		registrationResponse.setMessage("User Registered Successfully");
		registrationResponse.getData().setMobileNumber(user.getMobileNumber());
		registrationResponse.getData().setGrnNumber(user.getGrnNumber());
		registrationResponse.getData().setPasscode(user.getPasscode());
		registrationResponse.getData().setRole(user.getRole());

		return ResponseEntity.status(HttpStatus.CREATED).body(registrationResponse);
	}

	

	public ResponseEntity<LoginResponse> login(LoginRequest request) {

		loginResponse = new LoginResponse();
		loginResponse.setData(new LoginData());
		user = new Users();

		/*
		if (null != userRepo.findByMobileNumber(request.getMobileNumber())
				&& null != userRepo.findByPasscode(request.getPasscode())) {

			user = new Users();
			user.setMobileNumber(request.getMobileNumber());
			user.setPasscode(request.getPasscode());

			user = userRepo.findByMobileNumber(request.getMobileNumber());
			//user = userRepo.findByPasscode(request.getPasscode());
		*/
		
		user = userRepo.findByMobileNumber(request.getMobileNumber());
		if(user != null && user.getPasscode().contains(request.getPasscode())) {
		
			loginResponse.setStatus("Success");
			loginResponse.setMessage("Validation Successful");
			loginResponse.setGrnNumber(user.getGrnNumber());
			loginResponse.getData().setMobileNumber(user.getMobileNumber());
			loginResponse.getData().setRole(user.getRole());

			return ResponseEntity.status(HttpStatus.CREATED).body(loginResponse);
		}

		loginResponse.setStatus("Error");
		loginResponse.setMessage("Validation Failed");
		loginResponse.getData().setMobileNumber("");
		loginResponse.getData().setRole("");
		return ResponseEntity.status(HttpStatus.CONFLICT).body(loginResponse);
	}
	
	

	
	private ResponseEntity<RegistrationResponse> getConflictDuplicateMobNoResponse() {
		RegistrationResponse response = new RegistrationResponse();
		response.setStatus("Error");
		response.setMessage("Mobile Number already registered");
		response.setData(null);

		return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
	}
	
	private ResponseEntity<RegistrationResponse> getConflictInvalidMobNoResponse() {
		RegistrationResponse response = new RegistrationResponse();
		response.setStatus("Error");
		response.setMessage("Enter valid mobile number");
		response.setData(null);

		return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
	}
	
	private ResponseEntity<RegistrationResponse> getConflictIncorrectGrnNoResponse() {
		RegistrationResponse response = new RegistrationResponse();
		response.setStatus("Error");
		response.setMessage("Mobile Number and GRN Number is not matching");
		response.setData(null);

		return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
	}
}
