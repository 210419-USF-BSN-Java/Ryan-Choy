package com.revature.shop.services.dao.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.shop.exception.ShopException;
import com.revature.shop.models.Customer;
import com.revature.shop.models.Grimlist;
import com.revature.shop.models.Offers;
import com.revature.shop.services.dao.EmployeeDao;
import com.revature.shop.util.DatabaseConnect;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public List<Grimlist> viewGrimoire() {
		List<Grimlist> booklist = new ArrayList<>();
		String sql = "SELECT * FROM shop.grimlist";
		
		try {
			PreparedStatement ps = DatabaseConnect.getConnectionFromFile().prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Integer id = rs.getInt("gid");
				String name = rs.getString("grimname");
				String school = rs.getString("grimschool");
				String author = rs.getString("grimauthor");
				String condition = rs.getString("grimcondition");
				String status = rs.getString("grimstatus");
				String note = rs.getString("grimnote");
				BigDecimal base = new BigDecimal(rs.getString("baseprice").replaceAll("[$,]", ""));
				booklist.add(new Grimlist(id, name, school, author, condition, status, note, base));
				
			}
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return booklist;
	}

	@Override
	public String moveGrimoire(Integer gid, String grimstatus) throws ShopException {
		String result = "";
		String sql = "UPDATE shop.grimlist SET grimstatus = ? WHERE gid = ?";
		
		try {
			PreparedStatement ps = DatabaseConnect.getConnectionFromFile().prepareStatement(sql);
			
			ps.setString(1, grimstatus);
			ps.setInt(2, gid);
			
			if(ps.executeUpdate() >= 1) {
				result = "Grimoire moved successfully!";
			} else {
				result = "Moving the grimoire has failed!";
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public String updateGrimoire(Grimlist grim) throws ShopException {
		String result = " ";
		String sql = "";
		return null;
	}

	@Override
	public List<Offers> viewOffers(String offerstatus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateOffers(String offerstatus) throws ShopException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getPayment() {
		// TODO Auto-generated method stub
		return null;
	}

}
