package org.dyanyog.repository;

import org.dyanyog.entity.LeaveEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRepository extends JpaRepository<LeaveEntity, Long>{

	LeaveEntity findByGrnNumber(Long grnNumber); 
}
