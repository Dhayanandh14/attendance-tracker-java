package com.attendanceTracker.backend.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.swing.DefaultBoundedRangeModel;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendanceTracker.backend.dto.AttendanceDto;
import com.attendanceTracker.backend.dto.ReportDto;
import com.attendanceTracker.backend.dto.StudentDetailsDto;
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

	public long setId = 0;

	// Attendance Page

	private AttendanceDto convertEntityToDto(User user) {
		AttendanceDto attendanceDto = new AttendanceDto();
		attendanceDto = modelMapper.map(user, AttendanceDto.class);
		Attendance attendance = attendanceRepository.findByUserIdAndDate(user.getUser_id(), setDate);
		if (attendance == null) {
			attendanceRepository.insert(user.getUser_id(), setDate);
			attendance = attendanceRepository.findByUserIdAndDate(user.getUser_id(), setDate);
		}
		attendanceDto.setUserId(attendance.getUserId());
		attendanceDto.setId(attendance.getId());
		attendanceDto.setAttendance_status(attendance.getAttendance_status());
		attendanceDto.setAttendance_date(attendance.getAttendance_date());
		return attendanceDto;
	}

	public List<AttendanceDto> getAllUser() {
		return userRepository.findByRole("student").stream().map(this::convertEntityToDto).collect(Collectors.toList());
	}

	// report page get report by id

	public List<AttendanceDto> convertEntityToDto2(long id) {

		List<Attendance> attendance = attendanceRepository.findByUserId(id);
		List<AttendanceDto> listOfAttendanceDto = new ArrayList<AttendanceDto>();
		User user = userRepository.findById(id);
		for (Attendance a : attendance) {
			AttendanceDto attendanceDto = new AttendanceDto();
			attendanceDto.setUser_name(user.getUser_name());
			attendanceDto.setUser_email(user.getUser_email());
			attendanceDto.setUserId(a.getUserId());
			attendanceDto.setId(a.getId());
			attendanceDto.setAttendance_date(a.getAttendance_date());
			attendanceDto.setAttendance_status(a.getAttendance_status());
			listOfAttendanceDto.add(attendanceDto);
		}
		return listOfAttendanceDto;
	}
}
