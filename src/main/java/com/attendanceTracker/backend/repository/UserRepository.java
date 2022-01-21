package com.attendanceTracker.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.attendanceTracker.backend.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	List<User> findByRole(String role);
	User findByUseremail(String useremail);
	User findByUsername(String username);
	
	User findById(long id);
	
//	@Query(value = "select * from user where id=:id",nativeQuery = true)
//	User findId(long id);
	
	@Query(value ="SELECT user_name,id from users where role='student'",nativeQuery = true)
	List<Object[]> getAllUserNames();
}
