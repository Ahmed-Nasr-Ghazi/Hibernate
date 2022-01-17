package org.hb.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {

	@Id @GeneratedValue
	private int userId;
	private String userName;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@ElementCollection
	private Set<Address> setOfAddress = new HashSet<Address>();
	
	
	
	public Set<Address> getSetOfAddress() {
		return setOfAddress;
	}
	public void setSetOfAddress(Set<Address> setOfAddress) {
		this.setOfAddress = setOfAddress;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName + ", date=" + date + "]";
	}
	
	
	
}
