package com.revature.shop.services.impl;

import java.util.List;

import com.revature.shop.exception.ShopException;
import com.revature.shop.exception.ShopValidations;
import com.revature.shop.models.Customer;
import com.revature.shop.models.Grimlist;
import com.revature.shop.models.Offers;
import com.revature.shop.services.EmployeeService;
import com.revature.shop.services.dao.EmployeeDao;
import com.revature.shop.services.dao.impl.EmployeeDaoImpl;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDao ed = new EmployeeDaoImpl();
	
	@Override
	public List<Grimlist> viewGrimoire() {
		
		return ed.viewGrimoire();
	}

	@Override
	public String moveGrimoire(Integer gid, String grimstatus) throws ShopException {

		return ed.moveGrimoire(gid, grimstatus);
	}

	@Override
	public String updateGrimoire(Grimlist grim) throws ShopException {
		if(!ShopValidations.isValidBalance(grim.getBaseprice())) {
			throw new ShopException("Entered base price "+ grim.getBaseprice()+ "is invalid");
		}
		return ed.updateGrimoire(grim);
	}

	@Override
	public List<Offers> viewOffers(String offerstatus) {
		return ed.viewOffers(offerstatus);
	}

	@Override
	public String acceptOffer(Integer oid){
		
		return ed.acceptOffer(oid);
	}

	@Override
	public List<Customer> getPayment() {
		// TODO Auto-generated method stub
		return ed.getPayment();
	}

	@Override
	public String rejectRest(Integer gid) {
		// TODO Auto-generated method stub
		return ed.rejectRest(gid);
	}



	@Override
	public Customer addOwner(Customer c) {
		// TODO Auto-generated method stub
		return null;
	}

}
