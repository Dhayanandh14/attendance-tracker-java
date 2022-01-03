package com.attendanceTracker.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.attendanceTracker.backend.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	List<User> findByRole(String role);
	User findByUseremail(String useremail);
	User findByUsername(String username);
	List<User> findByUseremailAndRole(Long id,String role);
	
}
