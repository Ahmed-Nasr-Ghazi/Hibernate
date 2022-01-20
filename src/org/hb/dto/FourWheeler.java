package org.hb.dto;

import javax.persistence.Entity;

@Entity
public class FourWheeler {

	private String SteeringHandle;

	public String getSteeringHandle() {
		return SteeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		SteeringHandle = steeringHandle;
	}
}
