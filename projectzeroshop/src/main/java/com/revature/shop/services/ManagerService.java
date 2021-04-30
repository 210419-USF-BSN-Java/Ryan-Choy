package com.revature.shop.services;

import java.util.List;

import com.revature.shop.models.Offers;
import com.revature.shop.models.User;

public interface ManagerService {
	
	public List<User> viewEmployees(String usertype);
	public String addEmployee(User u);
	public String fireEmployee(User u);
	public List<Offers> viewOfferHistory();

}
