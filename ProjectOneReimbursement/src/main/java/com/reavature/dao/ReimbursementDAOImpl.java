package com.reavature.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.util.DatabaseConnect;

public class ReimbursementDAOImpl implements ReimbursementDAO {

	@Override
	public List<Reimbursement> viewReimbursement(Integer userId) {
		// employee: view all resolved reimbursement requests

		List<Reimbursement> empList = new ArrayList<>();

		String sql = "SELECT * FROM ers.ers_reimbursement WHERE ers_users_id = ? AND reimb_status_id = 2 OR reimb_status_id = 3 ORDER BY reimb_resolved";

		try {
			PreparedStatement ps = DatabaseConnect.getConnection().prepareStatement(sql);
			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Reimbursement res = new Reimbursement();
				res.setReimbId(rs.getInt("reimb_id"));
				res.setAmount(rs.getBigDecimal("reimb_amount"));
				res.setDateSubmitted(rs.getTimestamp("reimb_submitted"));
				res.setDateResolved(rs.getTimestamp("reimb_resolved"));
				res.setReceipt(rs.getAsciiStream("reimb_receipt"));
				res.setAuthor(rs.getInt("ers_user_id"));
				res.setResolver(rs.getInt("reimb_resolver"));
				res.setStatusId(rs.getInt("reimb_status_id"));
				res.setTypeId(rs.getInt("reimb_type_id"));

				empList.add(res);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return empList;
	}

	@Override
	public List<Reimbursement> viewPendingReimbursement(Integer userId) {
		// employee: view their pending requests
		List<Reimbursement> pendList = new ArrayList<>();

		String sql = "SELECT * FROM ers.ers_reimbursement WHERE ers_users_id = ? AND reimb_status_id = 1 ORDER BY reimb_id";

		try {
			PreparedStatement ps = DatabaseConnect.getConnection().prepareStatement(sql);

			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Reimbursement res = new Reimbursement();
				res.setReimbId(rs.getInt("reimb_id"));
				res.setAmount(rs.getBigDecimal("reimb_amount"));
				res.setDateSubmitted(rs.getTimestamp("reimb_submitted"));
				res.setDateResolved(rs.getTimestamp("reimb_resolved"));
				res.setReceipt(rs.getAsciiStream("reimb_receipt"));
				res.setAuthor(rs.getInt("ers_user_id"));
				res.setResolver(rs.getInt("reimb_resolver"));
				res.setStatusId(rs.getInt("reimb_status_id"));
				res.setTypeId(rs.getInt("reimb_type_id"));

				pendList.add(res);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pendList;
	}

	@Override
	public Reimbursement submitReinRequest(Reimbursement r) {
		Reimbursement nReim = new Reimbursement();
		
		String sql = "INSERT INTO ers.ers_reimbursement (reimb_amount, reimb_submitted, reimb_description, reimb_receipt, ers_users_id, reimb_status_id, reimb_type_id) VALUES (?,?,?,?,?,?,?) RETURNING reimb_id";
		
		try {
			PreparedStatement ps = DatabaseConnect.getConnection().prepareStatement(sql);
			
			ps.setBigDecimal(1, r.getAmount());
			ps.setTimestamp(2, Timestamp.from(Instant.now()));
			ps.setString(3, r.getDescription());
			ps.setAsciiStream(4, r.getReceipt());
			ps.setInt(5, r.getAuthor());
			ps.setInt(6, r.getStatusId());
			ps.setInt(7, r.getTypeId());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				nReim = r;
				nReim.setDateSubmitted(rs.getTimestamp("reimb_submitted"));
				nReim.setReimbId(rs.getInt("reimb_id"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return nReim;
	}

	@Override
	public List<Reimbursement> viewPendingReimbursement() {
		//manager: view all pending requests from all employees
		
		List<Reimbursement> pReim = new ArrayList<>();
		
		String sql = "SELECT * FROM ers.ers_reimbursement WHERE reimb_status_id = 1 ORDER BY reimb_id";
		
		try {
			PreparedStatement ps = DatabaseConnect.getConnection().prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Reimbursement res = new Reimbursement();
				res.setReimbId(rs.getInt("reimb_id"));
				res.setAmount(rs.getBigDecimal("reimb_amount"));
				res.setDateSubmitted(rs.getTimestamp("reimb_submitted"));
				res.setDateResolved(rs.getTimestamp("reimb_resolved"));
				res.setReceipt(rs.getAsciiStream("reimb_receipt"));
				res.setAuthor(rs.getInt("ers_user_id"));
				res.setResolver(rs.getInt("reimb_resolver"));
				res.setStatusId(rs.getInt("reimb_status_id"));
				res.setTypeId(rs.getInt("reimb_type_id"));

				pReim.add(res);

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pReim;
	}

	@Override
	public List<Reimbursement> viewReimbursement() {
		//manager: view all resolved requests
		List<Reimbursement> rReim = new ArrayList<>();
		
		String sql = "SELECT * FROM ers.ers_reimbursement WHERE reimb_status_id = 2 OR reimb_status_id = 3 ORDER BY reimb_resolved ORDER BY reimb_resolved";
		
		try {
			PreparedStatement ps = DatabaseConnect.getConnection().prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Reimbursement res = new Reimbursement();
				res.setReimbId(rs.getInt("reimb_id"));
				res.setAmount(rs.getBigDecimal("reimb_amount"));
				res.setDateSubmitted(rs.getTimestamp("reimb_submitted"));
				res.setDateResolved(rs.getTimestamp("reimb_resolved"));
				res.setReceipt(rs.getAsciiStream("reimb_receipt"));
				res.setAuthor(rs.getInt("ers_user_id"));
				res.setResolver(rs.getInt("reimb_resolver"));
				res.setStatusId(rs.getInt("reimb_status_id"));
				res.setTypeId(rs.getInt("reimb_type_id"));

				rReim.add(res);

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rReim;
	}

	@Override
	public List<Reimbursement> viewReimbursementEmp(Integer userId) {
		// manager view pending requests from a single employee
		List<Reimbursement> empReq = new ArrayList<>();

		String sql = "SELECT * FROM ers.ers_reimbursement WHERE ers_users_id = ? AND reimb_status_id = 1 ORDER BY reimb_id";

		try {
			PreparedStatement ps = DatabaseConnect.getConnection().prepareStatement(sql);
			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Reimbursement res = new Reimbursement();
				res.setReimbId(rs.getInt("reimb_id"));
				res.setAmount(rs.getBigDecimal("reimb_amount"));
				res.setDateSubmitted(rs.getTimestamp("reimb_submitted"));
				res.setDateResolved(rs.getTimestamp("reimb_resolved"));
				res.setReceipt(rs.getAsciiStream("reimb_receipt"));
				res.setAuthor(rs.getInt("ers_user_id"));
				res.setResolver(rs.getInt("reimb_resolver"));
				res.setStatusId(rs.getInt("reimb_status_id"));
				res.setTypeId(rs.getInt("reimb_type_id"));

				empReq.add(res);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return empReq;
	}

	@Override
	public String updateReimbursementRequest(int update, Integer reimbId) {
		
		String sql = "UPDATE ers.ers_reimbursement SET reimb_status_id = ? WHERE reimb_id = ?";
		
		try {
			PreparedStatement ps = DatabaseConnect.getConnection().prepareStatement(sql);
			
			ps.setInt(1, update);
			ps.setInt(2, reimbId);
			
			int res = ps.executeUpdate();
			if(ps.executeUpdate()>= 1) {
				return "Update successful!";
				
			} else {
				return "Update failed!";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

}
