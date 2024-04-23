package org.dyanyog.repository;


import org.dyanyog.entity.Fees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeesRepository extends JpaRepository<Fees, Long> {
	
	Fees findByGrnNumber(long grnNumber);
}

