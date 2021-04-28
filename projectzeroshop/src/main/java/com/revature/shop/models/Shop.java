package com.revature.shop.models;

import java.math.BigDecimal;

public class Shop {
	private int gid;
	private String grimname;
	private String grimcondition;
	private String grimschool;
	private String grimstatus;
	private String grimnote;
	private BigDecimal baseprice;
	
	
	
	public Shop() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Shop(int gid, String grimname, String grimcondition, String grimschool, String grimstatus, String grimnote,
			BigDecimal baseprice) {
		super();
		this.gid = gid;
		this.grimname = grimname;
		this.grimcondition = grimcondition;
		this.grimschool = grimschool;
		this.grimstatus = grimstatus;
		this.grimnote = grimnote;
		this.baseprice = baseprice;
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

	public String getGrimcondition() {
		return grimcondition;
	}

	public void setGrimcondition(String grimcondition) {
		this.grimcondition = grimcondition;
	}

	public String getGrimschool() {
		return grimschool;
	}

	public void setGrimschool(String grimschool) {
		this.grimschool = grimschool;
	}

	public String getGrimstatus() {
		return grimstatus;
	}

	public void setGrimstatus(String grimstatus) {
		this.grimstatus = grimstatus;
	}

	public String getGrimnote() {
		return grimnote;
	}

	public void setGrimnote(String grimnote) {
		this.grimnote = grimnote;
	}

	public BigDecimal getBaseprice() {
		return baseprice;
	}

	public void setBaseprice(BigDecimal baseprice) {
		this.baseprice = baseprice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((baseprice == null) ? 0 : baseprice.hashCode());
		result = prime * result + gid;
		result = prime * result + ((grimcondition == null) ? 0 : grimcondition.hashCode());
		result = prime * result + ((grimname == null) ? 0 : grimname.hashCode());
		result = prime * result + ((grimnote == null) ? 0 : grimnote.hashCode());
		result = prime * result + ((grimschool == null) ? 0 : grimschool.hashCode());
		result = prime * result + ((grimstatus == null) ? 0 : grimstatus.hashCode());
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
		Shop other = (Shop) obj;
		if (baseprice == null) {
			if (other.baseprice != null)
				return false;
		} else if (!baseprice.equals(other.baseprice))
			return false;
		if (gid != other.gid)
			return false;
		if (grimcondition == null) {
			if (other.grimcondition != null)
				return false;
		} else if (!grimcondition.equals(other.grimcondition))
			return false;
		if (grimname == null) {
			if (other.grimname != null)
				return false;
		} else if (!grimname.equals(other.grimname))
			return false;
		if (grimnote == null) {
			if (other.grimnote != null)
				return false;
		} else if (!grimnote.equals(other.grimnote))
			return false;
		if (grimschool == null) {
			if (other.grimschool != null)
				return false;
		} else if (!grimschool.equals(other.grimschool))
			return false;
		if (grimstatus == null) {
			if (other.grimstatus != null)
				return false;
		} else if (!grimstatus.equals(other.grimstatus))
			return false;
		return true;
	}
	
	

}
