package org.dyanyog.service;

import org.dyanyog.dto.request.TimetableRequest;
import org.dyanyog.dto.response.ExamResponse;
import org.dyanyog.dto.response.GetStudentProfileResponse;
import org.dyanyog.dto.response.GetTimetableImageResponse;
import org.dyanyog.dto.response.RegistrationResponse;
import org.dyanyog.dto.response.TimetableResponse;
import org.dyanyog.entity.Timetable;
import org.dyanyog.repository.TimetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TimetableService
{
	@Autowired
	TimetableRepository timetableRepo;
	@Autowired
	Timetable timetable;
	@Autowired
	TimetableResponse timetableResponse;
	@Autowired
	GetTimetableImageResponse gettimetableImageResponse;
	
	

	public ResponseEntity<TimetableResponse> timetable(TimetableRequest request) {
		
		timetableResponse = new TimetableResponse();
		timetable= new Timetable();
		
		if (null != timetableRepo.findByclassName(request.getClassName())) {
			
			timetable=timetableRepo.findByclassName(request.getClassName());
			
			timetable.setClassName(request.getClassName());
			timetable.setTimetableImage(request.getTimetableImage());
			
			timetable = timetableRepo.save(timetable);
			
			timetableResponse.setStatus("Success");
			timetableResponse.setMessage("Timetable updated Successfully");
			
			return ResponseEntity.status(HttpStatus.CREATED).body(timetableResponse); 		
		}
		
		
		timetable.setClassName(request.getClassName());
		timetable.setTimetableImage(request.getTimetableImage());
		
		timetable = timetableRepo.save(timetable);
		
		timetableResponse.setStatus("Success");
		timetableResponse.setMessage("Timetable added Successfully");
		
		return ResponseEntity.status(HttpStatus.CREATED).body(timetableResponse);
	}
	
	
	public ResponseEntity<GetTimetableImageResponse> gettimetableImage(String className) {
		
		if (null == timetableRepo.findByclassName(className)) {
			
			gettimetableImageResponse.setClassName(className);
			gettimetableImageResponse.setTimetableImage("Timetable is not yet created.");
			return  ResponseEntity.status(HttpStatus.CREATED).body( gettimetableImageResponse);
		}
		
		
		timetable = timetableRepo.findByclassName(className);
		
		gettimetableImageResponse.setClassName(timetable.getClassName());
		gettimetableImageResponse.setTimetableImage(timetable.getTimetableImage());
		
		return  ResponseEntity.status(HttpStatus.CREATED).body( gettimetableImageResponse);
	}
}

	
	
	
