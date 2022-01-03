package com.attendanceTracker.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attendanceTracker.backend.model.Coach;
import com.attendanceTracker.backend.repository.CoachRepository;

import java.util.*;

@CrossOrigin(origins = "http:localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class CoachController {
	
	@Autowired
	private CoachRepository coachRepository;
	
	@GetMapping("/coach_details")
	public List<Coach>GetAllStudent(){
		return coachRepository.findAll();
	}
	
	@PostMapping("/coach_details")
	public Coach CreateCoachDetails(@RequestBody Coach coach) {
		return coachRepository.save(coach);
	}
	
	
	
}
