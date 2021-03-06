package com.revature.shop.services;

import java.util.List;

import com.revature.shop.exception.ShopException;
import com.revature.shop.models.Offers;
import com.revature.shop.models.User;

public interface ManagerService {
	
	public List<User> viewEmployees();
	public User addEmployee(User u) throws ShopException;
	public String fireEmployee(Integer uid);
	public List<Offers> viewOfferHistory();

}
