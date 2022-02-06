package com.attendanceTracker.backend;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import net.bytebuddy.build.ToStringPlugin.Exclude;

@SpringBootApplication(exclude =  SecurityAutoConfiguration.class)
public class AttendanceTrackerBackendApplication {
	
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(AttendanceTrackerBackendApplication.class, args);
	}

}

 