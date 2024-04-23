package org.dyanyog.repository;

import org.dyanyog.entity.Exam;
import org.dyanyog.entity.Timetable;
import org.dyanyog.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimetableRepository extends JpaRepository<Timetable,String>
{
	Timetable findByclassName(String className);
}
