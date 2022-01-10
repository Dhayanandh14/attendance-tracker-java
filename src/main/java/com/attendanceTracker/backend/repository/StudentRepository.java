package com.attendanceTracker.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.attendanceTracker.backend.model.Student;
import com.attendanceTracker.backend.model.User;

import net.bytebuddy.asm.Advice.Return;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
//	List<User> findByEmailAddressAndLastname(String emailAddress, String lastname);
//	User findByEmailAddress(String emailAddress);
	Student findByUserId(long id);
	Student findById(long id);
}
