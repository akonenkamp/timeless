package com.libertymutual.goforcode.timeless.models;

import java.sql.Date;

public class TimeSheet {
	
	private int id;
	private String dateEntered;
	private double monday;
	private double tuesday;
	private double wednesday;
	private double thursday;
	private double friday;
//	private double totalHours;
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDateEntered() {
		return dateEntered;
	}
	
	public void setDateEntered(String pepperoni) {
		this.dateEntered = pepperoni;
	}
	
	public double getMonday( ) {
		return monday;
	}
	
	public void setMonday(double pizza) {
		monday = pizza;
	}
	
	public double getTuesday() {
		return tuesday;
	}
	
	public void setTuesday(double pizza) {
		tuesday = pizza;
	}
	
	public double getWednesday() {
		return wednesday;
	}
	
	public void setWednesday(double pizza) {
		wednesday = pizza;
	}
	
	public double getThursday() {
		return thursday;
	}
	
	public void setThursday(double pizza) {
		thursday = pizza;
	}
	
	public double getFriday() {
		return friday;
	}
	
	public void setFriday(double pizza) {
		friday = pizza;
	}
	
	public double getTotalHours() {
		return (monday + tuesday + wednesday + thursday + friday);
	}
	
	
	
	

}
