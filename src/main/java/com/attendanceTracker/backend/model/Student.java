package com.attendanceTracker.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "student_details")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "user_id")
	private long userId;
	
	@Column(name = "squad_name")
	private String squad_name;
	
	@Column(name = "interviewer")
	private String interviewer;
	
	
	@Column(name = "date_of_Join")
	private String date_of_Join;
	

	@Column(name = "status")
	private String status;
	
	@Column(name = "education")
	private String education;
	
	@Column(name = "interviewer_review")
	private String interviewer_review;
	
	@Column(name = "grade")
	private String grade;	

	
	public Student() {
		
	}
	public Student(long user_id, String squad_name, String interviewer, String date_of_Join, String status,
			String education, String interviewer_review, String grade) {
		super();
		this.userId = user_id;
		this.squad_name = squad_name;
		this.interviewer = interviewer;
		this.date_of_Join = date_of_Join;
		this.status = status;
		this.education = education;
		this.interviewer_review = interviewer_review;
		this.grade = grade;
	}

	public long getStudent_id() {
		return id;
	}

	public void setStudent_id(long student_id) {
		this.id = student_id;
	}

	public long getUser_id() {
		return userId;
	}

	public void setUser_id(long user_id) {
		this.userId = user_id;
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

}	
