package com.revature.services.impl;

import java.util.List;

import com.reavature.dao.UserDAO;
import com.revature.dao.impl.UserDAOImpl;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.services.UserService;

public class UserServiceImpl implements UserService{

	private UserDAO ud = new UserDAOImpl();
	
	@Override
	public User login(String userName, String password) {
		// TODO Auto-generated method stub
		return ud.login(userName, password);
	}

	@Override
	public User updateProfile(User u) {
		// TODO Auto-generated method stub
		return ud.updateProfile(u);
	}

	@Override
	public List<Reimbursement> viewReimbursement(Integer userId) {
		// TODO Auto-generated method stub
		return ud.viewReimbursement(userId);
	}

	@Override
	public List<Reimbursement> viewPendingReimbursement(Integer userId) {
		// TODO Auto-generated method stub
		return ud.viewPendingReimbursement(userId);
	}

	@Override
	public Reimbursement submitReinRequest(Reimbursement r) {
		// TODO Auto-generated method stub
		return ud.submitReinRequest(r);
	}

	@Override
	public List<Reimbursement> viewPendingReimbursement() {
		// TODO Auto-generated method stub
		return ud.viewPendingReimbursement();
	}

	@Override
	public List<Reimbursement> viewReimbursement() {
		// TODO Auto-generated method stub
		return ud.viewReimbursement();
	}

	@Override
	public List<User> viewAllEmployees() {
		// TODO Auto-generated method stub
		return ud.viewAllEmployees();
	}

	@Override
	public List<Reimbursement> viewReimbursementEmp(Integer userId) {
		// TODO Auto-generated method stub
		return ud.viewReimbursementEmp(userId);
	}

	@Override
	public String updateReimbursementRequest(int update, Integer reimbId) {
		// TODO Auto-generated method stub
		return ud.updateReimbursementRequest(update, reimbId);
	}

}
