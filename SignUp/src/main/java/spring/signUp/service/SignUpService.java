package spring.signUp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.signUp.domain.SignUp;
import spring.signUp.repository.SignUpRepository;

@Service
public class SignUpService {
	
	@Autowired
	private SignUpRepository signUpRepository;
	
	public SignUp saveUser(SignUp signUp) {
		return signUpRepository.save(signUp);
	}

	public SignUp findByUserId(String userId) {
		return signUpRepository.findByUserId(userId).get();
	}

	public List<SignUp> selectUserAll() {
		return signUpRepository.findAll();
	}

	public void deleteUser(String userId) {
		SignUp user = signUpRepository.findByUserId(userId).get();
		signUpRepository.delete(user);
	}

}
