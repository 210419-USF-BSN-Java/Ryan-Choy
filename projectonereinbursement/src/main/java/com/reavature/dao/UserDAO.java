package com.reavature.dao;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface UserDAO {

	User login(String userName, String password);

	// employees
	User updateProfile(User u);

	// just in case
	// User viewProfile();
	// managers
	List<User> viewAllEmployees();
}