package com.revature.shop.services.dao;

import java.util.List;

import com.revature.shop.exception.ShopException;
import com.revature.shop.models.Customer;
import com.revature.shop.models.Grimlist;
import com.revature.shop.models.Offers;

public interface EmployeeDao {
	public List<Grimlist> viewGrimoire();
	public String moveGrimoire(Integer gid, String grimstatus) throws ShopException;
	public String updateGrimoire(Grimlist grim) throws ShopException;
	public List<Offers> viewOffers(String offerstatus);
	public String acceptOffer(Integer oid);
	public Customer addOwner(Customer c);
	public String rejectRest(Integer gid);
	public List<Customer> getPayment();

}
