package com.revature;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.revature.shop.exception.ShopException;
import com.revature.shop.models.Customer;
import com.revature.shop.models.Grimlist;
import com.revature.shop.models.Offers;
import com.revature.shop.models.User;
import com.revature.shop.services.CustomerService;
import com.revature.shop.services.EmployeeService;
import com.revature.shop.services.ManagerService;
import com.revature.shop.services.UserService;
import com.revature.shop.services.impl.CustomerServiceImpl;
import com.revature.shop.services.impl.EmployeeServiceImpl;
import com.revature.shop.services.impl.ManagerServiceImpl;
import com.revature.shop.services.impl.UserServiceImpl;

public class ServiceTest {

	private CustomerService cust = new CustomerServiceImpl();
	private EmployeeService emp = new EmployeeServiceImpl();
	private ManagerService man = new ManagerServiceImpl();
	private UserService use = new UserServiceImpl();
	
	
	@Test
	public void login() throws ShopException {
		assertTrue(use.logIn("Customer", "bob@gmail.com", "bobobobo"));
	}
	
	@Test
	public void register() throws ShopException {
		User test = new User();
		assertTrue(use.registerCustomer(test));
	}
	
	@Test
	public void viewGrim() {
		assertTrue(cust.viewGrimoiresSale());
	}
	
	@Test
	public void makeOff() throws ShopException {
		Offers o = new Offers();
		assertTrue(cust.makeOffer(o));
	}
	
	@Test
	public void viewOwn() {
		assertTrue(cust.viewOwnedBooks(1));
	}
	
	@Test
	public void pay() throws ShopException {
		assertTrue(cust.makePayment(new BigDecimal(1), 3, new BigDecimal(4), 1));
	}
	
	@Test
	public void viewG() {
		assertTrue(emp.viewGrimoire());
	}
	
	@Test
	public void moveG() throws ShopException {
		assertTrue(emp.moveGrimoire(1, "For Sale"));
	}

	@Test
	public void upG() throws ShopException {
		assertTrue(emp.updateGrimoire(null));
	}
	
	@Test
	public void viewOff() {
		assertTrue(emp.viewOffers("Pending"));
	}
	
	@Test
	public void accOff() {
		assertTrue(emp.acceptOffer(2));
	}
	
	@Test
	public void addOwn() {
		assertTrue(emp.addOwner(null));
	}
	
	@Test
	public void rejectr() {
		assertTrue(emp.rejectRest(3));
	}
	
	@Test
	public void getPay() {
		assertTrue(emp.getPayment());
	}
	
	@Test
	public void vEmp() {
		assertTrue(man.viewEmployees());
	}
	
	@Test
	public void aEmp() throws ShopException {
		assertTrue(man.addEmployee(null));
	}
	
	@Test
	public void fEmp()	{
		assertTrue(man.fireEmployee(null));
	}
	
	@Test
	public void vOH() {
		assertTrue(man.viewEmployees());
	}

	private void assertTrue(User logIn) {
		// TODO Auto-generated method stub
		
	}
	private <T> void assertTrue(List<T> List) {
		// TODO Auto-generated method stub
		
	}
	private void assertTrue(Offers o) {
		// TODO Auto-generated method stub
		
	}
	private void assertTrue(String s) {
		// TODO Auto-generated method stub
		
	}
	private void assertTrue(Customer s) {
		// TODO Auto-generated method stub
		
	}


}
