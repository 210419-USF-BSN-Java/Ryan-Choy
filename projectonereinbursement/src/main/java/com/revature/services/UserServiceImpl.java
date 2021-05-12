package com.revature.services;

import java.util.List;

import com.reavature.dao.UserDAO;
import com.reavature.dao.UserDAOImpl;
import com.revature.exception.ERSexception;
import com.revature.exception.ERSvalidations;
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
	public User updateProfile(User u) throws ERSexception {
		if(!ERSvalidations.isValidUserName(u.getUserName())||!ERSvalidations.isValidPassword(u.getPassword())||!ERSvalidations.isValidEmail(u.getEmail())) {
			throw new ERSexception("Entered information is invalid ");
		}
		return ud.updateProfile(u);
	}

	@Override
	public List<User> viewAllEmployees() {
		// TODO Auto-generated method stub
		return ud.viewAllEmployees();
	}
	
	

}