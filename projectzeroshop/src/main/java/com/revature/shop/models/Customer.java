package com.revature.shop.models;

import java.io.Serializable;
import java.math.BigDecimal;

public class Customer implements Serializable{
	
	private static final long serialVersionUID = 1L;

	//gid and grim name on db
	private Grimlist grimoire;
	//uid on db
	private User owner;
	private BigDecimal debt;
	private Integer payterm;
	private BigDecimal weekpay;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(Grimlist grimoire, User owner, BigDecimal debt, Integer payterm, BigDecimal weekpay) {
		super();
		this.grimoire = grimoire;
		this.owner = owner;
		this.debt = debt;
		this.payterm = payterm;
		this.weekpay = weekpay;
	}

	@Override
	public String toString() {
		return "Customer [grimoire=" + grimoire + ", owner=" + owner + ", debt=" + debt + ", payterm=" + payterm
				+ ", weekpay=" + weekpay + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((debt == null) ? 0 : debt.hashCode());
		result = prime * result + ((grimoire == null) ? 0 : grimoire.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + ((payterm == null) ? 0 : payterm.hashCode());
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
		if (grimoire == null) {
			if (other.grimoire != null)
				return false;
		} else if (!grimoire.equals(other.grimoire))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (payterm == null) {
			if (other.payterm != null)
				return false;
		} else if (!payterm.equals(other.payterm))
			return false;
		if (weekpay == null) {
			if (other.weekpay != null)
				return false;
		} else if (!weekpay.equals(other.weekpay))
			return false;
		return true;
	}

	public Grimlist getGrimoire() {
		return grimoire;
	}

	public void setGrimoire(Grimlist grimoire) {
		this.grimoire = grimoire;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public BigDecimal getDebt() {
		return debt;
	}

	public void setDebt(BigDecimal debt) {
		this.debt = debt;
	}

	public Integer getPayterm() {
		return payterm;
	}

	public void setPayterm(Integer payterm) {
		this.payterm = payterm;
	}

	public BigDecimal getWeekpay() {
		return weekpay;
	}

	public void setWeekpay(BigDecimal weekpay) {
		this.weekpay = weekpay;
	}
	
	
	


	
	
}
