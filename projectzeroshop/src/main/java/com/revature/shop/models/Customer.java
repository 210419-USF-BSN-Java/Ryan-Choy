package com.revature.shop.models;

import java.math.BigDecimal;

public class Customer {
	private int gid;
	private String grimname;
	private int uid;
	private BigDecimal debt;
	private int payterm;
	private BigDecimal weekpay;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int gid, String grimname, int uid, BigDecimal debt, int payterm, BigDecimal weekpay) {
		super();
		this.gid = gid;
		this.grimname = grimname;
		this.uid = uid;
		this.debt = debt;
		this.payterm = payterm;
		this.weekpay = weekpay;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((debt == null) ? 0 : debt.hashCode());
		result = prime * result + gid;
		result = prime * result + ((grimname == null) ? 0 : grimname.hashCode());
		result = prime * result + payterm;
		result = prime * result + uid;
		result = prime * result + ((weekpay == null) ? 0 : weekpay.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (debt == null) {
			if (other.debt != null)
				return false;
		} else if (!debt.equals(other.debt))
			return false;
		if (gid != other.gid)
			return false;
		if (grimname == null) {
			if (other.grimname != null)
				return false;
		} else if (!grimname.equals(other.grimname))
			return false;
		if (payterm != other.payterm)
			return false;
		if (uid != other.uid)
			return false;
		if (weekpay == null) {
			if (other.weekpay != null)
				return false;
		} else if (!weekpay.equals(other.weekpay))
			return false;
		return true;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getGrimname() {
		return grimname;
	}

	public void setGrimname(String grimname) {
		this.grimname = grimname;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public BigDecimal getDebt() {
		return debt;
	}

	public void setDebt(BigDecimal debt) {
		this.debt = debt;
	}

	public int getPayterm() {
		return payterm;
	}

	public void setPayterm(int payterm) {
		this.payterm = payterm;
	}

	public BigDecimal getWeekpay() {
		return weekpay;
	}

	public void setWeekpay(BigDecimal weekpay) {
		this.weekpay = weekpay;
	}

	@Override
	public String toString() {
		return "Customer [gid=" + gid + ", grimname=" + grimname + ", uid=" + uid + ", debt=" + debt + ", payterm="
				+ payterm + ", weekpay=" + weekpay + "]";
	}

	
	
}
