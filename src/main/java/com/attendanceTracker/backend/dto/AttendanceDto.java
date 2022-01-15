package com.attendanceTracker.backend.dto;

import java.util.Date;

import javax.persistence.Column;

public class AttendanceDto {
	private long id;
	
	private long userId;
	
	private Date attendance_date;
	
	private Boolean attendance_status;
	
	private String user_email;
	private String user_name;
	
	
	
	
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public Date getAttendance_date() {
		return attendance_date;
	}
	public void setAttendance_date(Date attendance_date) {
		this.attendance_date = attendance_date;
	}
	public Boolean getAttendance_status() {
		return attendance_status;
	}
	public void setAttendance_status(Boolean attendance_status) {
		this.attendance_status = attendance_status;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	
}
