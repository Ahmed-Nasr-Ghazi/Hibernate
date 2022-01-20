package org.hb.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table (name = "Vehicle_Inheritance")
public class VehicleInheritance {

	@Id @GeneratedValue
	private int vehicleId;
	private String vehicleName;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "USER_ID")
	private UserDetailsCollections user;
	
	public UserDetailsCollections getUser() {
		return user;
	}
	public void setUser(UserDetailsCollections user) {
		this.user = user;
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
