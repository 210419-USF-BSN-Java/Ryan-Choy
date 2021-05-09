package com.reavature.dao;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface UserDAO {
	
User login(String userName, String password);
	
	//employees
	User updateProfile(User u);
	//employee: view all resolved reimbursement requests
	List<Reimbursement> viewReimbursement(Integer userId);
	//employee: view their pending requests
	List<Reimbursement> viewPendingReimbursement(Integer userId);
	Reimbursement submitReinRequest(Reimbursement r);
	
	//just in case
	//User viewProfile();
	
	
	//managers
	//manager: view all pending requests from all employees
	List<Reimbursement> viewPendingReimbursement();
	//manager: view all resolved requests
	List<Reimbursement> viewReimbursement();
	List<User> viewAllEmployees();
	//manager view requests from a single employee
	List<Reimbursement> viewReimbursementEmp(Integer userId);
	String updateReimbursementRequest(int update, Integer reimbId);

}
