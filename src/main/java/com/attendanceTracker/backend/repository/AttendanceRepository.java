package com.attendanceTracker.backend.repository;


import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.attendanceTracker.backend.model.Attendance;
import com.attendanceTracker.backend.model.User;

public interface AttendanceRepository extends JpaRepository<Attendance,Long> {
	
	Attendance findById(long id);

	@Query(value = "select *  from attendance  where user_id = :user_id and attendance_date = :date ", nativeQuery = true)
	  Attendance findByUserIdAndDate(long user_id, String date);
	  	
	@Modifying
	@Query(value = "INSERT INTO attendance (attendance_date, attendance_status, user_id) VALUES (:date, null, :user_id)",nativeQuery = true)
	@Transactional
	void insert(long user_id,String date);
	
	List<Attendance> findByUserId(long id);
	
	
	@Query(value = "select * from attendance where  attendance_date between :date1 and :date2",nativeQuery = true)
	List<Attendance> findAllByAttendanceDate(String date1, String date2);
	
	
	
}
