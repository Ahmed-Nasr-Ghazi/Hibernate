package org.hb.dto;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@org.hibernate.annotations.Entity(selectBeforeUpdate = true)
@Table(name = "USER_DETAILS_SIMPLE")
public class UserDetailsSimple {
	
	@Id
	@GeneratedValue
	@JoinColumn(name="User_ID")
	private int userId;
	private String userName;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	
	@JoinColumn(name="VEHICLE_ID")
	@OneToOne(cascade=CascadeType.ALL)
	private Vehicle vehicle;
	
	
	
	
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "UserDetailsSimple [userId=" + userId + ", userName=" + userName + ", date=" + date + "]";
	}
	public UserDetailsSimple(int userId, String userName, Date date) {
		this.userId = userId;
		this.userName = userName;
		this.date = date;
	}
	public UserDetailsSimple() {

	}
	public UserDetailsSimple(String userName, Date date) {
		this.userName = userName;
		this.date = date;
	}
	
	
	
}