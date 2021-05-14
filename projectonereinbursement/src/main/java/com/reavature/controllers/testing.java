package com.reavature.controllers;

import com.revature.services.UserService;
import com.revature.services.UserServiceImpl;

public class testing {
	
	public static void main(String[] args) {
		UserService us = new UserServiceImpl();
		
		System.out.println(us.viewAllEmployees());
		
		//System.out.println(System.getenv("PASS"));
	}

}
