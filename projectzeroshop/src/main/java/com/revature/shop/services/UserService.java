package com.revature.shop.services;

import com.revature.shop.exception.ShopException;
import com.revature.shop.models.User;

public interface UserService {
	public User logIn(String usertype, String email, String password) throws ShopException;
	public User registerCustomer(User u) throws ShopException;


}
