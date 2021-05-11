package com.revature.services;

import java.util.List;

import com.reavature.dao.UserDAO;
import com.reavature.dao.UserDAOImpl;
import com.revature.models.Reimbursement;
import com.revature.models.User;

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
	public List<User> viewAllEmployees() {
		// TODO Auto-generated method stub
		return ud.viewAllEmployees();
	}
	
	

}
