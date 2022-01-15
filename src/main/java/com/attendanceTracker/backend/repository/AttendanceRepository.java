package com.attendanceTracker.backend.repository;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.attendanceTracker.backend.model.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance,Long> {
	
	Attendance findById(long id);

	  @Query(value = "select *  from attendance  where user_id = :user_id and attendance_date = :date ", nativeQuery = true)
	  Attendance findByUserIdAndDate(long user_id, String date);
	  
//	@Query(value = "select * from attendance where user_id = :user_id LIMIT 1", nativeQuery = true)
//	Attendance findRecordByUserId(long user_id);
	
	@Modifying
	@Query(value = "INSERT INTO attendance (attendance_date, attendance_status, user_id) VALUES (:date, null, :user_id)",nativeQuery = true)
	@Transactional
	void insert(long user_id,String date);
}
