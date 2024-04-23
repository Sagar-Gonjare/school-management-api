package org.dyanyog.repository;

import org.dyanyog.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>{
	//Teacher findByMobileAndEmail(String mobile,String email );
	Teacher findByMobile (String mobile);
	Teacher findByEmail (String email);
	Teacher findByTeacherId(long teacherId);
}