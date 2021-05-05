package com.revature.shop.services.impl;

import java.math.BigDecimal;
import java.util.List;

import com.revature.shop.exception.ShopException;
import com.revature.shop.exception.ShopValidations;
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
		return cd.viewGrimoiresSale();
	}

	@Override
	public Offers makeOffer(Offers o) throws ShopException{
		if(!ShopValidations.isValidBalance(o.getOffer())) {
			throw new ShopException("Entered offer amount "+ o.getOffer() + " is invalid.");
		}
		return cd.makeOffer(o);
	}



	@Override
	public List<Customer> viewOwnedBooks(Integer uid) {

		return cd.viewOwnedBooks(uid);
	}

	@Override
	public String makePayment(BigDecimal pay, Integer payterm, BigDecimal weekpay, Integer gid) throws ShopException {
		
		if(!ShopValidations.isValidBalance(pay)) {
			throw new ShopException("Entered pay " + pay + " is invalid");
		}
		
		
		return cd.makePayment(pay, payterm,weekpay, gid);
	}
}
