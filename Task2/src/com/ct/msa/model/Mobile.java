package com.ct.msa.model;

public class Mobile {
	private String name;
	private String description;
	private int id;
	private float price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Mobile() {
		// TODO Auto-generated constructor stub
	}

	public Mobile(String name, String description, int id, float price) {
		super();
		this.name = name;
		this.description = description;
		this.id = id;
		this.price = price;
	}

}
