package org.hb.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue(value = "Car") //instade of mentioning class name in DTYPE column 
public class FourWheeler extends VehicleInheritance{

	private String SteeringWheel;

	public String getSteeringHandle() {
		return SteeringWheel;
	}

	public void setSteeringHandle(String steeringHandle) {
		SteeringWheel = steeringHandle;
	}
}
