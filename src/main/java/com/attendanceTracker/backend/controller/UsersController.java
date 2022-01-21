package com.attendanceTracker.backend.controller;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.nio.file.FileSystemNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Id;
import javax.xml.crypto.Data;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attendanceTracker.backend.dto.StudentDetailsDto;
import com.attendanceTracker.backend.dto.UserDetailsDto;
import com.attendanceTracker.backend.model.User;
import com.attendanceTracker.backend.repository.UserRepository;
import com.attendanceTracker.backend.service.StudentService;
import com.attendanceTracker.backend.service.UserService;


@CrossOrigin(origins = "https://react-http-478ce.web.app/")
@RestController
@RequestMapping("/api/v1/")
public class UsersController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private StudentService studentService;
	
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
	
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		System.out.print(user.getPassword());
		 
		try {
		      byte[] iv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		      IvParameterSpec ivspec = new IvParameterSpec(iv);
		 
		      SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		      KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALT.getBytes(), 65536, 256);
		      SecretKey tmp = factory.generateSecret(spec);
		      SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
		 
		      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		      cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
		      
		     user.setPassword( Base64.getEncoder()
		          .encodeToString(cipher.doFinal(user.getPassword().getBytes(StandardCharsets.UTF_8))));
		    } catch (Exception e) {
		      System.out.println("Error while encrypting: " + e.toString());
		    }

		return userRepository.save(user);
	}
	
//	@GetMapping("/users_id/{useremail}")
//	public User getUsersById(@PathVariable("useremail") String useremail){
//		User user = userRepository.findByUseremail(useremail);
//		return user;
//	}
	
	@GetMapping("/users/{useremail}")
	public String checkUsersByEmailAndName(@PathVariable("useremail") String useremail){
		String message = "";
		User user = userRepository.findByUseremail("useremail");		
        
		if(user == null) {
			message = "true";
			
		}
		else 
			if( user.getUser_email().equals(useremail)) {
			message = "email exist";
		}
		else {
			message = "true"; 
		}
		return message;
	}
	
	@GetMapping("/signin/{useremail}/{userpassword}")
	public String checkUserByEmailandPassword(@PathVariable("useremail") String useremail,@PathVariable("userpassword") String userpassword) {
		User user = userRepository.findByUseremail(useremail);
		String isExist = "",emailUpperCase;
		String encrypedPasswordString ="";
		try {
	        byte[] iv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	        IvParameterSpec ivspec = new IvParameterSpec(iv);
	   
	        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
	        KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALT.getBytes(), 65536, 256);
	        SecretKey tmp = factory.generateSecret(spec);
	        SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
	   
	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
	         encrypedPasswordString =  new String(cipher.doFinal(Base64.getDecoder().decode(user.getPassword())));

	         if(user.getUser_email().toUpperCase().equals(useremail.toUpperCase()) && encrypedPasswordString.equals(userpassword)) {
	        	 isExist = "true";
	         }
	         else {
	        	 isExist =  "false";
	         }
		} catch (Exception e) {
			isExist =  "false";
	        System.out.println("Error while decrypting: " + e.toString());
	      }
		System.out.print(isExist);
		return isExist;
	    
	}
} 
