package com.revature.shop.services.impl;

import java.util.List;

import com.revature.shop.exception.ShopException;
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
		// TODO Auto-generated method stub
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
