package com.revature.shop.control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.shop.exception.ShopException;
import com.revature.shop.models.Customer;
import com.revature.shop.models.Grimlist;
import com.revature.shop.models.Offers;
import com.revature.shop.models.User;
import com.revature.shop.services.CustomerService;
import com.revature.shop.services.dao.impl.CustomerDaoImpl;
import com.revature.shop.services.impl.CustomerServiceImpl;

public class ShopFront {
	 private static Logger sLog = Logger.getLogger(ShopFront.class);

	public static void main(String[] args) throws FileNotFoundException {
		ShopUser user = new ShopUser();
		ShopCustomer customer = new ShopCustomer();
		ShopEmployee employee = new ShopEmployee();
		ShopManager manager = new ShopManager();
		
		User u = new User();
		Customer c = new Customer();
		Grimlist g = new Grimlist();
		Offers o = new Offers();

		boolean app = true;
		
		do {
		
		File file = new File(
				"C:\\Users\\Ryan\\Desktop\\Revature\\USF_BSN_Java\\Assignments\\projectzeroshop\\src\\main\\resources\\front_menu.txt");
		Scanner sc = new Scanner(file);

		while (sc.hasNextLine()) {
			System.out.println(sc.nextLine());
		}
		Scanner scan = new Scanner(System.in);
		int log = Integer.parseInt(scan.nextLine());
		
		switch (log) {
		case 1:
			System.out.println("Log in as a \n1] Customer\n2] Employee\n3] Manager\nor\n4] Cancel");
			u = user.login(Integer.parseInt(scan.nextLine()));
			String type = "";
			if(u != null) {
			 type = u.getUsertype();
			}else {
				break;
			}
			switch (type) {
			case "Customer":
				sLog.info("Customer "+ u.getFirstname()+" "+u.getLastname()+" has logged in");
				customer.customerMenu(u);
				break;
			case "Employee":
				
				sLog.info("Employee "+ u.getFirstname()+" "+u.getLastname()+" has logged in");

				employee.employeeMenu(u);
				
				break;
			case "Manager":
				sLog.info("Manager "+ u.getFirstname()+" "+u.getLastname()+" has logged in");

				manager.employeeMenu(u);
				break;

			default:
				break;
			}
			
			break;
		case 2:
			System.out.println("Please enter the following details!");
			System.out.println("Enter your email [example@mail.com]");
			u.setEmail(scan.nextLine());
			System.out.println("Enter your password, minimum of 8 characters and maximum of 30 characters");
			u.setPassword(scan.nextLine());
			System.out.println("Enter your first name");
			u.setFirstname(scan.nextLine());
			System.out.println("Enter your last name");
			u.setLastname(scan.nextLine());
			System.out.println("Enter your 10 digit phone number");
			u.setPhonenumber(scan.nextLine());
			
			try {
				if(user.register(u) != null) {
					System.out.println("Registration successful! Welcome customer "+ u.getFirstname() + " "+ u.getLastname()+"!");
					sLog.info("User "+ u.getFirstname()+" "+u.getLastname()+" has registered as a customer.");
				} else {
					System.out.println("Registration failed! Please try again.");
				}
			} catch (ShopException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			break;
		case 3:
			System.out.println("Thank you for shopping at Grim's! Closing program...");
			sLog.info("Program closed");
			app = false;
			break;

		default:
			System.out.println("Invalid input, please enter 1,2, or 3!");
			break;
		}
		
		} while (app != false);


	}
}
