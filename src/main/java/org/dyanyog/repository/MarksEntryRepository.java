package org.dyanyog.repository;



import org.dyanyog.entity.MarksEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarksEntryRepository extends JpaRepository<MarksEntry, Long>{

	//MarksEntry findByClassNameAndExamNameAndSubjectAndGrnNumber(String className,String subject,String examName,long grnNumber);
	MarksEntry findByGrnNumber(long grnNumber);
	
}
