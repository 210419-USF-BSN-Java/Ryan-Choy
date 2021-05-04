package com.revature.shop.services;

import java.math.BigDecimal;
import java.util.List;

import com.revature.shop.exception.ShopException;
import com.revature.shop.models.Customer;
import com.revature.shop.models.Grimlist;
import com.revature.shop.models.Offers;
import com.revature.shop.models.User;

public interface CustomerService {
	public List<Grimlist> viewGrimoiresSale();
	public Offers makeOffer(Offers o) throws ShopException;
	public List<Customer> viewOwnedBooks(Integer uid);
	public String makePayment(BigDecimal pay, Integer payterm, Integer gid) throws ShopException;

}
