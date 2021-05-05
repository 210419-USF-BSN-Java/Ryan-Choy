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
import com.revature.shop.models.User;
import com.revature.shop.services.dao.EmployeeDao;
import com.revature.shop.util.DatabaseConnect;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public List<Grimlist> viewGrimoire() {
		List<Grimlist> booklist = new ArrayList<>();
		String sql = "SELECT * FROM shop.grimlist ORDER BY gid";
		
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
		String sql = "UPDATE shop.grimlist SET (grimname,grimcondition,grimschool,grimstatus,grimnote,baseprice,grimauthor) = (?,?,?,?,?,?,?) WHERE gid = ?";
		
		try {
			PreparedStatement ps = DatabaseConnect.getConnectionFromFile().prepareStatement(sql);
			ps.setString(1, grim.getGrimname());
			ps.setString(2, grim.getGrimcondition());
			ps.setString(3, grim.getGrimschool());
			ps.setString(4, grim.getGrimstatus());
			ps.setString(5, grim.getGrimnote());
			ps.setBigDecimal(6, grim.getBaseprice());
			ps.setString(7, grim.getGrimauthor());
			ps.setInt(8, grim.getGid());
			
			if(ps.executeUpdate() >= 1) {
				result = "Update successful!";
			} else {
				result = "Update failed!";
			}
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<Offers> viewOffers(String offerstatus) {
		
		List<Offers> pendOffers = new ArrayList<>();
		String sql = "SELECT * from shop.offer o JOIN shop.grimlist g on o.gid = g.gid JOIN shop.users u ON o.uid = u.uid WHERE offerstatus = ?";
		
		try {
			PreparedStatement ps = DatabaseConnect.getConnectionFromFile().prepareStatement(sql);
			ps.setString(1, offerstatus);
			
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
				off.setOfferstatus(offerstatus);
				pendOffers.add(off);
				
			}
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return pendOffers;
	}

	@Override
	public String acceptOffer(Integer oid){
		String result = "";
		String sql = "UPDATE shop.offer SET offerstatus = 'Accepted' WHERE oid = ?";
		
		try {
			PreparedStatement ps = DatabaseConnect.getConnectionFromFile().prepareStatement(sql);
			ps.setInt(1, oid);
			
			if(ps.executeUpdate() >= 1) {
				result = "Offer successfully accepted!";
			} else {
				result = "Something went wrong!";
			}
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public String rejectRest(Integer gid) {
		String result = "";
		String sql = "UPDATE shop.offer SET offerstatus = 'Rejected' WHERE gid = ?";
		try {
			PreparedStatement ps = DatabaseConnect.getConnectionFromFile().prepareStatement(sql);
			
			ps.setInt(1, gid);
			
			if(ps.executeUpdate() >= 1) {
				result = "All the other offers have been successfully rejected!";
			} else {
				result = "Rejection failed!";
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Customer> getPayment() {
		List<Customer> payList = new ArrayList<>();
		String sql = "SELECT c.uid,u.firstname,u.lastname,c.gid,c.grimname,c.debt,c.payterm,c.weekpay FROM shop.customer c JOIN shop.users u ON c.uid = u.uid ORDER BY c.uid";
		
		try {
			PreparedStatement ps = DatabaseConnect.getConnectionFromFile().prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Customer det = new Customer();
				User own = new User();
				Grimlist book = new Grimlist();
				
				own.setUid(rs.getInt("uid"));
				own.setFirstname(rs.getString("firstname"));
				own.setLastname(rs.getString("lastname"));
				
				book.setGid(rs.getInt("gid"));
				book.setGrimname(rs.getString("grimname"));
				
				det.setDebt(new BigDecimal(rs.getString("debt").replaceAll("[$,]", "")));
				det.setPayterm(rs.getInt("payterm"));
				det.setWeekpay(new BigDecimal(rs.getString("weekpay").replaceAll("[$,]", "")));
				det.setGrimoire(book);
				det.setOwner(own);
				
				payList.add(det);
				
				
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return payList;
	}

	@Override
	public Customer addOwner(Customer c) {
		Customer nOwn = new Customer();
		String sql = "INSERT INTO shop.customer (gid,grimname,uid,debt,payterm,weekpay) VALUES (?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps = DatabaseConnect.getConnectionFromFile().prepareStatement(sql);
			
			ps.setInt(1, c.getGrimoire().getGid());
			ps.setString(2, c.getGrimoire().getGrimname());
			ps.setInt(3, c.getOwner().getUid());
			ps.setBigDecimal(4, c.getDebt());
			ps.setInt(5, c.getPayterm());
			ps.setBigDecimal(6, c.getWeekpay());
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				nOwn = c;
			}
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return nOwn;
	}

	@Override
	public Grimlist addGrimoire(Grimlist grim) {
		Grimlist res = new Grimlist();
		String sql = "INSERT INTO shop.grimlist (grimname,grimcondition,grimschool,grimstatus,grimnote,baseprice, grimauthor) VALUES (?,?,?,?,?,?,?) RETURNING gid;";
		
		try {
			PreparedStatement ps = DatabaseConnect.getConnectionFromFile().prepareStatement(sql);
			
			ps.setString(1, grim.getGrimname());
			ps.setString(2, grim.getGrimcondition());
			ps.setString(3, grim.getGrimschool());
			ps.setString(4, grim.getGrimstatus());
			ps.setString(5, grim.getGrimnote());
			ps.setBigDecimal(6, grim.getBaseprice());
			ps.setString(7, grim.getGrimauthor());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				res = grim;
				res.setGid(rs.getInt("gid"));
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}



}
