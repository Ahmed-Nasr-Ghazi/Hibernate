package org.hb.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {

	@Id @GeneratedValue
	private int userId;
	private String userName;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name="USER_ADDRESS", //change table name
		joinColumns = @JoinColumn(name="USER_ID"))	//change column name
	
	@GenericGenerator(name = "sequence_gen", strategy = "sequence") //can be used anywhere in the application
	@CollectionId(columns = { @Column(name = "Address_Id") }, generator = "sequence_gen", type = @Type(type = "long")) 
	/*
	 * @CollectionId provided by hibernate not JPA
	 * to add an id column to a collection 
	 * define it's name, generation type and data type
	 * */
	private Collection<Address> listOfAddress = new ArrayList<Address>();
	

	public Collection<Address> getListOfAddress() {
		return listOfAddress;
	}
	public void setListOfAddress(Collection<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
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
