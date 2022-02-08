package com.attendanceTracker.backend.controller;

import java.sql.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.attendanceTracker.backend.dto.AttendanceDto;
import com.attendanceTracker.backend.dto.ReportDto;
import com.attendanceTracker.backend.model.Attendance;
import com.attendanceTracker.backend.model.User;
import com.attendanceTracker.backend.repository.AttendanceRepository;
import com.attendanceTracker.backend.repository.UserRepository;
//import com.attendanceTracker.backend.service.AttendanceService;
import com.attendanceTracker.backend.service.StudentService;
import com.attendanceTracker.backend.service.AttendanceService;
import com.attendanceTracker.backend.service.ReportService;
import com.fasterxml.jackson.annotation.JsonFormat;

import net.bytebuddy.asm.Advice.Return;
import netscape.javascript.JSObject;

//@CrossOrigin(origins = "http://localhost:3000") 
@CrossOrigin(origins = "https://react-http-478ce.web.app/") 
@RestController
@RequestMapping("/api/v1/")
//@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
public class AttendanceController {
	
	@Autowired
	private AttendanceRepository attendanceRepository;
	
	@Autowired
	private AttendanceService attendanceService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private ReportService reportService;
	
	@GetMapping("/attendance/{date}")
	public List<AttendanceDto> getAllAttendanceByDate(@PathVariable ("date") String date){
		attendanceService.setAttendanceDate(date);
		List<AttendanceDto> attendanceDtos=  attendanceService.getAllUser();
		return attendanceDtos;
	}

	@PostMapping("/attendance") 
	public List<Attendance> createAttendance(@RequestBody List<Attendance> attendance) {
		System.out.println(attendance);
		return attendanceRepository.saveAll(attendance);
	}
	
	@PatchMapping("/attendance/")
	public ResponseEntity<List<Attendance>> updateAttendace(@RequestBody List<Attendance> updateAttendance){
		System.out.println(updateAttendance);
		List<Attendance> attendance = attendanceRepository.saveAll(updateAttendance);
		return ResponseEntity.ok(attendance);
	}  
	
	@GetMapping("/report-date-range/{date1}/{date2}")
	   public Hashtable<String, Hashtable<Date, Boolean>> getDateByRange(@PathVariable("date1") String date1, @PathVariable ("date2")String date2, User User ) {
	      reportService.setDate1=date1;
	      reportService.setDate2=date2;
	      List<ReportDto> reportDtos =  reportService.convertEntityToDto(date1,date2);
	      Hashtable<String, Hashtable<Date, Boolean>> hashtable = new Hashtable<>();
	      for (ReportDto reportDto : reportDtos) {
	         String username = reportDto.getUsername();
	         if (!hashtable.contains(username)) {
	            hashtable.put(username, new Hashtable<>());
	         }
	      }
	      for (ReportDto reportDto : reportDtos) {
	         String username = reportDto.getUsername();
	         Date date = (Date) reportDto.getAttendance_date();
	         Boolean status = reportDto.getAttendance_status();
	         hashtable.get(username).put(date, status);
	      }
	      System.out.print(hashtable);
	      
	      return hashtable; 
	   }
	
	@GetMapping("/report-by-name/{id}")
	public List<AttendanceDto> getDateByRange(@PathVariable ("id")Long id ){
			List<AttendanceDto> attendanceDtos = attendanceService.convertEntityToDto2(id);			
			return attendanceDtos;
		
	}
}

