package org.hb.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "USER_DETAILS_M2M")
public class UserDetailsCollectionsM2M {
	
	@Id
	@GeneratedValue
	private int userId;
	private String userName;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "userList")
	private Collection<RentalVehicle> vehicleSet = new ArrayList<RentalVehicle>();
	
	
	public Collection<RentalVehicle> getVehicleSet() {
		return vehicleSet;
	}
	public void setVehicleSet(Collection<RentalVehicle> vehicleSet) {
		this.vehicleSet = vehicleSet;
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
	public UserDetailsCollectionsM2M(int userId, String userName, Date date) {
		this.userId = userId;
		this.userName = userName;
		this.date = date;
	}
	public UserDetailsCollectionsM2M() {

	}
	public UserDetailsCollectionsM2M(String userName, Date date) {
		this.userName = userName;
		this.date = date;
	}
	
	
	

}
