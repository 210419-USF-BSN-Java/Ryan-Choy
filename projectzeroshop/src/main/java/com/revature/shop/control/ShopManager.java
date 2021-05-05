package com.revature.shop.control;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.shop.exception.ShopException;
import com.revature.shop.models.Offers;
import com.revature.shop.models.User;
import com.revature.shop.services.EmployeeService;
import com.revature.shop.services.ManagerService;
import com.revature.shop.services.impl.EmployeeServiceImpl;
import com.revature.shop.services.impl.ManagerServiceImpl;

public class ShopManager {
	 private static Logger mLog = Logger.getLogger(ShopFront.class);

	public void employeeMenu(User u) throws FileNotFoundException {
		ManagerService ms = new ManagerServiceImpl();
		List<User> viewEmp = new ArrayList<>();
		User mu = new User();
		List<Offers> offHist = new ArrayList<>();
		
		Scanner mScan = new Scanner(System.in);
		boolean mFlag = true;
		
		do {
			File file = new File(
					"C:\\Users\\Ryan\\Desktop\\Revature\\USF_BSN_Java\\Assignments\\projectzeroshop\\src\\main\\resources\\manager_menu.txt");
			Scanner sc = new Scanner(file);

			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
			int mChoice = Integer.parseInt(mScan.nextLine());
			switch (mChoice) {
			case 1:
				viewEmp = ms.viewEmployees();
				for(int i = 0; i < viewEmp.size();i++) {
					System.out.println((i+1)+"] "+ viewEmp.get(i));
				}
				mLog.info("Manager "+ u.getFirstname()+" "+u.getLastname()+" has viewed all employees");

				System.out.println("Do you wish to fire an employee?[y/n]");
				switch (mScan.nextLine()) {
				case "y":
					System.out.println("Which employee do you wish to fire?");
					int mFire = Integer.parseInt(mScan.nextLine());
					mu = viewEmp.get(mFire);
					
					System.out.println(ms.fireEmployee(mu.getUid()));
					mLog.info("Manager "+ u.getFirstname()+" "+u.getLastname()+" has fired an employee.");

					
					break;
				case "n":
					
					break;

				default:
					System.out.println("Invalid input, please enter y or n!");

					break;
				}
				break;
			case 2:
				User nEmp = new User();
				System.out.println("Enter the following details to add an employee.");
				System.out.println("Enter email");
				mu.setEmail(mScan.nextLine());
				System.out.println("Enter password");
				mu.setPassword(mScan.nextLine());
				System.out.println("Enter first name");
				mu.setFirstname(mScan.nextLine());
				System.out.println("Enter last name");
				mu.setLastname(mScan.nextLine());
				System.out.println("Enter phone number");
				mu.setPhonenumber(mScan.nextLine());
				
				try {
				nEmp =	ms.addEmployee(mu);

				} catch (ShopException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(nEmp.getUid() != null) {
					System.out.println("Employee succesfully added!");
					System.out.println(nEmp);
					mLog.info("Manager "+ u.getFirstname()+" "+u.getLastname()+" has hired an employee");

				} else {
					System.out.println("Process failed!");
				}
				
				break;
			case 3:
				offHist = ms.viewOfferHistory();
				for(int i = 0; i < offHist.size();i++) {
					System.out.println((i+1)+"] "+ offHist.get(i));
				}
				mLog.info("Manager "+ u.getFirstname()+" "+u.getLastname()+" has viewed the offer history");

				break;
				
			case 4:
				System.out.println("Logging off...");
				mLog.info("Manager "+ u.getFirstname()+" "+u.getLastname()+" has logged off.");

				mFlag = false;

			default:
				break;
			}
			
		} while(mFlag != false);
	}

}
