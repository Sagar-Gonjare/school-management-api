package org.dyanyog.service;

import java.util.List;

import org.dyanyog.dto.request.NoticeCreateRequest;
import org.dyanyog.dto.response.NoticeResponse;
import org.dyanyog.entity.Notice;
import org.dyanyog.repository.NoticeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {
	
	@Autowired 
	NoticeRepository noticeRepo;
	@Autowired
	Notice notice;
	@Autowired 
	NoticeResponse noticeResponse;
	@Autowired
	NoticeCreateRequest request;

	
	public ResponseEntity <NoticeResponse> savedata (NoticeCreateRequest request){
		
		noticeResponse = new NoticeResponse ();
	//	scheduleresponse.setData(new NoticeData());
		notice=new Notice();
		
		if (null != noticeRepo.findByTitle(request.getTitle())) {
			return getConflictResponse();
		}

		notice.setDate(request.getDate());
		notice.setDescription(request.getDescription());
		notice.setTitle(request.getTitle());
		
		notice=noticeRepo.save(notice);
		
		noticeResponse.setStatus("Success");
		noticeResponse.setMessage("Notice created Successfully");

		return ResponseEntity .status(HttpStatus.CREATED).body(noticeResponse);
	}

	
	public List<Notice> getNotice() {
        return noticeRepo.findAll();
    }
	
	
	private ResponseEntity<NoticeResponse> getConflictResponse() {
		NoticeResponse response = new NoticeResponse();
		response.setStatus("Error");
		response.setMessage("Notice already Created");

		return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
	}
	
	/*
	public String deleteNotice(NoticeDeleteRequest reuest) {
		noticeRepo.findAll();
		return "Deleted SuccessFully";	
	}
	*/
}