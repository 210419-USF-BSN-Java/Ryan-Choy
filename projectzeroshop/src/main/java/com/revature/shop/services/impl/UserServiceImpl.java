package com.revature.shop.services.impl;

import com.revature.shop.exception.ShopException;
import com.revature.shop.exception.ShopValidations;
import com.revature.shop.models.User;
import com.revature.shop.services.UserService;
import com.revature.shop.services.dao.UserDao;
import com.revature.shop.services.dao.impl.UserDaoImpl;

public class UserServiceImpl implements UserService {
	
	UserDao ud = new UserDaoImpl();

	@Override
	public User logIn(String usertype, String email, String password) throws ShopException{
		
		if(!ShopValidations.isValidEmail(email)) {
			throw new ShopException("Entered email "+ email + " is invalid");
		}
		if(!ShopValidations.isValidPassword(password)) {
			throw new ShopException("Entered password "+ password + " is invalid");
		}
		
		return ud.logIn(usertype, email, password);
	}

	@Override
	public User registerCustomer(User u) throws ShopException {
		if(!ShopValidations.isValidName(u.getFirstname())) {
			throw new ShopException("Entered first name "+u.getFirstname() + " is invalid.");
		}
		if(!ShopValidations.isValidName(u.getLastname())) {
			throw new ShopException("Entered last name "+u.getLastname() + " is invalid.");
		}
		if(!ShopValidations.isValidEmail(u.getEmail())) {
			throw new ShopException("Entered email "+u.getFirstname() + " is invalid.");
		}
		if(!ShopValidations.isValidPassword(u.getPassword())) {
			throw new ShopException("Entered password "+u.getPassword() + " is invalid.");
		}
		if(!ShopValidations.isValidPhone(u.getPhonenumber())) {
			throw new ShopException("Entered phone number "+u.getPhonenumber()+" is invalid");
		}
		return ud.registerCustomer(u);
	}

}
