package com.revature.shop.services.impl;

import java.util.List;

import com.revature.shop.exception.ShopException;
import com.revature.shop.exception.ShopValidations;
import com.revature.shop.models.Offers;
import com.revature.shop.models.User;
import com.revature.shop.services.ManagerService;
import com.revature.shop.services.dao.ManagerDao;
import com.revature.shop.services.dao.impl.ManagerDaoImpl;

public class ManagerServiceImpl implements ManagerService {
	
	ManagerDao md = new ManagerDaoImpl();

	@Override
	public List<User> viewEmployees() {
		// TODO Auto-generated method stub
		return md.viewEmployees();
	}

	@Override
	public User addEmployee(User u) throws ShopException {
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
		return md.addEmployee(u);
	}

	@Override
	public String fireEmployee(Integer uid) {
		// TODO Auto-generated method stub
		return md.fireEmployee(uid);
	}

	@Override
	public List<Offers> viewOfferHistory() {
		
		return md.viewOfferHistory();
	}

}
