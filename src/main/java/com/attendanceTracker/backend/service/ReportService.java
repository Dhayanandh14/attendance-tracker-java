package com.attendanceTracker.backend.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendanceTracker.backend.dto.ReportDto;
import com.attendanceTracker.backend.model.Attendance;
import com.attendanceTracker.backend.model.User;
import com.attendanceTracker.backend.repository.AttendanceRepository;
import com.attendanceTracker.backend.repository.UserRepository;

@Service
public class ReportService {
	@Autowired 
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private AttendanceRepository attendanceRepository;
	
	public String setDate1 = "";
	public String setDate2 = "";
	
	
	
	public List<ReportDto> convertEntityToDto(String date1,String date2){
		List<Attendance> attendance = attendanceRepository.findAllByAttendanceDate(date1,date2);
		System.out.print(attendance);
		List<ReportDto> listOfReportDto = new ArrayList<ReportDto>();
		List<User> user = userRepository.findAll();
		for(Attendance a: attendance) {
			ReportDto reportDto2 = new ReportDto();
			reportDto2.setAttendance_date(a.getAttendance_date());
			reportDto2.setAttendance_date(a.getAttendance_date());
			reportDto2.setId(a.getId());
			reportDto2.setUserId(a.getUserId());
			reportDto2.setAttendance_status(a.getAttendance_status());
			User user1 = userRepository.findById(a.getUserId());
			reportDto2.setUsername(user1.getUser_name());
			reportDto2.setUseremail(user1.getUser_email());
			listOfReportDto.add(reportDto2);
		}
		return listOfReportDto;
	}



	
	
}
