package com.attendanceTracker.backend.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attendanceTracker.backend.dto.AttendanceDto;
import com.attendanceTracker.backend.model.Attendance;
import com.attendanceTracker.backend.repository.AttendanceRepository;
//import com.attendanceTracker.backend.service.AttendanceService;
import com.attendanceTracker.backend.service.StudentService;
import com.attendanceTracker.backend.service.AttendanceService;
import com.fasterxml.jackson.annotation.JsonFormat;

@CrossOrigin(origins = "http://localhost:3000") 
@RestController
@RequestMapping("/api/v1/")
//@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
public class AttendanceController {
	
	@Autowired
	private AttendanceRepository attendanceRepository;
	
	@Autowired
	private AttendanceService attendanceService;
		
//	@GetMapping("/attendance")
//	public List<AttendanceDto> getAllAttendance(){
//		return attendanceService.getAllUser();
//	}
	
	@GetMapping("/attendance/{date}")
	public List<AttendanceDto> getAllAttendanceByDate(@PathVariable ("date") String date){
		attendanceService.setAttendanceDate(date);
		List<AttendanceDto> attendanceDtos=  attendanceService.getAllUser();
		return attendanceDtos;
	}

	@PostMapping("/attendance") 
	public List<Attendance> createAttendance(@RequestBody List<Attendance> attendance) {
		System.out.println(attendance);
		return attendanceRepository.saveAll(attendance);
	}
	@PatchMapping("/attendance/")
	public ResponseEntity<List<Attendance>> updateAttendace(@RequestBody List<Attendance> updateAttendance){
		System.out.println(updateAttendance);
		List<Attendance> attendance = attendanceRepository.saveAll(updateAttendance);
		return ResponseEntity.ok(attendance);
	}  
}

