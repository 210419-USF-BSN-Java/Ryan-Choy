package com.revature.dao;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementDAO {
	// employee: view all resolved reimbursement requests
	List<Reimbursement> viewReimbursement(Integer userId);

	// employee: view their pending requests
	List<Reimbursement> viewPendingReimbursement(Integer userId);

	Reimbursement submitReinRequest(Reimbursement r);

	// manager: view all pending requests from all employees
	List<Reimbursement> viewPendingReimbursement();

	// manager: view all resolved requests
	List<Reimbursement> viewReimbursement();

	// manager view requests from a single employee
	List<Reimbursement> viewReimbursementEmp(Integer userId);

	boolean updateReimbursementRequest(int update, Integer reimbId);

}
