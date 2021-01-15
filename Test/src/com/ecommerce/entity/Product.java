package com.ecommerce.entity;

public class Product {

	private String id;
	private String name;
	private String catagory;
	private String price;
	private int pices;
	
	public int getPices() {
		return pices;
	}

	public void setPices(int pices) {
		this.pices = pices;
	}

	public Product(String id, String name, String catagory, String price) {
		super();
		this.id = id;
		this.name = name;
		this.catagory = catagory;
		this.price = price;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCatagory() {
		return catagory;
	}
	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

	public int calculateCost() {
		return Integer.parseInt(price)*pices;
	}
	
}
