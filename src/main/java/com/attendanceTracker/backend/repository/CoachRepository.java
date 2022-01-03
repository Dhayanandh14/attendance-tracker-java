package com.attendanceTracker.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attendanceTracker.backend.model.Coach;

public interface CoachRepository extends JpaRepository<Coach, Long>{
	
}
