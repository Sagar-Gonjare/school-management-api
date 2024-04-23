package org.dyanyog.repository;

import org.dyanyog.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long>{
	//Notice findByScheduleId(String scheduleId);
	Notice findByDate(String date);
	Notice findByTitle(String title);

}