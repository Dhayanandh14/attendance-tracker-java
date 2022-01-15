package com.attendanceTracker.backend.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.swing.DefaultBoundedRangeModel;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendanceTracker.backend.dto.AttendanceDto;
import com.attendanceTracker.backend.model.Attendance;
import com.attendanceTracker.backend.model.User;
import com.attendanceTracker.backend.repository.AttendanceRepository;
import com.attendanceTracker.backend.repository.UserRepository;

@Service
public class AttendanceService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AttendanceRepository attendanceRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public String setDate = "";
	public void setAttendanceDate(String date) {
		setDate = date;   
	}
	  private AttendanceDto convertEntityToDto(User user) {
		    AttendanceDto attendanceDto = new AttendanceDto();
		    attendanceDto = modelMapper.map(user, AttendanceDto.class);
		    Attendance attendance = attendanceRepository.findByUserIdAndDate(user.getUser_id(),setDate);

//		    System.out.println("Attendance check "+attendanceRepository.findById(1));  
//		    
		    if(attendance == null)  { 
		    	attendanceRepository.insert(user.getUser_id(),setDate); 
		    	attendance = attendanceRepository.findByUserIdAndDate(user.getUser_id(),setDate); 
		    }
			   attendanceDto.setUserId(attendance.getUserId());
			   attendanceDto.setId(attendance.getId());
			   attendanceDto.setAttendance_status(attendance.getAttendance_status());
			   attendanceDto.setAttendance_date(attendance.getAttendance_date());
			   return attendanceDto;
		}
	   
	  
//	  private AttendanceDto convertEntityToDto(User user) {
//		    AttendanceDto attendanceDto = new AttendanceDto();
//		    attendanceDto = modelMapper.map(user, AttendanceDto.class);
//		    Attendance attendance = attendanceRepository.findRecordByUserId(user.getUser_id());
//		    System.out.print(attendance);
//
//		    if(attendance != null) {
//			   attendanceDto.setUserId(attendance.getUserId());
//			   attendanceDto.setId(attendance.getId());
//			   attendanceDto.setAttendance_status(attendance.getAttendance_status());
//			   attendanceDto.setAttendance_date(attendance.getAttendance_date());
//			   return attendanceDto;
//		   }
//		   else return null;
//		}
	  

	public List<AttendanceDto>getAllUser(){
//		System.out.println(date);
		return userRepository.findByRole("student")
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}
}
