package com.reavature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
//doget dopost, etc.
	// front controller -> request helper -> delegate -> services -> dao

	public void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		StringBuilder uriString = new StringBuilder(request.getRequestURI());

		uriString.replace(0, request.getContextPath().length() + 1, "");

		if (uriString.indexOf("/") != -1) {

			request.setAttribute("path", uriString.substring(uriString.indexOf("/") + 1));

			uriString.replace(uriString.indexOf("/"), uriString.length(), "");

		}

	}

}
