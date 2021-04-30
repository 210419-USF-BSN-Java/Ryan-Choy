package com.revature.shop.services;

import java.util.List;

import com.revature.shop.models.Customer;
import com.revature.shop.models.Grimlist;
import com.revature.shop.models.Offers;

public interface EmployeeService {
	public List<Grimlist> viewGrimoire();
	public String moveGrimoire(Integer gid, String grimstatus);
	public String updateGrimoire(Grimlist grim);
	public List<Offers> viewOffers(String offerstatus);
	public String updateOffers(String offerstatus);
	public List<Customer> getPayment();
	
	

}
