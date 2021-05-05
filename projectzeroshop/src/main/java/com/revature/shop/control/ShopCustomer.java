package com.revature.shop.control;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.shop.exception.ShopException;
import com.revature.shop.models.Customer;
import com.revature.shop.models.Grimlist;
import com.revature.shop.models.Offers;
import com.revature.shop.models.User;
import com.revature.shop.services.CustomerService;
import com.revature.shop.services.impl.CustomerServiceImpl;

public class ShopCustomer {
	 private static Logger cLog = Logger.getLogger(ShopFront.class);

	public void customerMenu(User cm) throws FileNotFoundException {
		CustomerService cs = new CustomerServiceImpl();
		Grimlist book = new Grimlist();
		Offers bid = new Offers();
		Customer own = new Customer();
		List<Grimlist> bList = new ArrayList<>();
		List<Customer> cList = new ArrayList<>();

		Scanner cScan = new Scanner(System.in);
		boolean cFlag = true;

		do {
			File file = new File(
					"C:\\Users\\Ryan\\Desktop\\Revature\\USF_BSN_Java\\Assignments\\projectzeroshop\\src\\main\\resources\\customer_menu.txt");
			Scanner sc = new Scanner(file);

			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}

			int cChoice = Integer.parseInt(cScan.nextLine());

			switch (cChoice) {
			case 1:
				bList = cs.viewGrimoiresSale();
				for (int i = 0; i < bList.size(); i++) {
					System.out.println((i + 1) + "] " + bList.get(i));
					
				}
				cLog.info("Customer "+ cm.getFirstname()+" "+cm.getLastname()+" has viewed grimoires for sale.");

				System.out.println("Would you like to make an offer to a grimoire?[y/n]?");

				switch (cScan.nextLine()) {
				case "y":
					System.out.println("Which grimoire that you want to make an offer to?");
					int cOffer = Integer.parseInt(cScan.nextLine());
					bid.setGrimoire(bList.get((cOffer - 1)));
					bid.setCustomer(cm);
					System.out.println("What is your offer? [Numbers only please]");
					bid.setOffer(new BigDecimal(cScan.nextLine()));
					System.out.println("In how many weeks will you pay off your bid should it be accepted?");
					bid.setPayterm(Integer.parseInt(cScan.nextLine()));

					BigDecimal wPay = bid.getOffer().divide(new BigDecimal(bid.getPayterm()), 2, RoundingMode.CEILING);

					Offers nBid = new Offers();
					try {
						nBid = cs.makeOffer(bid);
					} catch (ShopException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (nBid != null) {
						System.out.println("Offer successfully made! Down below are the details.");
						System.out.println(nBid);
						cLog.info("Customer "+ cm.getFirstname()+" "+cm.getLastname()+" has made an offer of $"+bid.getOffer()+" over "+ bid.getPayterm()+" weeks for "+ bid.getGrimoire().getGrimname());

					} else {
						System.out.println("Sorry, something went wrong, please try again or do something else!");
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
				cList = cs.viewOwnedBooks(cm.getUid());
				for(int i = 0; i < cList.size();i++) {
					System.out.println((i+1)+"] "+ cList.get(i));
				} 
				cLog.info("Customer "+ cm.getFirstname()+" "+cm.getLastname()+" has viewed their owned grimoires.");

				System.out.println("Would you like to make a payment? [y/n]");
				
				switch (cScan.nextLine()) {
				case "y":
					System.out.println("Which grimoire you like to make a payment to?");
					own = cList.get((Integer.parseInt(cScan.nextLine())-1));
					System.out.println("How much do you want to pay? Your current debt is $"+ own.getDebt()+" and you have "+ own.getPayterm()+" weeks left to pay it off.");
					BigDecimal pay = new BigDecimal(cScan.nextLine());
					
					BigDecimal change = own.getDebt().subtract(pay);
					
					if(change.compareTo(new BigDecimal(0)) <= 0) {
						change = new BigDecimal(0);
					}
					BigDecimal week = change.divide(new BigDecimal((own.getPayterm()-1)),2,RoundingMode.CEILING);
					try {
						System.out.println(cs.makePayment(change, (own.getPayterm()-1),week, own.getGrimoire().getGid()));
						cLog.info("Customer "+ cm.getFirstname()+" "+cm.getLastname()+" has made a payment of $"+ change+" to "+own.getGrimoire().getGrimname());

					} catch (ShopException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
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
				System.out.println("Logging out...");
				cLog.info("Customer "+ cm.getFirstname()+" "+cm.getLastname()+" has logged out.");

				cFlag = false;
				break;

			default:
				System.out.println("Invalid input, please enter 1,2, or 3 only!");
				break;
			}

		} while (cFlag != false);

	}

}
