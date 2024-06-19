package com.betacom.object;

public abstract class Car {
	String model;
	String color;
	int maxspeed;
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model =  model;
	}
	public String getColor() {
		return model;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	public Integer getMaxSpeed() {
		return maxspeed;
	}
	
	public void setMaxSpeed(Integer maxspeed) {
		this.maxspeed = maxspeed;
	}
	
	public void freni () {
		System.out.println("le macchine frenano");
	}
	
}
