package com.revature.shop.models;

import java.math.BigDecimal;

public class Offers {

	private String date;
	private int oid;
	private int gid;
	private String grimname;
	private int uid;
	private String firstname;
	private String lastname;
	private BigDecimal offer;
	private int payterm;
	private String offerstatus;
	
	
	
	public Offers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Offers(String date, int oid, int gid, String grimname, int uid, String firstname, String lastname,
			BigDecimal offer, int payterm, String offerstatus) {
		super();
		this.date = date;
		this.oid = oid;
		this.gid = gid;
		this.grimname = grimname;
		this.uid = uid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.offer = offer;
		this.payterm = payterm;
		this.offerstatus = offerstatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + gid;
		result = prime * result + ((grimname == null) ? 0 : grimname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((offer == null) ? 0 : offer.hashCode());
		result = prime * result + ((offerstatus == null) ? 0 : offerstatus.hashCode());
		result = prime * result + oid;
		result = prime * result + payterm;
		result = prime * result + uid;
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
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (gid != other.gid)
			return false;
		if (grimname == null) {
			if (other.grimname != null)
				return false;
		} else if (!grimname.equals(other.grimname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
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
		if (oid != other.oid)
			return false;
		if (payterm != other.payterm)
			return false;
		if (uid != other.uid)
			return false;
		return true;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public BigDecimal getOffer() {
		return offer;
	}

	public void setOffer(BigDecimal offer) {
		this.offer = offer;
	}

	public int getPayterm() {
		return payterm;
	}

	public void setPayterm(int payterm) {
		this.payterm = payterm;
	}

	public String getOfferstatus() {
		return offerstatus;
	}

	public void setOfferstatus(String offerstatus) {
		this.offerstatus = offerstatus;
	}

	@Override
	public String toString() {
		return "Offers [date=" + date + ", oid=" + oid + ", gid=" + gid + ", grimname=" + grimname + ", uid=" + uid
				+ ", firstname=" + firstname + ", lastname=" + lastname + ", offer=" + offer + ", payterm=" + payterm
				+ ", offerstatus=" + offerstatus + "]";
	}
	
	
	
	
}
