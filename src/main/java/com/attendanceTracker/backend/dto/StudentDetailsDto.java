package com.attendanceTracker.backend.dto;

import javax.persistence.Column;


public class StudentDetailsDto {
	
	private long user_id;
	private long id;
	private String user_email;
	private String user_name;
	

	private String access_id;
	public String getAccess_id() {
		return access_id;
	}

	public void setAccess_id(String access_id) {
		this.access_id = access_id;
	}

 
	private String squad_name;


	private String interviewer;


	private String date_of_Join;



	private String status;


	private String education;

	private String interviewer_review;


	private String grade;
	
	private Integer batch;

	public StudentDetailsDto(long user_id, long student_id, String user_email, String user_name, String squad_name,
			String interviewer, String date_of_Join, String status, String education, String interviewer_review,
			String grade,Integer batch) {
		super();
		this.user_id = user_id;
		this.id = student_id;
		this.user_email = user_email;
		this.user_name = user_name;
		this.squad_name = squad_name;
		this.interviewer = interviewer;
		this.date_of_Join = date_of_Join;
		this.status = status;
		this.education = education;
		this.interviewer_review = interviewer_review;
		this.grade = grade;
		this.batch = batch;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}


	
	public StudentDetailsDto() {
		
	}
	
	public long getStudentId() {
		return id;
	}


	public void setStudentId(long id) {
		this.id = id;
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


	public String getSquad_name() {
		return squad_name;
	}


	public void setSquad_name(String squad_name) {
		this.squad_name = squad_name;
	}


	public String getInterviewer() {
		return interviewer;
	}


	public void setInterviewer(String interviewer) {
		this.interviewer = interviewer;
	}


	public String getDate_of_Join() {
		return date_of_Join;
	}


	public void setDate_of_Join(String date_of_Join) {
		this.date_of_Join = date_of_Join;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getEducation() {
		return education;
	}


	public void setEducation(String education) {
		this.education = education;
	}


	public String getInterviewer_review() {
		return interviewer_review;
	}


	public void setInterviewer_review(String interviewer_review) {
		this.interviewer_review = interviewer_review;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Integer getBatch() {
		return batch;
	}

	public void setBatch(Integer batch) {
		this.batch = batch;
	}
	
	
}
