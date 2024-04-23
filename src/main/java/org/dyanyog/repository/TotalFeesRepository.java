package org.dyanyog.repository;

import org.dyanyog.entity.TotalFees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TotalFeesRepository extends JpaRepository<TotalFees,Long>{

	TotalFees findBySrNo(Long srNo);
}
