package com.revature.shop.services.dao;

import java.math.BigDecimal;
import java.util.List;

import com.revature.shop.models.Customer;
import com.revature.shop.models.Grimlist;
import com.revature.shop.models.Offers;
import com.revature.shop.models.User;

public interface CustomerDao {
	public List<Grimlist> viewGrimoireSale();
	public Offers makeOffer(Offers o);
	public User registerCustomer(User u);
	public List<Customer> viewOwnedBooks(Integer uid);
	public String makePayment(BigDecimal pay, Integer payterm, Integer gid);
	
	
	

}
