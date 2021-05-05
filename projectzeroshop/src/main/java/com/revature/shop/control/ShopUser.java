package com.revature.shop.control;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.shop.exception.ShopException;
import com.revature.shop.models.User;
import com.revature.shop.services.UserService;
import com.revature.shop.services.impl.UserServiceImpl;

public class ShopUser {
	 private static Logger uLog = Logger.getLogger(ShopFront.class);

	public User login(int input) {
		UserService us = new UserServiceImpl();
		Scanner userscan = new Scanner(System.in);
		User custom = new User();
		String usertype = " ";
		String email = " ";
		String password = " ";
		switch (input) {
		case 1:

			usertype = "Customer";
			System.out.println("Enter email");
			email = userscan.nextLine();
			System.out.println("Enter password");
			password = userscan.nextLine();
			try {
				 custom = us.logIn(usertype, email, password);
			} catch (ShopException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Welcome " + custom.getFirstname()+ " "+ custom.getLastname() );
			return custom;
		case 2:
			 usertype = "Employee";
			System.out.println("Enter email");
			 email = userscan.nextLine();
			System.out.println("Enter password");
			 password = userscan.nextLine();
			try {
				 custom = us.logIn(usertype, email, password);
			} catch (ShopException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Welcome " + custom.getFirstname()+ " "+ custom.getLastname() );
			return custom;
			
		case 3:
			 usertype = "Manager";
			System.out.println("Enter email");
			 email = userscan.nextLine();
			System.out.println("Enter password");
			 password = userscan.nextLine();
			try {
				 custom = us.logIn(usertype, email, password);
			} catch (ShopException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Welcome " + custom.getFirstname()+ " "+ custom.getLastname() );
			return custom;
			
		case 4:
			break;

		default:
			System.out.println("Invalid input");
			break;
		}
		return null;
	}

	public User register (User u) throws ShopException {
		UserService us = new UserServiceImpl();

		User nCus = new User();
		nCus = us.registerCustomer(u);

		return nCus;
	}
	
}
