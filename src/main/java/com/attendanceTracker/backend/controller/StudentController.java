package com.attendanceTracker.backend.controller;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.attendanceTracker.backend.dto.StudentDetailsDto;
import com.attendanceTracker.backend.dto.UserDetailsDto;
import com.attendanceTracker.backend.dto.UserRequestDto;
import com.attendanceTracker.backend.model.Student;
import com.attendanceTracker.backend.model.User;
import com.attendanceTracker.backend.repository.StudentRepository;
import com.attendanceTracker.backend.repository.UserRepository;
import com.attendanceTracker.backend.service.UserService;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "https://react-http-478ce.web.app/")
@RestController
@RequestMapping("/api/v1/")
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/student_details")
	public List<Student> getAllStudentDetails(){
		return studentRepository.findAll();
	}
	
	@PostMapping("/student_details")
	public Student CreateStudentDetails(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	@GetMapping("/student_details/{id}")
	public Student getStudentDetails(@PathVariable("id") Long id) {
		Student student = studentRepository.findByUserId(id);
		return student;
	}
	@GetMapping("/students")
	public List<User> getUsersAndStudentDetails() {
		List<User> users = userRepository.findByRole("student");
		return users;
	}
	
	@GetMapping("/student_info/{id}")
	public List<UserDetailsDto> getAllStudentInfo(@PathVariable("id") Long id){
		return userService.getAllUserAndStudentDetails(id);
	}
	
	
	@PatchMapping("/student_info/{id}")
	public Boolean updateStudentInfo(@RequestBody UserRequestDto userRequestDto){
		Boolean edit =  userService.convertDtoToEntity(userRequestDto);
		return edit;
	}
	

	
}	
