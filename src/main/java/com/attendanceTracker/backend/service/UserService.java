package com.attendanceTracker.backend.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendanceTracker.backend.dto.StudentDetailsDto;
import com.attendanceTracker.backend.dto.UserDetailsDto;
import com.attendanceTracker.backend.model.Student;
import com.attendanceTracker.backend.model.User;
import com.attendanceTracker.backend.repository.StudentRepository;
import com.attendanceTracker.backend.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	private UserDetailsDto convertEntityToDetailsDto(User user) {
		UserDetailsDto userDetailsDto = new UserDetailsDto();
		userDetailsDto = modelMapper.map(user, UserDetailsDto.class);
		Student student = studentRepository.findByUserId(user.getUser_id());
		System.out.println(user);
		System.out.println(userDetailsDto);
//		userDetailsDto.setUsername(user.getUser_name());
        userDetailsDto.setStudent_id(student.getStudent_id());
        userDetailsDto.setInterviewer(student.getInterviewer());
        userDetailsDto.setDate_of_Join(student.getDate_of_Join());
        userDetailsDto.setSquad_name(student.getSquad_name());
        userDetailsDto.setEducation(student.getEducation());
        userDetailsDto.setGrade(student.getGrade());
        userDetailsDto.setInterviewer_review(student.getInterviewer_review());
        userDetailsDto.setStatus(student.getStatus());
        
        return userDetailsDto;
	}
	
//	public List<UserDetailsDto> getAllUserAndStudentDetails() {
//		return userRepository.findByRole("student")
//				.stream()
//				.map(this::convertEntityToDetailsDto)
//				.collect(Collectors.toList());
//	}
	
	public List<UserDetailsDto> getAllUserAndStudentDetails(Long id) {
		 return userRepository.findById(id)
				.stream()
				.map(this::convertEntityToDetailsDto)
				.collect(Collectors.toList());
	}


	
}
