package com.revature.delegate;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewDelegate {
	public void resolveView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		switch(path) {
		case "/login":
			System.out.println("login view is called");
			request.getRequestDispatcher("/static/views/login.html").forward(request, response);
			break;
		case "/employee":
			System.out.println("employee view is called");
			request.getRequestDispatcher("/static/views/employee.html").forward(request, response);
			break;
		default:
			response.sendError(404, "Static Resource Not Found");
		}
	}

}
