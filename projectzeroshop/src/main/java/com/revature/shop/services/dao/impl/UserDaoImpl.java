package com.revature.shop.services.dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.shop.exception.ShopException;
import com.revature.shop.models.User;
import com.revature.shop.services.dao.UserDao;
import com.revature.shop.util.DatabaseConnect;

public class UserDaoImpl implements UserDao {

	@Override
	public User logIn(String usertype, String email, String password) throws ShopException {
		User use = new User();
		String sql = "SELECT * FROM shop.users WHERE (usertype, email, password) = (?,?,?)";
		
		try {
			PreparedStatement ps = DatabaseConnect.getConnectionFromFile().prepareStatement(sql);
			
			ps.setString(1, usertype);
			ps.setString(2, email);
			ps.setString(3, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				use.setUid(rs.getInt("uid"));
				use.setUsertype(usertype);
				use.setEmail(email);
				use.setPassword(password);
				use.setFirstname(rs.getString("firstname"));
				use.setLastname(rs.getString("lastname"));
				use.setPhonenumber(rs.getString("phonenumber"));
			}
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(use != null) {
		return use;
		} else {
			return null;
		}
		
	}

	@Override
	public User registerCustomer(User u) throws ShopException {
		User customer = null;
		String sql = "INSERT INTO shop.users (usertype,email,password,firstname,lastname,phonenumber) values('Customer',?,?,?,?,?) RETURNING uid;";
		try {
			Connection con = DatabaseConnect.getConnectionFromFile();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, u.getEmail());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFirstname());
			ps.setString(4, u.getLastname());
			ps.setString(5, u.getPhonenumber());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				customer = u;
				customer.setUid(rs.getInt("uid"));
				customer.setUsertype("Customer");
			}

		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
	}

}
