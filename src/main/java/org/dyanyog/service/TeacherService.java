package org.dyanyog.service;

import org.dyanyog.dto.request.TeacherRequest;
import org.dyanyog.dto.response.GetStudentCountResponse;
import org.dyanyog.dto.response.GetStudentProfileResponse;
import org.dyanyog.dto.response.GetTeacherCountResponse;
import org.dyanyog.dto.response.GetTeacherProfileResponse;
import org.dyanyog.dto.response.TeacherResponse;
import org.dyanyog.entity.Teacher;
import org.dyanyog.repository.StudentRepository;
import org.dyanyog.repository.TeacherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class TeacherService {
	@Autowired
	TeacherRepository teacherRepo;
	@Autowired
	StudentRepository studentRepo;
	@Autowired 
	Teacher teacher;
	@Autowired 
	TeacherResponse response;
	@Autowired 
	TeacherRequest request;
	@Autowired
	GetTeacherProfileResponse getTeacherProfileResponse;
	@Autowired
	GetTeacherCountResponse getTeacherCountResponse;

	
	public ResponseEntity <TeacherResponse> savedata (TeacherRequest request){
		
			response = new TeacherResponse();
		//	response.setData(new TeacherData());
			teacher=new Teacher();
			
			if (null != teacherRepo.findByMobile(request.getMobile())
				|| null != studentRepo.findByStudentMobileNumber(request.getMobile())
				|| null != studentRepo.findByParentMobileNumber(request.getMobile())) {
		
				return getConflictMobileNumberResponse();
			}
				
			if (null != teacherRepo.findByEmail(request.getEmail())
				|| null != studentRepo.findByEmail(request.getEmail())) {
				return getConflictEmailResponse();
			}
			
			teacher.setAddress(request.getAddress());
			teacher.setEducation(request.getEducation());
			teacher.setEmail(request.getEmail());
			teacher.setFirstName(request.getFirstName());
			teacher.setLastName(request.getLastName());
			teacher.setMobile(request.getMobile());
			teacher.setTeachingExperience(request.getTeachingExperience());
			teacher.setTeacherProfileImage(request.getTeacherProfileImage());

			
			teacher=teacherRepo.save(teacher);
			
			response.setStatus("Success");
			response.setMassage("Teacher's Data Added Successfully");	
		
		return ResponseEntity .status(HttpStatus.CREATED).body(response);
	}
	
	public ResponseEntity<GetTeacherProfileResponse> getTeacherProfile(long teacherId) {
		
		teacher = teacherRepo.findByTeacherId(teacherId);

		
		getTeacherProfileResponse.setTeacherId(teacher.getTeacherId());
		getTeacherProfileResponse.setTeacherFirstName(teacher.getFirstName());
		getTeacherProfileResponse.setTeacherLastName(teacher.getLastName());
		getTeacherProfileResponse.setTeacherProfileImage(teacher.getTeacherProfileImage());
		
		return  ResponseEntity.status(HttpStatus.CREATED).body(getTeacherProfileResponse);
	}
	
	public ResponseEntity<GetTeacherCountResponse> getTeacherCount() {
		
		long count = teacherRepo.count();

		getTeacherCountResponse.setTeacherCount(count);
		
		return  ResponseEntity.status(HttpStatus.CREATED).body(getTeacherCountResponse);
	}
	
	private ResponseEntity<TeacherResponse> getConflictMobileNumberResponse() {
		TeacherResponse response = new TeacherResponse();
		response.setStatus("error");
		response.setMassage("Mobile Number is already registered");
		//response.setData(null);

		return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
	}
	
	private ResponseEntity<TeacherResponse> getConflictEmailResponse() {
		TeacherResponse response = new TeacherResponse();
		response.setStatus("error");
		response.setMassage("Email is already registered");
		//response.setData(null);

		return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
	}
}