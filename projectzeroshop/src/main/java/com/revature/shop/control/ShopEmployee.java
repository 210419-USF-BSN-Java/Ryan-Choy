package com.revature.shop.control;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.revature.shop.exception.ShopException;
import com.revature.shop.models.Customer;
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
		List<Customer> debtList = new ArrayList<>();
		Grimlist b = new Grimlist();
		Customer c = new Customer();
		Offers o = new Offers();

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
						System.out.println("Which grimoire that you  want to move?");
						int eMove = Integer.parseInt(eScan.nextLine());
						b = eBook.get(eMove);

						System.out.println("The status of the grimoire is " + b.getGrimstatus());
						System.out.println("1] Make it for sale\n2] Move it to storage\n3] Cancel");
						switch (Integer.parseInt(eScan.nextLine())) {
						case 1:
							try {
								System.out.println(es.moveGrimoire(b.getGid(), "For Sale"));
							} catch (ShopException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
						case 2:
							try {
								System.out.println(es.moveGrimoire(b.getGid(), "In Storage"));
							} catch (ShopException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							break;
						case 3:
							break;
						default:
							System.out.println("Invalid input, please enter 1, 2, or 3 only!");
							break;

						}

						break;
					case 2:
						System.out.println("Which grimoire you want to edit?");
						int eEdit = Integer.parseInt(eScan.nextLine());
						b = eBook.get(eEdit);
						boolean editFlag = true;
						do {
						System.out.println("Current grimoire details: "+ b);
						System.out.println("1] Edit title\n2] Edit school\n3] Edit author\n4] Edit condition\n5] Edit note\n6] Edit base price\n7] Exit and commit changes");
						switch (Integer.parseInt(eScan.nextLine())) {
						case 1:
							System.out.println("Enter new title. Current title: "+ b.getGrimname());
							b.setGrimname(eScan.nextLine());
							
							break;
						case 2:
							System.out.println("Enter new school. Current school: "+b.getGrimschool());
							b.setGrimschool(eScan.nextLine());
							
							break;
						case 3:
							System.out.println("Enter new author. Current author: "+b.getGrimauthor());
							b.setGrimauthor(eScan.nextLine());
			
							break;
						case 4:
							System.out.println("Enter new condition. Current condition: "+b.getGrimcondition());
							b.setGrimcondition(eScan.nextLine());
							
							break;
						case 5:
							System.out.println("Enter new note. Current note: "+b.getGrimnote());
							b.setGrimname(eScan.nextLine());
							break;
						case 6:
							System.out.println("Enter new base price. Current base price: "+ b.getBaseprice());
							b.setBaseprice(new BigDecimal(eScan.nextLine()));
							break;
						case 7:
							try {
								es.updateGrimoire(b);
							} catch (ShopException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							editFlag = false;
							break;

						default:
							System.out.println("Invalid request, please enter 1, 2, 3, 4, 5, 6, or 7 only!");
							break;
						}
						} while(editFlag != false);
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
				offList = es.viewOffers("Pending");
				for(int i = 0; i < offList.size(); i++) {
					System.out.println((i+1)+"] "+ offList.get(i));
				}
				System.out.println("Would you like to accept any offers?[y/n]");
				switch(eScan.nextLine()) {
				case "y":
					System.out.println("Which one do you want to accept?");
					int offChoice = Integer.parseInt(eScan.nextLine());
					o = offList.get(offChoice);
					
					System.out.println(es.acceptOffer(o.getOid()));
					System.out.println(es.rejectRest(o.getGrimoire().getGid()));
					c.setGrimoire(o.getGrimoire());
					c.setOwner(o.getCustomer());
					c.setDebt(o.getOffer());
					c.setPayterm(o.getPayterm());
					c.setWeekpay(o.getOffer().divide(new BigDecimal(o.getPayterm()), 2, RoundingMode.CEILING));
					
					Customer confirm = new Customer();
					
					confirm = es.addOwner(c);
					if(confirm != null) {
						System.out.println("Book successfully transfered ownership!");
						System.out.println(confirm);
					}
					
					break;
				case "n":
					break;
					default:
						System.out.println("Invalid input, please enter y or n!");

						break;
				}
				
				
				break;
			case 3:
				debtList = es.getPayment();
				
				for(int i = 0;i < debtList.size();i++) {
					System.out.println((i+1)+"] "+ debtList.get(i));
				}
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
