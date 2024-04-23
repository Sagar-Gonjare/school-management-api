package org.dyanyog.repository;

import org.dyanyog.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long>
{
	Users findByMobileNumber(String mobileNumber);

	Users findByPasscode(String passcode);

}
