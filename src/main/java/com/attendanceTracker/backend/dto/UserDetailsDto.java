package com.attendanceTracker.backend.dto;

import javax.persistence.Column;

public class UserDetailsDto {
	private long user_id;
	
	private String username;
	
	private String useremail;
	
	private String role;
	
	private int age;
	
	private String gender;

	private String communication_address;

	private String home_address;

	private String access_id;
	
	private long Aadhar_number;
	
	private long phone_number;
	
	private String blood_group;
	
	private String personal_email;
	
	private String emergency_contact_name;
	
	private long emergency_contact_number;
	
	private long student_id;

	private String squad_name;

	private String interviewer;
	
	private String date_of_Join;
	
	private String status;

	private String education;
	
	private String interviewer_review;

	private String grade;

	public UserDetailsDto() {
		
	}
	
	public UserDetailsDto(long user_id, String username, String useremail, String password, String role, int age,
			String gender, String communication_address, String home_address, String access_id, long aadhar_number,
			long phone_number, String blood_group, String personal_email, String emergency_contact_name,
			long emergency_contact_number, long student_id, String squad_name, String interviewer, String date_of_Join,
			String status, String education, String interviewer_review, String grade) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.useremail = useremail;
		this.role = role;
		this.age = age;
		this.gender = gender;
		this.communication_address = communication_address;
		this.home_address = home_address;
		this.access_id = access_id;
		Aadhar_number = aadhar_number;
		this.phone_number = phone_number;
		this.blood_group = blood_group;
		this.personal_email = personal_email;
		this.emergency_contact_name = emergency_contact_name;
		this.emergency_contact_number = emergency_contact_number;
		this.student_id = student_id;
		this.squad_name = squad_name;
		this.interviewer = interviewer;
		this.date_of_Join = date_of_Join;
		this.status = status;
		this.education = education;
		this.interviewer_review = interviewer_review;
		this.grade = grade;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return username;
	}

	public void setUser_name(String username) {
		this.username = username;
	}

	public String getUser_email() {
		return useremail;
	}

	public void setUser_email(String useremail) {
		this.useremail = useremail;
	}


	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public String getAccess_id() {
		return access_id;
	}

	public void setAccess_id(String access_id) {
		this.access_id = access_id;
	}

	public long getAadhar_number() {
		return Aadhar_number;
	}

	public void setAadhar_number(long aadhar_number) {
		Aadhar_number = aadhar_number;
	}

	public long getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
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
