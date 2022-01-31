package com.attendanceTracker.backend.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="attendance")
public class Attendance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "userId")
	private long userId;
	
	@Column(name = "attendance_date")
	private Date attendance_date;
	
	@Column(name = "attendance_status")
	private Boolean attendance_status;

	
	
	public Attendance() {
		id=0;
		userId=0;
		attendance_date=null;
		attendance_status=false;
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Attendance [id=" + id + ", userId=" + userId + ", attendance_date=" + attendance_date
				+ ", attendance_status=" + attendance_status + "]";
	}

	public Attendance(long id, long userId, Date attendance_date, Boolean attendance_status) {
		super();
		this.id = id;
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
