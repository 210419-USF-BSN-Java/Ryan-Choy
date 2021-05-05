package com.revature.shop.control;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.revature.shop.models.User;
import com.revature.shop.services.EmployeeService;
import com.revature.shop.services.ManagerService;
import com.revature.shop.services.impl.EmployeeServiceImpl;
import com.revature.shop.services.impl.ManagerServiceImpl;

public class ShopManager {
	public void employeeMenu(User u) throws FileNotFoundException {
		ManagerService ms = new ManagerServiceImpl();
		
		Scanner mScan = new Scanner(System.in);
		boolean mFlag = true;
		
		do {
			File file = new File(
					"C:\\Users\\Ryan\\Desktop\\Revature\\USF_BSN_Java\\Assignments\\projectzeroshop\\src\\main\\resources\\employee_menu.txt");
			Scanner sc = new Scanner(file);

			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
			int mChoice = Integer.parseInt(mScan.nextLine());
			switch (mChoice) {
			case 1:
				
				break;

			default:
				break;
			}
			
		} while(mFlag != false);
	}

}
