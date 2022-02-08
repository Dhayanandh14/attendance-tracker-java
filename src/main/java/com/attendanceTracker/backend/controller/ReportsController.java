package com.attendanceTracker.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attendanceTracker.backend.model.Attendance;
import com.attendanceTracker.backend.repository.AttendanceRepository;

//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "https://react-http-478ce.web.app")
@RestController
@RequestMapping("/api/v1/")
public class ReportsController {
	
	@Autowired
	private AttendanceRepository attendanceRepository;
	
	// report by name and date range
	@GetMapping("/reports-by-name-and-date/{id}/{date1}/{date2}")
	public List<Attendance> reportsByNameAndDate(@PathVariable ("id") long id,@PathVariable("date1") String date1,@PathVariable ("date2") String date2){
		return attendanceRepository.getReportByNameAndDateRange(1, date1,date2);	
				
	}	
	
}
