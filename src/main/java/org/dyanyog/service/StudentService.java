package org.dyanyog.service;

import org.dyanyog.dto.request.AdmissionRequest;
import org.dyanyog.dto.response.AdmissionData;
import org.dyanyog.dto.response.AdmissionResponse;
import org.dyanyog.dto.response.GetStudentCountResponse;
import org.dyanyog.dto.response.GetStudentProfileResponse;
import org.dyanyog.dto.response.TeacherResponse;
import org.dyanyog.entity.Student;
import org.dyanyog.entity.Users;
import org.dyanyog.repository.StudentRepository;
import org.dyanyog.repository.TeacherRepository;
import org.dyanyog.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentService 
{
	@Autowired
	UsersRepository userRepo;
	@Autowired
	StudentRepository studentRepo;
	@Autowired
	TeacherRepository teacherRepo;
	@Autowired
	Users user;
	@Autowired
	Student student;
	@Autowired
	AdmissionResponse admissionResponse; 
	@Autowired
	GetStudentCountResponse getStudentCountResponse; 
	
	@Autowired
	GetStudentProfileResponse getStudentProfileResponse;
	
	public ResponseEntity<AdmissionResponse> admission(AdmissionRequest request){
		
		admissionResponse = new AdmissionResponse();
		admissionResponse.setData(new AdmissionData());
		student = new Student();
		
		if (null != studentRepo.findByParentMobileNumber(request.getParentMobileNumber()))
			return getConflictMobileNumberResponse();
		if (null != studentRepo.findByStudentMobileNumber(request.getStudentMobileNumber()))
			return getConflictMobileNumberResponse();
		if (null != studentRepo.findByParentMobileNumber(request.getStudentMobileNumber()))
			return getConflictMobileNumberResponse();
		if (null != studentRepo.findByStudentMobileNumber(request.getParentMobileNumber()))
			return getConflictMobileNumberResponse();
		if (null != teacherRepo.findByMobile(request.getParentMobileNumber()))
			return getConflictMobileNumberResponse();
		if (null != teacherRepo.findByMobile(request.getStudentMobileNumber()))
			return getConflictMobileNumberResponse();
			
			
		
		if (null != teacherRepo.findByEmail(request.getEmail()))
				return getConflictEmailResponse();
		if (null != studentRepo.findByEmail(request.getEmail())) 
				return getConflictEmailResponse();
		
		
		student.setStudentFirstName(request.getStudentFirstName());
		student.setFatherFirstName(request.getFatherFirstName());
		student.setMotherFirstName(request.getMotherFirstName());
		student.setLastName(request.getLastName());
		student.setParentMobileNumber(request.getParentMobileNumber());
		student.setAddress(request.getAddress());
		student.setStudentBirthDate(request.getStudentBirthDate());
		student.setGender(request.getGender());
		student.setApplyClass(request.getApplyClass());
		student.setPreviousSchoolName(request.getPreviousSchoolName());
		student.setStudentMobileNumber(request.getStudentMobileNumber());
		student.setEmail(request.getEmail());
		student.setProfileImage(request.getProfileImage()); 
		
		student = studentRepo.save(student);
		
		admissionResponse.setStatus("Success");
		admissionResponse.setMessage("User Registered Successfully");
		admissionResponse.getData().setGrnNumber(student.getGrnNumber());
		admissionResponse.getData().setStudentFirstName(student.getStudentFirstName());
		admissionResponse.getData().setFatherFirstName(student.getFatherFirstName());
		admissionResponse.getData().setMotherFirstName(student.getMotherFirstName());
		admissionResponse.getData().setLastName(student.getLastName());
		admissionResponse.getData().setParentMobileNumber(student.getParentMobileNumber());
		admissionResponse.getData().setAddress(student.getAddress());
		admissionResponse.getData().setStudentBirthDate(student.getStudentBirthDate());
		admissionResponse.getData().setGender(student.getGender());
		admissionResponse.getData().setApplyClass(student.getApplyClass());
		admissionResponse.getData().setPreviousSchoolName(student.getPreviousSchoolName());
		admissionResponse.getData().setStudentMobileNumber(student.getStudentMobileNumber());
		admissionResponse.getData().setEmail(student.getEmail());
		admissionResponse.getData().setProfileImage(student.getProfileImage());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(admissionResponse);
	}
	
	public ResponseEntity<GetStudentProfileResponse> getStudentProfile(long grnNumber) {
		
		student = studentRepo.findByGrnNumber(grnNumber);

		getStudentProfileResponse.setGrnNumber(student.getGrnNumber());
		getStudentProfileResponse.setStudentProfileImage(student.getProfileImage());
		getStudentProfileResponse.setStudentFirstName(student.getStudentFirstName());
		getStudentProfileResponse.setStudentLastName(student.getLastName());
		getStudentProfileResponse.setApplyClass(student.getApplyClass());
		
		return  ResponseEntity.status(HttpStatus.CREATED).body(getStudentProfileResponse);
	}
	
	public ResponseEntity<GetStudentCountResponse> getStudentCount() {
		
		long count = studentRepo.count();

		getStudentCountResponse.setStudentCount(count);
		
		return  ResponseEntity.status(HttpStatus.CREATED).body(getStudentCountResponse);
	}
	
	private ResponseEntity<AdmissionResponse> getConflictMobileNumberResponse() {
		
		AdmissionResponse response = new AdmissionResponse();
		response.setStatus("Error");
		response.setMessage("Mobile number already registered");
		response.setData(null);

		return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
	}
	
	private ResponseEntity<AdmissionResponse> getConflictEmailResponse() {
		
		AdmissionResponse response = new AdmissionResponse();
		response.setStatus("Error");
		response.setMessage("Email is already registered");
		//response.setData(null);

		return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
	}
}
