package com.revature.shop.control;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.shop.models.Grimlist;
import com.revature.shop.models.Offers;
import com.revature.shop.models.User;
import com.revature.shop.services.EmployeeService;
import com.revature.shop.services.impl.EmployeeServiceImpl;

public class ShopEmployee {
	public void employeeMenu(User u) throws FileNotFoundException {
		EmployeeService es = new EmployeeServiceImpl();

		List<Grimlist> eBook = new ArrayList<>();
		List<Offers> offList = new ArrayList<>();

		Scanner eScan = new Scanner(System.in);
		boolean eFlag = true;

		do {
			File file = new File(
					"C:\\Users\\Ryan\\Desktop\\Revature\\USF_BSN_Java\\Assignments\\projectzeroshop\\src\\main\\resources\\employee_menu.txt");
			Scanner sc = new Scanner(file);

			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
			int eChoice = Integer.parseInt(eScan.nextLine());
			switch (eChoice) {
			case 1:
				eBook = es.viewGrimoire();
				for (int i = 0; i < eBook.size(); i++) {
					System.out.println((i + 1) + "] " + eBook.get(i));
				}
				System.out.println("Do you wish to move or edit the grimoires?[y/n]");

				switch (eScan.nextLine()) {
				case "y":
					System.out.println("1] Move Grimoires\n2] Edit grimoires\n3] Cancel");
					
					switch (Integer.parseInt(eScan.nextLine())) {
					case 1:
						
						break;
					case 2:
						
						break;
					case 3:
						
						break;

					default:
						System.out.println("Invalid input, please enter 1, 2, or 3 only!");
						break;
					}
					
					break;
				case "n":
					break;
				default:
					System.out.println("Invalid input, please enter y or n!");
					break;
				}

				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				System.out.println("Logging off...");
				eFlag = false;
				break;
			default:
				System.out.println("Invalid input, please enter 1, 2, 3, or 4 only!");
				break;
			}

		} while (eFlag != false);
	}

}
