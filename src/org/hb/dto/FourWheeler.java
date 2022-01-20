package org.hb.dto;

import javax.persistence.Entity;

@Entity
public class FourWheeler extends VehicleInheritance{

	private String SteeringWheel;

	public String getSteeringHandle() {
		return SteeringWheel;
	}

	public void setSteeringHandle(String steeringHandle) {
		SteeringWheel = steeringHandle;
	}
}
