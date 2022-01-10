package com.attendanceTracker.backend.dto;

public class CoachInfoDto {
	private long id;
	
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
	
	private long coach_id;
	
	

	private String profile_job;
	
	public long getCoach_id() {
		return coach_id;
	}

	public void setCoach_id(long coach_id) {
		this.coach_id = coach_id;
	}

	public CoachInfoDto() {
		
		// TODO Auto-generated constructor stub
	}

	public CoachInfoDto(String username, String useremail, String role, int age, String gender,
			String communication_address, String home_address, String access_id, long aadhar_number, long phone_number,
			String blood_group, String personal_email, String emergency_contact_name, long emergency_contact_number,
			long coach_id, String profile_job) {
		super();
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
		this.coach_id = coach_id;
		this.profile_job = profile_job;
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

	public String getProfile_job() {
		return profile_job;
	}

	public void setProfile_job(String profile_job) {
		this.profile_job = profile_job;
	}
	
	
}
