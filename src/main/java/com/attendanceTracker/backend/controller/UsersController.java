package com.attendanceTracker.backend.controller;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.attendanceTracker.backend.dto.StudentDetailsDto;
import com.attendanceTracker.backend.model.User;
import com.attendanceTracker.backend.repository.UserRepository;
import com.attendanceTracker.backend.service.StudentService;


//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "https://react-http-478ce.web.app")
@RestController
@RequestMapping("/api/v1/")
public class UsersController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private StudentService studentService;
	
	private PasswordEncoder passwordEncoder;
	
	final String SECRET_KEY = "my_super_secret_key";
	final String SALT = "ssshhhhhhhhhhh!!!!";
	
	@GetMapping("/user-students")
	public List<StudentDetailsDto> getAllDetails(){
		return studentService.getAllUserStudentDetails();
	}
	
//	@PatchMapping("/users/")
//	public ResponseEntity<User>updateTable()
	
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userRepository.findAll();
		
	}
	
	@GetMapping("/get-all-names-and-id")
	public List<Object[]> getAllNameFromUsers(){
		return userRepository.getAllUserNames();
	}
	
	@PostMapping("/users/{check}")
	public Object createUser(@RequestBody User user,@PathVariable("check") String check) {
		System.out.println(check);
		passwordEncoder = new BCryptPasswordEncoder();
		String encodedPasswordString  = this.passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPasswordString);
		if(check.equals("yes")) return userRepository.save(user);
		else {
			userRepository.save(user);
			return "Success";
		}
//		 return "success";
//		return encodedPasswordString;
	}
	
	@GetMapping("/users/{useremail}")
	public String checkUsersByEmailAndName(@PathVariable("useremail") String useremail){
		String message = "";
		User user = userRepository.findByUseremail(useremail);		
        System.out.print(user);
		if(user == null) {
			message = "email not exist";	
		}
		else 
			if( user.getUser_email().equals(useremail)) {
			message = "email exist";
		}
		return message;
	}
	
	@GetMapping("/signin/{useremail}/{userpassword}")
	public Object checkUserByEmailandPassword(@PathVariable("useremail") String useremail,@PathVariable("userpassword") String userpassword) {
		User user = userRepository.findByUseremail(useremail);
		String isExist = "";
		String[] arr = new String[2];
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();  
         if(user.getUser_email().toUpperCase().equals(useremail.toUpperCase()) && encoder.matches(userpassword, user.getPassword())) {
        	 isExist = "true";
        	 arr[0]=user.getRole();
        	 arr[1]= isExist;
         }
         else {
        	 isExist =  "false";
        	 arr[0]=isExist;
         }
         System.out.print(user.getRole());
		return arr;
	    
	}
} 
