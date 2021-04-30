package com.revature.shop.services.dao.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.Data;

import com.revature.shop.models.Customer;
import com.revature.shop.models.Grimlist;
import com.revature.shop.models.Offers;

import com.revature.shop.models.User;
import com.revature.shop.services.dao.CustomerDao;
import com.revature.shop.util.DatabaseConnect;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public List<Grimlist> viewGrimoireSale() {
		List<Grimlist> saleGrim = new ArrayList<>();
		String sql = "SELECT * FROM shop.grimlist WHERE grimstatus = 'For Sale' ORDER BY gid";

		try {
			PreparedStatement ps = DatabaseConnect.getConnectionFromFile().prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt("gid");
				String name = rs.getString("grimname");
				String school = rs.getString("grimschool");
				String author = rs.getString("grimauthor");
				String condition = rs.getString("grimcondition");
				String status = rs.getString("grimstatus");
				String note = rs.getString("grimnote");
				BigDecimal base = new BigDecimal(rs.getString("baseprice").replaceAll("[$,]", ""));
				saleGrim.add(new Grimlist(id, name, school, author, condition, status, note, base));
			}

		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return saleGrim;
	}

	@Override	
	public Offers makeOffer(Offers o) {
		Offers result = new Offers();
		String sql = "INSERT INTO shop.offer(gid,grimname,uid,firstname,lastname,offer,payterm) VALUES (?,?,?,?,?,?,?) RETURNING date,oid,offerstatus";
		
		try {
			PreparedStatement ps = DatabaseConnect.getConnectionFromFile().prepareStatement(sql);
			ps.setInt(1, o.getGrimoire().getGid());
			ps.setString(2, o.getGrimoire().getGrimname());
			ps.setInt(3, o.getCustomer().getUid());
			ps.setString(4, o.getCustomer().getFirstname());
			ps.setString(5, o.getCustomer().getLastname());
			ps.setBigDecimal(6, o.getOffer());
			ps.setInt(7, o.getPayterm());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
			}
			
			
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}

	@Override
	public User registerCustomer(User u) {
		User customer = null;
		String sql = "INSERT INTO shop.users (usertype,email,password,firstname,lastname,phonenumber) values('Customer',?,?,?,?,?) RETURNING uid;";
		try {
			Connection con = DatabaseConnect.getConnectionFromFile();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, u.getEmail());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFirstname());
			ps.setString(4, u.getLastname());
			ps.setInt(5, u.getPhonenumber());

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

	@Override
	public List<Customer> viewOwnedBooks(Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String makePayment(BigDecimal pay, Integer payterm) {
		// TODO Auto-generated method stub
		return null;
	}

}
