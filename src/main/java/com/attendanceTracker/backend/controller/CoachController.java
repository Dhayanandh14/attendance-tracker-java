package com.attendanceTracker.backend.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attendanceTracker.backend.dto.CoachDetailsDto;
import com.attendanceTracker.backend.dto.CoachInfoDto;
import com.attendanceTracker.backend.dto.CoachRequestDto;
import com.attendanceTracker.backend.dto.UserRequestDto;
import com.attendanceTracker.backend.model.Coach;
import com.attendanceTracker.backend.repository.CoachRepository;
import com.attendanceTracker.backend.service.CoachService;

import java.util.*;

//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "https://react-http-478ce.web.app/")
@RestController
@RequestMapping("/api/v1/")
public class CoachController {
	
	@Autowired
	private CoachRepository coachRepository;
	
	@Autowired
	private CoachService coachService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/coach_details")
	public List<Coach>GetAllStudent(){
		return coachRepository.findAll();
	}
	
	@PostMapping("/coach_details")
	public Coach CreateCoachDetails(@RequestBody Coach coach) {
		return coachRepository.save(coach);
	}
	
	@GetMapping("/user-coaches")
	public List<CoachDetailsDto> getAllCoachDetails(){
		return coachService.getAllUserCoachDetails();	   
	}
	
	@GetMapping("/coach-info/{id}")
	public List<CoachInfoDto>getAllCoachInfo(@PathVariable("id") Long id){
		return coachService.getAllCoachInfoDetails(id);
	}
	
	
	@PatchMapping("/coach-info/{id}")
	public Boolean UpdateCoachInfo(@RequestBody CoachRequestDto coachRequestDto) {
		Boolean edit = coachService.convertDtoToEntity(coachRequestDto);
		return edit;
	}
	
	
}
