package com.revature.shop.services.dao.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.shop.exception.ShopException;
import com.revature.shop.models.Grimlist;
import com.revature.shop.models.Offers;
import com.revature.shop.models.User;
import com.revature.shop.services.dao.ManagerDao;
import com.revature.shop.util.DatabaseConnect;

public class ManagerDaoImpl implements ManagerDao {

	@Override
	public List<User> viewEmployees() {
		List<User> empList = new ArrayList<>();
		String sql = "SELECT * FROM shop.users WHERE usertype = 'Employee' ORDER BY uid";

		try {
			PreparedStatement ps = DatabaseConnect.getConnectionFromFile().prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setUid(rs.getInt("uid"));
				u.setUsertype(rs.getString("usertype"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
				u.setFirstname(rs.getString("firstname"));
				u.setLastname(rs.getString("lastname"));
				u.setPhonenumber(rs.getString("phonenumber"));

				empList.add(u);
			}

		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return empList;
	}

	@Override
	public User addEmployee(User u) throws ShopException {
		User emp = new User();
		String sql = "INSERT INTO shop.users (usertype,email,password,firstname,lastname,phonenumber) VALUES ('Employee',?,?,?,?,?) RETURNING uid";

		try {
			PreparedStatement ps = DatabaseConnect.getConnectionFromFile().prepareStatement(sql);

			ps.setString(1, u.getEmail());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFirstname());
			ps.setString(4, u.getLastname());
			ps.setString(5, u.getPhonenumber());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				emp = u;
				emp.setUid(rs.getInt("uid"));
			}

		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return emp;
	}

	@Override
	public String fireEmployee(Integer uid) {
		String result = "";
		String sql = "DELETE FROM shop.users WHERE uid = ?";

		try {
			PreparedStatement ps = DatabaseConnect.getConnectionFromFile().prepareStatement(sql);

			ps.setInt(1, uid);

			if (ps.executeUpdate() >= 1) {
				result = "Employee fired!";
			} else {
				result = "Process failed!";
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public List<Offers> viewOfferHistory() {
		List<Offers> offHist = new ArrayList<>();
		String sql = "SELECT * from shop.offer o JOIN shop.grimlist g on o.gid = g.gid JOIN shop.users u ON o.uid = u.uid ORDER BY date DESC";
		
		try {
			PreparedStatement ps = DatabaseConnect.getConnectionFromFile().prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Grimlist book = new Grimlist();
				User bidder = new User();
				Offers off = new Offers();
				
				book.setGid(rs.getInt("gid"));
				book.setGrimname(rs.getString("grimname"));
				book.setGrimschool(rs.getString("grimschool"));
				book.setGrimauthor(rs.getString("grimauthor"));
				book.setGrimcondition(rs.getString("grimcondition"));
				book.setGrimstatus(rs.getString("grimstatus"));
				book.setGrimnote(rs.getString("grimnote"));
				book.setBaseprice(new BigDecimal(rs.getString("baseprice").replaceAll("[$,]", "")));

				bidder.setUid(rs.getInt("uid"));
				bidder.setUsertype(rs.getString("usertype"));
				bidder.setEmail(rs.getString("email"));
				bidder.setPassword(rs.getString("password"));
				bidder.setFirstname(rs.getString("firstname"));
				bidder.setLastname(rs.getString("lastname"));
				bidder.setPhonenumber(rs.getString("phonenumber"));
				
				off.setOdate(rs.getString("date"));
				off.setOid(rs.getInt("oid"));
				off.setGrimoire(book);
				off.setCustomer(bidder);
				off.setOffer(new BigDecimal(rs.getString("offer").replaceAll("[$,]", "")));
				off.setPayterm(rs.getInt("payterm"));
				off.setOfferstatus(rs.getString("offerstatus"));
				offHist.add(off);
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return offHist;
	}

}
