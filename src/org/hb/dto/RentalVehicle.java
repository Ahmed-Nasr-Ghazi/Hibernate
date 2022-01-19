package org.hb.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table (name = "RENTAL_Vehicle")
public class RentalVehicle {

	@Id @GeneratedValue
	private int vehicleId;
	private String vehicleName;
	

	@ManyToMany(cascade = CascadeType.ALL)
	private Collection<UserDetailsCollectionsM2M> userList = new ArrayList<UserDetailsCollectionsM2M>();

	
	public Collection<UserDetailsCollectionsM2M> getUserList() {
		return userList;
	}
	public void setUserList(Collection<UserDetailsCollectionsM2M> userList) {
		this.userList = userList;
	}
	
	
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
	
}
