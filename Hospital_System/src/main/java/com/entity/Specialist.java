package com.entity;

public class Specialist {
	private int id;
	private String spName;
	
	
	
	public Specialist() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Specialist(int id, String spName) {
		super();
		this.id = id;
		this.spName = spName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSpName() {
		return spName;
	}

	public void setSpName(String spName) {
		this.spName = spName;
	}
	
	
}
