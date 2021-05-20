package com.revature.controllers;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;

import com.revature.services.UserService;
import com.revature.services.UserServiceImpl;

public class testing {
	
	public static void main(String[] args) {
		UserService us = new UserServiceImpl();
		
		//System.out.println(us.viewAllEmployees());
		
		//System.out.println(System.getenv("PASS"));
		System.out.println(System.getenv("NAME"));
	
	}

}
