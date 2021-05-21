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

	public void logins(HttpServletRequest request, HttpServletResponse response)throws IOException{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User u = us.login(username, password);
		
		if (u.getUserId() != null) {
			String dough = u.getUserId()+":"+ u.getRoleId();
		
			System.out.println("token is made");
			
			response.setStatus(200);
			response.setHeader("User", dough);
			
		} else {
			response.sendError(401);
		}
		
	}
	
	public boolean uType(HttpServletRequest request) throws ServletException, IOException{
		String useToken = request.getHeader("User");
		
		if(useToken != null) {
			String[] crumble = useToken.split(":");
			
			if(crumble.length == 2) {
				String userId = crumble[0];
				String roleId = crumble[1];
				User u = us.findById(Integer.parseInt(userId));
				
				if(u != null && u.getRoleId().equals(Integer.parseInt(roleId))) {
					System.out.println("authorize is called");
					return true;
				}
				
			}
		}
		
		return false;
	}
	

	
	

}
