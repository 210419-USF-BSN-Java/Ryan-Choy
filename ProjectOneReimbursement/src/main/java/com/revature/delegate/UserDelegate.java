package com.revature.delegate;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.services.UserService;
import com.revature.services.UserServiceImpl;

public class UserDelegate  {
	
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
	
	public void logins(HttpServletRequest request, HttpServletResponse response)throws IOException{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User u = us.login(username, password);
		
		if (u.getUserId() != null) {
			String dough = u.getUserId()+":"+ u.getRoleId();
			Cookie choco = new Cookie("id",dough);
			System.out.println(u);
			
			response.setStatus(200);
			response.addCookie(choco);
			
		} else {
			response.sendError(401);
		}
		
	}
	
	public Integer uType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Cookie[] chip = request.getCookies();
		
		if(chip != null) {
			String[] crumble = chip[0].getValue().split(":");
			
			if(crumble.length == 2) {
				User u = us.findById(Integer.parseInt(crumble[0]));
				
				if(u != null && u.getRoleId().equals(Integer.parseInt(crumble[1]))) {
					return Integer.parseInt(crumble[1]);
				}
				
			}
		}
		
		return null;
	}
	

	
	

}
