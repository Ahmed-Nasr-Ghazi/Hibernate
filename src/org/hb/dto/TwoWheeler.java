package org.hb.dto;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue(value = "Bike") //instade of mentioning class name in DTYPE column 
public class TwoWheeler extends VehicleInheritance {

	private String SteeringHandle;


	public String getSteeringHandle() {
		return SteeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		SteeringHandle = steeringHandle;
	}
	
	
	
	
}
