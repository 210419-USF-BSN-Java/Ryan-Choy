package com.revature.shop.models;

import java.io.Serializable;
import java.math.BigDecimal;

public class Grimlist implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer gid;
	private String grimname;
	private String grimschool;
	private String grimauthor;
	private String grimcondition;
	private String grimstatus;
	private String grimnote;
	private BigDecimal baseprice;
	public Grimlist() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Grimlist(Integer gid, String grimname, String grimschool, String grimauthor, String grimcondition,
			String grimstatus, String grimnote, BigDecimal baseprice) {
		super();
		this.gid = gid;
		this.grimname = grimname;
		this.grimschool = grimschool;
		this.grimauthor = grimauthor;
		this.grimcondition = grimcondition;
		this.grimstatus = grimstatus;
		this.grimnote = grimnote;
		this.baseprice = baseprice;
	}
	@Override
	public String toString() {
		return "Id: " + gid + ", Title: " + grimname + ", School: " + grimschool + ", Author: "
				+ grimauthor + ", Base price: $" + baseprice + ", Condition: " + grimcondition + ", Status: "
				+ grimstatus + ", Note: " + grimnote;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((baseprice == null) ? 0 : baseprice.hashCode());
		result = prime * result + ((gid == null) ? 0 : gid.hashCode());
		result = prime * result + ((grimauthor == null) ? 0 : grimauthor.hashCode());
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
		Grimlist other = (Grimlist) obj;
		if (baseprice == null) {
			if (other.baseprice != null)
				return false;
		} else if (!baseprice.equals(other.baseprice))
			return false;
		if (gid == null) {
			if (other.gid != null)
				return false;
		} else if (!gid.equals(other.gid))
			return false;
		if (grimauthor == null) {
			if (other.grimauthor != null)
				return false;
		} else if (!grimauthor.equals(other.grimauthor))
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
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public String getGrimname() {
		return grimname;
	}
	public void setGrimname(String grimname) {
		this.grimname = grimname;
	}
	public String getGrimschool() {
		return grimschool;
	}
	public void setGrimschool(String grimschool) {
		this.grimschool = grimschool;
	}
	public String getGrimauthor() {
		return grimauthor;
	}
	public void setGrimauthor(String grimauthor) {
		this.grimauthor = grimauthor;
	}
	public String getGrimcondition() {
		return grimcondition;
	}
	public void setGrimcondition(String grimcondition) {
		this.grimcondition = grimcondition;
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
	
	
	
}
