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

import com.revature.shop.models.Grimlist;
import com.revature.shop.models.User;
import com.revature.shop.services.CustomerService;
import com.revature.shop.services.dao.impl.CustomerDaoImpl;
import com.revature.shop.services.impl.CustomerServiceImpl;

public class ShopFront {
	// private static Logger log = Logger.getLogger(ShopFront.class);

	public static void main(String[] args) throws FileNotFoundException {

		File file = new File(
				"C:\\Users\\Ryan\\Desktop\\Revature\\USF_BSN_Java\\Assignments\\projectzeroshop\\src\\main\\resources\\test.txt");
		Scanner sc = new Scanner(file);

		while (sc.hasNextLine()) {
			System.out.println(sc.nextLine());
		}
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter 1");
		Integer login = Integer.parseInt(scan.nextLine());
		ShopUser su = new ShopUser();
		switch (login) {
		case 1:
			System.out.println("Enter 1");
			int choice = Integer.parseInt(scan.nextLine());
			su.login(choice);
			break;
		case 2:
			
			break;

		default:
			break;
		}
		
		
		CustomerService cs = new CustomerServiceImpl();
		User u = new User();
	
//		System.out.println("enter email");
//		u.setEmail(scan.nextLine());
//		System.out.println("enter password");
//		u.setPassword(scan.nextLine());
//		System.out.println("enter your first name");
//		u.setFirstname(scan.nextLine());
//		System.out.println("enter your last name");
//		u.setLastname(scan.nextLine());
//		System.out.println("enter your phonenumber");
//		u.setPhonenumber(Integer.parseInt(scan.nextLine()));
//		
//		System.out.println(cs.registerCustomer(u));
//		
//		List<Grimlist> test = new ArrayList<>();
//		test = cs.viewGrimoiresSale();
//		for (Grimlist s : test) {
//			System.out.println(s);
//		}
//		
		
		
		String test = LocalDate.now().toString();

	}
}
