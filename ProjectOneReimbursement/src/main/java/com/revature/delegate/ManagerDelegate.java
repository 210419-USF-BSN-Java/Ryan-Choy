package com.revature.delegate;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManagerDelegate implements Delegatable {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String path = (String) request.getAttribute("path");
		
		if (path == null || path.equals("")) {
			switch(request.getMethod()) {
				case "GET":
					request.getRequestDispatcher("static/views/manager.html").forward(request, response);
		
					break;
				case "PUT":

					break;
				case "POST":

					
					
					break;
				case "DELETE":
	
					break;
				default:

			}
		} else {
			// further processing
		}
		
	}

}
