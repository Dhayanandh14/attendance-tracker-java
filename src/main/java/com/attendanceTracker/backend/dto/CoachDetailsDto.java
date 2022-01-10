package com.attendanceTracker.backend.dto;

public class CoachDetailsDto {
	private long id;
	private String access_id;
	private String user_email;
	private String user_name;
	private String profile_job;
	
	
	public CoachDetailsDto() {
		
	}

	

	public CoachDetailsDto(String access_id, String user_email, String user_name, String profile_job) {
		super();
		this.access_id = access_id;
		this.user_email = user_email;
		this.user_name = user_name;
		this.profile_job = profile_job;
	}



	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getAccess_id() {
		return access_id;
	}


	public void setAccess_id(String access_id) {
		this.access_id = access_id;
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


	public String getProfile_job() {
		return profile_job;
	}


	public void setProfile_job(String profile_job) {
		this.profile_job = profile_job;
	}
	

	
	
}
