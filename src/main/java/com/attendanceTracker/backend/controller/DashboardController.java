package com.attendanceTracker.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attendanceTracker.backend.model.Attendance;
import com.attendanceTracker.backend.repository.AttendanceRepository;
import com.attendanceTracker.backend.repository.UserRepository;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "https://react-http-478ce.web.app")
@RestController
@RequestMapping("/api/v1/")
public class DashboardController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AttendanceRepository attendanceRepository;

	// student count
	@GetMapping("/student_count")
	public long getStudentCount() {
		return userRepository.findByRole("student").size();
	}

	// Coach count
	@GetMapping("/coach_count")
	public long getCoachCount() {
		return userRepository.findByRole("coach").size();
	}
	
	@GetMapping("/total-student-attendance-count")
	public int[] getAttendancePercentage() {
		int[] arr = new int[12];
		int[] arr2 = new int[12];
		int[] totalArr = new int[arr.length+arr2.length];
		int date;
		String firstDate,lastDate;
		for(int i = 1; i <= 12; i++) {
			if(i==2) date=28;
			else if(i==4 || i==6 || i==8 || i==10) date=30;
			else date=31;
			
			if(i>=10) {
				firstDate = "2022"+i+""+"01";
				lastDate =  "2022"+i+""+date;
			}else {
				firstDate = "2022"+"0"+i+""+"01";
				lastDate =  "2022"+"0"+i+""+date;				
			}
			arr[i-1]=attendanceRepository.getAttendancePercentage(firstDate,lastDate);
			arr2[i-1]= attendanceRepository.getTotalAttendanceCount(firstDate,lastDate);
		}
		System.arraycopy(arr, 0, totalArr, 0, arr.length);
        System.arraycopy(arr2, 0, totalArr, arr.length, arr2.length);
		return totalArr;
	}
	
	
	@GetMapping("full-month-attendance/{date}/{date2}")
	public List<Integer> getEachdayCount(@PathVariable ("date") String date, @PathVariable ("date2") String date2) {
	 return attendanceRepository.getEachDayAttendanceCount(date,date2);
	}
//	@GetMapping("full-month-attendance-absent-count/{date}/{date2}")
//	public List<Integer> getEachDayAttendanceAbsentCount(@PathVariable ("date") String date, @PathVariable ("date2") String date2) {
//		return attendanceRepository.getEachDayAttendanceAbsentCount(date,date2);
//	}
	
	@GetMapping("/everyday_attendance_status_count/{date}")
	public Integer getEveryDayAttendancePresentCount(@PathVariable ("date") String date) {
		return attendanceRepository.getEveryDayAttendanceStatusCount(date);
	}
	
	@GetMapping("/everyday_attendance_status_absent_count/{date}")
	public Integer getEveryDayAttendanceAbsentCount(@PathVariable ("date") String date) {
		return attendanceRepository.getEveryDayAttendanceStatusAbsentCount(date);
	}
	
	
	
}	
