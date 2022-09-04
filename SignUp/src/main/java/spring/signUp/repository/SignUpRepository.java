package spring.signUp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import spring.signUp.domain.SignUp;


@Repository
public interface SignUpRepository extends JpaRepository<SignUp, Integer>, JpaSpecificationExecutor<SignUp>{
	
	Optional<SignUp> findByUserId(String userId);



}
