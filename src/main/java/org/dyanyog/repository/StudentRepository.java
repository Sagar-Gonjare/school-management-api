package org.dyanyog.repository;

import org.dyanyog.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, String>
{
	Student findByParentMobileNumber(String parentMobileNumber);
	//Student findByGRNNumber(Long grnNumber);
	Student findByStudentMobileNumber(String studentMobileNumber);

	Student findByStudentFirstName(String studentFirstName);
	
	Student findByGrnNumber(long grnNumber);
	
	Student findByEmail(String email);
}
