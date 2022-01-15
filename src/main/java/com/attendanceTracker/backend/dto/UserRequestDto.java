package com.attendanceTracker.backend.dto;

import java.security.KeyStore.PrivateKeyEntry;

import javax.persistence.Column;

public class UserRequestDto {
	private long user_id;
	private String user_name;
	
	private String user_email;
	private String role;
	
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	private String access_id;
	private int age;
	private Long phone_number;
	
	private String gender;
	
	private String communication_address;
	
	private String home_address;
	
	private long Aadhar_number;
	
	private String blood_group;
	
	private String personal_email;

	private String emergency_contact_name;
	
	private long emergency_contact_number;
	
	private long student_id;
	
	private long userId;
	
	private String squad_name;

	private String interviewer;
	
	private String date_of_Join;
	
	private String status;
	
	private String education;
	
	private String interviewer_review;
	private String grade;
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getAccess_id() {
		return access_id;
	}
	public void setAccess_id(String access_id) {
		this.access_id = access_id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Long getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(Long phone_number) {
		this.phone_number = phone_number;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCommunication_address() {
		return communication_address;
	}
	public void setCommunication_address(String communication_address) {
		this.communication_address = communication_address;
	}
	public String getHome_address() {
		return home_address;
	}
	public void setHome_address(String home_address) {
		this.home_address = home_address;
	}
	public long getAadhar_number() {
		return Aadhar_number;
	}
	public void setAadhar_number(long aadhar_number) {
		Aadhar_number = aadhar_number;
	}
	public String getBlood_group() {
		return blood_group;
	}
	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}
	public String getPersonal_email() {
		return personal_email;
	}
	public void setPersonal_email(String personal_email) {
		this.personal_email = personal_email;
	}
	public String getEmergency_contact_name() {
		return emergency_contact_name;
	}
	public void setEmergency_contact_name(String emergency_contact_name) {
		this.emergency_contact_name = emergency_contact_name;
	}
	public long getEmergency_contact_number() {
		return emergency_contact_number;
	}
	public void setEmergency_contact_number(long emergency_contact_number) {
		this.emergency_contact_number = emergency_contact_number;
	}
	public long getStudent_id() {
		return student_id;
	}
	public void setStudent_id(long student_id) {
		this.student_id = student_id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
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
	public UserRequestDto(){}
	
	public UserRequestDto(String user_name, String access_id, int age, Long phone_number, String gender,
			String communication_address, String home_address, long aadhar_number, String blood_group,
			String personal_email, String emergency_contact_name, long emergency_contact_number, long student_id,
			long userId, String squad_name, String interviewer, String date_of_Join, String status, String education,
			String interviewer_review, String grade) {
		super();
		this.user_name = user_name;
		this.access_id = access_id;
		this.age = age;
		this.phone_number = phone_number;
		this.gender = gender;
		this.communication_address = communication_address;
		this.home_address = home_address;
		Aadhar_number = aadhar_number;
		this.blood_group = blood_group;
		this.personal_email = personal_email;
		this.emergency_contact_name = emergency_contact_name;
		this.emergency_contact_number = emergency_contact_number;
		this.student_id = student_id;
		this.userId = userId;
		this.squad_name = squad_name;
		this.interviewer = interviewer;
		this.date_of_Join = date_of_Join;
		this.status = status;
		this.education = education;
		this.interviewer_review = interviewer_review;
		this.grade = grade;
	}	
	
	
}
