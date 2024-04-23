package org.dyanyog.repository;

import org.dyanyog.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<Exam,Long>{
	//Exam findByDate(String date);

	Exam findByClassNameAndExamDateAndSubjectAndExamName(String className, String examDate, String subject, String examName);

	//Exam save(Exam exam);
}
