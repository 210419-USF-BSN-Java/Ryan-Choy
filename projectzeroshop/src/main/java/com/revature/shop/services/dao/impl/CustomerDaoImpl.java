package com.revature.shop.services.dao.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.Data;

import com.revature.shop.exception.ShopException;
import com.revature.shop.models.Customer;
import com.revature.shop.models.Grimlist;
import com.revature.shop.models.Offers;

import com.revature.shop.models.User;
import com.revature.shop.services.dao.CustomerDao;
import com.revature.shop.util.DatabaseConnect;

public class CustomerDaoImpl implements CustomerDao {

	
	@Override
	public List<Grimlist> viewGrimoiresSale(){
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
	public Offers makeOffer(Offers o) throws ShopException {
		Offers result = new Offers();
		String sql = "INSERT INTO shop.offer(date,gid,grimname,uid,firstname,lastname,offer,payterm) VALUES (?,?,?,?,?,?,?,?) RETURNING oid,offerstatus";
		try {
			PreparedStatement ps = DatabaseConnect.getConnectionFromFile().prepareStatement(sql);
			ps.setString(1, LocalDate.now().toString());
			ps.setInt(2, o.getGrimoire().getGid());
			ps.setString(3, o.getGrimoire().getGrimname());
			ps.setInt(4, o.getCustomer().getUid());
			ps.setString(5, o.getCustomer().getFirstname());
			ps.setString(6, o.getCustomer().getLastname());
			ps.setBigDecimal(7, o.getOffer());
			ps.setInt(8, o.getPayterm());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				result = o;
				result.setOdate(rs.getString("date"));
				result.setOid(rs.getInt("oid"));
				result.setOfferstatus(rs.getString("offerstatus"));
			}

		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	

	@Override
	public List<Customer> viewOwnedBooks(Integer uid) {
		List<Customer> ownBook = new ArrayList<>();
		String sql = "SELECT * FROM shop.customer c JOIN shop.grimlist g ON c.gid = g.gid JOIN shop.users ON c.uid = u.uid WHERE c.uid = ? GROUP BY c.gid";

		try {
			PreparedStatement ps = DatabaseConnect.getConnectionFromFile().prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Grimlist book = new Grimlist();
				User owner = new User();
				Customer list = new Customer();
				book.setGid(rs.getInt("gid"));
				book.setGrimname(rs.getString("grimname"));
				book.setGrimschool(rs.getString("grimschool"));
				book.setGrimauthor(rs.getString("grimauthor"));
				book.setGrimcondition(rs.getString("grimcondition"));
				book.setGrimstatus(rs.getString("grimstatus"));
				book.setGrimnote(rs.getString("grimnote"));
				book.setBaseprice(new BigDecimal(rs.getString("baseprice").replaceAll("[$,]", "")));

				owner.setUid(rs.getInt("uid"));
				owner.setUsertype(rs.getString("usertype"));
				owner.setEmail(rs.getString("email"));
				owner.setPassword(rs.getString("password"));
				owner.setFirstname(rs.getString("firstname"));
				owner.setLastname(rs.getString("lastname"));
				owner.setPhonenumber(rs.getString("phonenumber"));

				list.setDebt(new BigDecimal(rs.getString("debt").replaceAll("[$,]", "")));
				list.setPayterm(rs.getInt("payterm"));
				list.setWeekpay(new BigDecimal(rs.getString("weekpay").replaceAll("[$,]", "")));
				list.setGrimoire(book);
				list.setOwner(owner);
				ownBook.add(list);
			}

		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ownBook;
	}

	@Override
	public String makePayment(BigDecimal pay, Integer payterm, BigDecimal weekpay, Integer gid) throws ShopException{

		String sql = "UPDATE shop.customer SET (debt,payterm,weekpay) = (?,?,?) WHERE gid = ?";
		Integer result = null;
		try {
			PreparedStatement ps = DatabaseConnect.getConnectionFromFile().prepareStatement(sql);
			ps.setBigDecimal(1, pay);
			ps.setInt(2, payterm);
			ps.setBigDecimal(3, weekpay);
			ps.setInt(4, gid);

			result = ps.executeUpdate();

		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (result != 0) {
			return "Payment successful! Your debt is now $" + pay+". You have"+ payterm+" weeks left on your payterm. Your weekly pay is $"+ weekpay ;
		} else {
			return "Payment failed! Please try again.";
		}
	}


}
