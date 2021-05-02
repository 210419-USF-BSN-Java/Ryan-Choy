package com.revature.shop.exception;

import java.math.BigDecimal;

public class ShopValidations {

	public static boolean isValidName(String name) {
		if (name != null && name.matches("[a-zA-Z]{3,20}")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isValidPassword(String pass) {
		// [^\s] stands for no whitespace character, prevents spaces from being used
		if (pass != null && pass.matches("\\w{8,30}")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isValidEmail(String email) {
		String emailregex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		// #$%&'*+-/=? not allowed

		if (email != null && email.matches(emailregex)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isValidUserType(String type) {
		if (type != null && type.matches("Customer|Employee|Manager")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isValidUpdate(String status) {
		if (status != null && status.matches("Approved|Rejected")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isValidStatus(String status) {
		if (status != null && status.matches("Approved|Rejected|Pending")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isValidBalance(BigDecimal balance) {
		if (balance.compareTo(new BigDecimal(0)) >= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isValidPhone(String phone) {
		if(phone != null && phone.matches("[0-9]{10}") ) {
			return true;
			
		} else {
			return false;
		}
			
	}

}
