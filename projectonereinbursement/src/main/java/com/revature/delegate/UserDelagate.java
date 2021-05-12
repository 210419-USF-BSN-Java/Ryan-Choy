package com.revature.delegate;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.services.UserService;
import com.revature.services.UserServiceImpl;

public class UserDelagate  {
	
	private UserService us = new UserServiceImpl();
	private ObjectMapper om = new ObjectMapper();
	
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String path = (String) request.getAttribute("path");
		
		if (path == null || path.equals("")) {
			switch (request.getMethod()) {
			case "GET":
				//get all users
				//call services
				break;
			case "POST":
				//post new user
				break;

			default:
				response.sendError(400, "Request not supported.");

				break;
			}
		} else {
			
		}
		
		
	}

	
	

}
