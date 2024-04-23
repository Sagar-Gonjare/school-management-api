package org.dyanyog.service;

import java.util.List;

import org.dyanyog.dto.request.ExamRequest;
import org.dyanyog.dto.response.ExamResponse;
import org.dyanyog.entity.Exam;
import org.dyanyog.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ExamService {
	@Autowired
	ExamRepository examRepo;
	@Autowired
	Exam exam;
	@Autowired
	ExamResponse examResponse;
	
	
	public ResponseEntity<ExamResponse> createExam(ExamRequest request){
		
		examResponse = new ExamResponse();
		exam = new  Exam();
		
		if (examRepo.findByClassNameAndExamDateAndSubjectAndExamName(request.getClassName(), request.getExamDate(), request.getSubject(), request.getExamName()) != null) {
			return getConflictExamResponse();
		}

		exam.setClassName(request.getClassName());
		exam.setExamDate(request.getExamDate());
		exam.setExamName(request.getExamName());
		exam.setSubject(request.getSubject());
		exam.setFullMarks(request.getFullMarks());
		exam.setPassingMarks(request.getPassingMarks());
		
		exam = examRepo.save(exam);
		
		examResponse.setStatus("Success");
		examResponse.setMessage("Exam scheduled Successfully");
		
		return ResponseEntity.status(HttpStatus.CREATED).body(examResponse);
	}
	
	
	public List<Exam> getExam() {
        return examRepo.findAll();
    }
	
	
	private ResponseEntity<ExamResponse> getConflictExamResponse() {
		
		ExamResponse response = new ExamResponse();
		response.setStatus("Error");
		response.setMessage("Exam is already scheduled");

		return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
	}
}
