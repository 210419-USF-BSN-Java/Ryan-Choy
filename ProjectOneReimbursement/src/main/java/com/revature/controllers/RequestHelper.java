package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegate.EmployeeDelegate;
import com.revature.delegate.ManagerDelegate;
import com.revature.delegate.UserDelegate;
import com.revature.delegate.ViewDelegate;

public class RequestHelper {
//doget dopost, etc.
	// front controller -> request helper -> delegate -> services -> dao

	private UserDelegate ud = new UserDelegate();
	private EmployeeDelegate ed = new EmployeeDelegate();
	private ManagerDelegate md = new ManagerDelegate();
	private ViewDelegate vd = new ViewDelegate();
	
	public void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String path = request.getServletPath();
		if(path.startsWith("/api/")) {
			// we will authenticate the token here
			System.out.println("token is checked");
			if(!ud.uType(request)) {
				response.sendError(401);
				return;
			}
			
			
		} else {
			System.out.println("view is called");
			vd.resolveView(request, response);
		}
		
		
		
//		StringBuilder uriString = new StringBuilder(request.getRequestURI());
//		uriString.replace(0, request.getContextPath().length() + 1, "");
//		if(!ud.uType(request)) {
//			response.sendError(401);
//			return;
//		}
//
//		if (uriString.indexOf("/") != -1) {
//			request.setAttribute("path", uriString.substring(uriString.indexOf("/") + 1));
//			uriString.replace(uriString.indexOf("/"), uriString.length(), "");
//			
//		}
//		
//		switch (uriString.toString()) {
//		case "employee":
//			ed.process(request, response);
//			break;
//		case "manager":
//			md.process(request, response);
//			break;
//		default:
//			response.sendError(404, "Path not supported");
//		}
		
		
	

	}

	public void processPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		StringBuilder uriString = new StringBuilder(request.getRequestURI());
		uriString.replace(0, request.getContextPath().length() + 1, "");

		if (uriString.indexOf("/") != -1) {
			request.setAttribute("path", uriString.substring(uriString.indexOf("/") + 1));
			uriString.replace(uriString.indexOf("/"), uriString.length(), "");
		}

		switch (uriString.toString()) {
		case "login":
			//System.out.println("login is called");
			ud.logins(request, response);
			break;
			
		case "logout":
			response.setHeader(null, null);
			break;
		default:
			response.sendError(404);

		}
	}


		
		

	
}
