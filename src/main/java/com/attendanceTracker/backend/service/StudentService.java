package com.attendanceTracker.backend.service;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendanceTracker.backend.dto.StudentDetailsDto;
import com.attendanceTracker.backend.model.Student;
import com.attendanceTracker.backend.model.User;
import com.attendanceTracker.backend.repository.StudentRepository;
import com.attendanceTracker.backend.repository.UserRepository;

@Service
public class StudentService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	private StudentDetailsDto convertEntityToDetailsDto(User user ) {
//		modelMapper.getConfiguration()
//        .setMatchingStrategy(MatchingStrategies.LOOSE);
		StudentDetailsDto studentDetailsDto = new StudentDetailsDto();
		studentDetailsDto = modelMapper.map(user, StudentDetailsDto.class);
		System.out.print(user.getUser_id());
		Student student = studentRepository.findByUserId(user.getUser_id());
		studentDetailsDto.setStudentId(student.getStudent_id());
		studentDetailsDto.setInterviewer(student.getInterviewer());
		studentDetailsDto.setDate_of_Join(student.getDate_of_Join());
		studentDetailsDto.setSquad_name(student.getSquad_name());
		studentDetailsDto.setEducation(student.getEducation());
		studentDetailsDto.setGrade(student.getGrade());
		studentDetailsDto.setInterviewer_review(student.getInterviewer_review());
		studentDetailsDto.setStatus(student.getStatus());
		
		return studentDetailsDto;
	}

	public List<StudentDetailsDto> getAllUserStudentDetails() {
		return userRepository.findByRole("student")
				.stream()
				.map(this::convertEntityToDetailsDto)
				.collect(Collectors.toList());
	}
	
}
