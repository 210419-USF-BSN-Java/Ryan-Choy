package com.revature.shop.services.impl;

import java.math.BigDecimal;
import java.util.List;

import com.revature.shop.models.Customer;
import com.revature.shop.models.Grimlist;
import com.revature.shop.models.Offers;

import com.revature.shop.models.User;
import com.revature.shop.services.CustomerService;
import com.revature.shop.services.dao.CustomerDao;
import com.revature.shop.services.dao.impl.CustomerDaoImpl;

public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDao cd = new CustomerDaoImpl();

	@Override
	public List<Grimlist> viewGrimoiresSale() {
		return cd.viewGrimoireSale();
	}

	@Override
	public Offers makeOffer(Offers o) {
		
		return cd.makeOffer(o);
	}

	@Override
	public User registerCustomer(User u) {
		return cd.registerCustomer(u);
		
	}

	@Override
	public List<Customer> viewOwnedBooks(Integer uid) {
		
		return cd.viewOwnedBooks(uid);
	}

	@Override
	public String makePayment(BigDecimal pay, Integer payterm, Integer gid) {
		return cd.makePayment(pay, payterm, gid);
	}
}
