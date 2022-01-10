package com.attendanceTracker.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "coach_details")
public class Coach {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "user_id")
	private long userId;
	
	@Column(name = "profile_job")
	private String profile_job;

	public Coach() {
		
	}
	
	public Coach(long coach_id, Long userId, String profile_job) {
		super();
		this.id = coach_id;
		this.userId = userId;
		this.profile_job = profile_job;
	}

	public long getCoach_id() {
		return id;
	}

	public void setCoach_id(long coach_id) {
		this.id = coach_id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getProfile_job() {
		return profile_job;
	}

	public void setProfile_job(String profile_job) {
		this.profile_job = profile_job;
	}
	
	
}
