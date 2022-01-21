package com.attendanceTracker.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendanceTracker.backend.dto.CoachDetailsDto;
import com.attendanceTracker.backend.dto.CoachInfoDto;
import com.attendanceTracker.backend.dto.CoachRequestDto;
import com.attendanceTracker.backend.dto.StudentDetailsDto;
import com.attendanceTracker.backend.dto.UserRequestDto;
import com.attendanceTracker.backend.model.Coach;
import com.attendanceTracker.backend.model.User;
import com.attendanceTracker.backend.repository.CoachRepository;
import com.attendanceTracker.backend.repository.StudentRepository;
import com.attendanceTracker.backend.repository.UserRepository;

@Service
public class CoachService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CoachRepository coachRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	// add coach and list of coaches page 
	private CoachDetailsDto convertEntityToDto(User user) {
		CoachDetailsDto coachDetailsDto = new CoachDetailsDto();
		System.out.println(user.getUser_id());
		coachDetailsDto = modelMapper.map(user,CoachDetailsDto.class );
		coachDetailsDto.setId(user.getUser_id());
		System.out.print(coachDetailsDto.getId());
		Coach coach = coachRepository.findByUserId(user.getUser_id());
		coachDetailsDto.setProfile_job(coach.getProfile_job());
		coachDetailsDto.setStatus(coach.getStatus());
		return coachDetailsDto;
	}
	
	public List<CoachDetailsDto> getAllUserCoachDetails(){
		return userRepository.findByRole("coach")
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
				
	}
	
	
	// coaches info
	private CoachInfoDto convertUserEntityToDto(User user) {
		CoachInfoDto coachInfoDto = new CoachInfoDto();
		coachInfoDto = modelMapper.map(user, CoachInfoDto.class);
		coachInfoDto.setId(user.getUser_id());
		Coach coach = coachRepository.findByUserId(user.getUser_id());
		coachInfoDto.setUsername(user.getUser_name());
		coachInfoDto.setUseremail(user.getUser_email());
		coachInfoDto.setCoach_id(coach.getCoach_id());
		coachInfoDto.setProfile_job(coach.getProfile_job());
		coachInfoDto.setStatus(coach.getStatus());
		return coachInfoDto;
	}
	
	public List<CoachInfoDto>getAllCoachInfoDetails(Long id){
		return userRepository.findById(id)
				.stream()
				.map(this::convertUserEntityToDto)
				.collect(Collectors.toList());
	}
	
	
	
	// edit coach info details
	public Boolean convertDtoToEntity(CoachRequestDto coachRequestDto) {
	try {
		User user = userRepository.findById(coachRequestDto.getUser_id());
		System.out.print(userRepository.findById(coachRequestDto.getUser_id()));
		user = modelMapper.map(coachRequestDto, User.class);
		userRepository.save(user);
		Coach coach = coachRepository.findById(coachRequestDto.getCoach_id());
		coach = modelMapper.map(coachRequestDto, Coach.class);
		coachRepository.save(coach);
		return true;
		}
	catch (Exception e) {
		return false;
	}
	}
	
	
	
	
}
