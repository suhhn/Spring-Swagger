package spring.signUp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import spring.signUp.domain.SignUp;
import spring.signUp.service.SignUpService;

@RestController
public class SignUpController {
	
	@Autowired
	private SignUpService signUpService;
	
	// 1. 회원가입 API – WRITE
	@PostMapping("/SignUp")
	@ApiOperation(value = "회원 가입 API", notes = "새로운 사용자가 회원가입을 한다.")
	@ResponseBody
	public SignUp write(SignUp signUp) {
		
		return signUpService.saveUser(signUp);
		
	}
	
	// 2. 회원정보 조회 API – READ
	@GetMapping("/user")
	@ApiOperation(value = "회원정보 조회 API", notes = "회원 전체 정보를 조회한다.")
	@ResponseBody
	public List<SignUp> ReaduserAll() {
		List<SignUp> list = signUpService.selectUserAll();
		return list;
	}
	
	// 3. 회원정보 조회 API – READ
	@GetMapping("/user/{userId}")
	@ApiOperation(value = "회원정보 조회 API", notes = "특정 ID의 회원 정보를 조회한다.")
	@ResponseBody
	public SignUp ReadUser(@RequestParam("userId") String userId) {
		SignUp user = signUpService.findByUserId(userId);
		return user;
	}
	
	// 4. 회원정보 업데이트 API – UPDATE
	@PutMapping("/user/{userId}")
	@ApiOperation(value = "회원정보 업데이트 API - Put", notes = "특정 ID의 회원의 모든 정보를 한번에 수정한다.")
	@ResponseBody
	public SignUp update(@RequestParam("userId") String userId, SignUp signUp){
		SignUp user = signUpService.findByUserId(userId);
		
		user.setName(signUp.getName());
		user.setUserId(signUp.getUserId());
		user.setPassword(signUp.getPassword());
		user.setBirth(signUp.getBirth());
		user.setGender(signUp.getGender());
		user.setAddr(signUp.getAddr());
		user.setPhone_number(signUp.getPhone_number());
		
		return signUpService.saveUser(user);
	}
			
	// 4. 회원정보 업데이트 API – UPDATE
	@PatchMapping("/user/{userId}")
	@ApiOperation(value = "회원정보 업데이트 API - Patch", notes = "특정 ID의 회원의 비밀번호만 수정한다.")
	@ResponseBody
	public SignUp partialUpdate(@RequestParam("userId") String userId, @RequestParam("password") String password){
		SignUp user = signUpService.findByUserId(userId);
		user.setAddr(password);
		
		return signUpService.saveUser(user);
	}
		
	
	// 5. 회원정보 삭제 API – DELETE
	@DeleteMapping("/delete/user/{userId}")
	@ApiOperation(value = "회원정보 삭제 API", notes = "특정 ID의 회원 정보를 삭제한다.")
	@ResponseBody
	public String deleteUser(@RequestParam("userId") String userId) {
		signUpService.deleteUser(userId);
		return "해당 회원 정보가 정삭적으로 삭제되었습니다.";
	}
	
	
	
	
	

	
	

}
