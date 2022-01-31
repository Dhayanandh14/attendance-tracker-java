package com.attendanceTracker.backend.repository;


import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.attendanceTracker.backend.model.Attendance;
import com.attendanceTracker.backend.model.User;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.StringIdGenerator;

public interface AttendanceRepository extends JpaRepository<Attendance,Long> {
	
	Attendance findById(long id);

	// show attendance page By date 
	@Query(value = "select *  from attendance  where user_id = :user_id and attendance_date = :date ", nativeQuery = true) 
	Attendance findByUserIdAndDate(long user_id, String date);
	  	
	@Modifying
	@Query(value = "INSERT INTO attendance (attendance_date, attendance_status, user_id) VALUES (:date, null, :user_id)",nativeQuery = true)
	@Transactional
	void insert(long user_id,String date);
	
	//Report By name
	@Query(value = "select * from attendance where user_id= :id order by attendance_date ",nativeQuery = true)
	List<Attendance> findByUserId(long id);
	
	// Report By Date range
	@Query(value = "select * from attendance where attendance_date between :date1 and :date2 and attendance_status is not null order by user_id",nativeQuery = true)
	List<Attendance> findAllByAttendanceDate(String date1, String date2);
	
	
	// Report By count and date Range
	@Query(value ="select * from attendance where user_id= :id and attendance_date between :date1 and :date2 and attendance_status=true ",nativeQuery= true)
	List<Attendance> getAttendanceStatusPresentCount(long id,String date1,String date2);
	
	@Query(value ="select * from attendance where user_id= :id and attendance_date between :date1 and :date2 and attendance_status=false and attendance_status is not null ",nativeQuery= true)
	List<Attendance> getAttendanceStatusAbsentCount(long id,String date1,String date2);
	
	
	// report by name and date range. It will get Particular user name atttendance status count
	@Query(value ="select * from attendance where user_id= :id and attendance_date between :date1 and :date2  order by attendance_date",nativeQuery= true)
	List<Attendance> getReportByNameAndDateRange(long id,String date1,String date2);
	
	@Query(value="select user_id,count(attendance_status) from attendance where  attendance_status=1 and attendance_date between '2022-01-12' and '2022-01-20' group by user_id",nativeQuery = true)
	List<Attendance> getAllNameAndStatusCount();
}

