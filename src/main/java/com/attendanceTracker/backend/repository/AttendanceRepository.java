package com.attendanceTracker.backend.repository;


import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.attendanceTracker.backend.model.Attendance;

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
	
	
	
	// report by name and date range.
	@Query(value ="select * from attendance where user_id= :id and attendance_date between :date1 and :date2  order by attendance_date",nativeQuery= true)
	List<Attendance> getReportByNameAndDateRange(long id,String date1,String date2);
	
	
	@Query(value = "select COUNT(*) from attendance where attendance_date between :date and :date2 and attendance_status=1",nativeQuery = true)
	Integer getAttendancePercentage(String date,String date2);
	
	@Query(value="select count(*) from attendance  where attendance_date between :date and :date2",nativeQuery = true)
	Integer getTotalAttendanceCount(String date,String date2);
	
	
	// full month graph view date wise percentage
	@Query(value = "select count(attendance_date) from attendance where attendance_date between  :date and :date2 and attendance_status=1 group by attendance_date order by attendance_date",nativeQuery=true)
	List<Integer> getEachDayAttendanceCount(String date,String date2);
	
	@Query(value = "select count(attendance_date) from attendance where attendance_date between  :date and :date2 and attendance_status=0 group by attendance_date",nativeQuery=true)
	List<Integer> getEachDayAttendanceAbsentCount(String date,String date2);
	
	//every day attendance status count
	@Query(value="select count(attendance_status) from attendance where attendance_date =:date and attendance_status=1",nativeQuery = true)
	Integer getEveryDayAttendanceStatusCount(String date);
	
	@Query(value="select count(attendance_status) from attendance where attendance_date =:date and attendance_status=0",nativeQuery = true)
	Integer getEveryDayAttendanceStatusAbsentCount(String date);


	
	
	
}

