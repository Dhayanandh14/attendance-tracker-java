package com.attendanceTracker.backend.dto;

import java.util.Date;

import javax.persistence.Column;

public class ReportDto {
	
	
	private long id;
	private String username;
	
	private String useremail;

	private long userId;

	private Date attendance_date;

	private Boolean attendance_status;

	public ReportDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReportDto(long id, String username, String useremail, long userId, Date attendance_date,
			Boolean attendance_status) {
		super();
		this.id = id;
		this.username = username;
		this.useremail = useremail;
		this.userId = userId;
		this.attendance_date = attendance_date;
		this.attendance_status = attendance_status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
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

	
}
