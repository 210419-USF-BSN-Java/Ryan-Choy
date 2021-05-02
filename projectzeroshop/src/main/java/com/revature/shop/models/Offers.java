package com.revature.shop.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Offers implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	private String odate;
	private Integer oid;
	//gid and grim name on db
	private Grimlist grimoire;
	//uid, first name, last name on db
	private User customer;
	private BigDecimal offer;
	private Integer payterm;
	private String offerstatus;
	public Offers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Offers(String odate, Integer oid, Grimlist grimoire, User customer, BigDecimal offer, Integer payterm,
			String offerstatus) {
		super();
		this.odate = odate;
		this.oid = oid;
		this.grimoire = grimoire;
		this.customer = customer;
		this.offer = offer;
		this.payterm = payterm;
		this.offerstatus = offerstatus;
	}
	@Override
	public String toString() {
		return "Offers [oid=" + oid + ", grimoire=" + grimoire + ", customer=" + customer + ", offer=" + offer
				+ ", payterm=" + payterm + ", offerstatus=" + offerstatus + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((grimoire == null) ? 0 : grimoire.hashCode());
		result = prime * result + ((offer == null) ? 0 : offer.hashCode());
		result = prime * result + ((offerstatus == null) ? 0 : offerstatus.hashCode());
		result = prime * result + ((oid == null) ? 0 : oid.hashCode());
		result = prime * result + ((payterm == null) ? 0 : payterm.hashCode());
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
		Offers other = (Offers) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (grimoire == null) {
			if (other.grimoire != null)
				return false;
		} else if (!grimoire.equals(other.grimoire))
			return false;
		if (offer == null) {
			if (other.offer != null)
				return false;
		} else if (!offer.equals(other.offer))
			return false;
		if (offerstatus == null) {
			if (other.offerstatus != null)
				return false;
		} else if (!offerstatus.equals(other.offerstatus))
			return false;
		if (oid == null) {
			if (other.oid != null)
				return false;
		} else if (!oid.equals(other.oid))
			return false;
		if (payterm == null) {
			if (other.payterm != null)
				return false;
		} else if (!payterm.equals(other.payterm))
			return false;
		return true;
	}
	public String getOdate() {
		return odate;
	}
	public void setOdate(String odate) {
		this.odate = odate;
	}
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public Grimlist getGrimoire() {
		return grimoire;
	}
	public void setGrimoire(Grimlist grimoire) {
		this.grimoire = grimoire;
	}
	public User getCustomer() {
		return customer;
	}
	public void setCustomer(User customer) {
		this.customer = customer;
	}
	public BigDecimal getOffer() {
		return offer;
	}
	public void setOffer(BigDecimal offer) {
		this.offer = offer;
	}
	public Integer getPayterm() {
		return payterm;
	}
	public void setPayterm(Integer payterm) {
		this.payterm = payterm;
	}
	public String getOfferstatus() {
		return offerstatus;
	}
	public void setOfferstatus(String offerstatus) {
		this.offerstatus = offerstatus;
	}
	
	
	
	
}
