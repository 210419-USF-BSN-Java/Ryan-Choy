package com.revature.shop.services.dao;

import com.revature.shop.exception.ShopException;
import com.revature.shop.models.User;

public interface UserDao {
	public User logIn(String usertype, String email, String password) throws ShopException;
	public User registerCustomer(User u) throws ShopException;

}
