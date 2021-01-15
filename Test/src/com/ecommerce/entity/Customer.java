package com.ecommerce.entity;

public class Customer {

	private String id;
	private String name;
	private String mobile;
	private String isAffiliate;
	private String firstPurchageDate;
	
	public Customer(String id, String name, String mobile, String isAffiliate, String firstPurchageDate) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.isAffiliate = isAffiliate;
		this.firstPurchageDate = firstPurchageDate;
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getIsAffiliate() {
		return isAffiliate;
	}
	public void setIsAffiliate(String isAffiliate) {
		this.isAffiliate = isAffiliate;
	}
	public String getFirstPurchageDate() {
		return firstPurchageDate;
	}
	public void setFirstPurchageDate(String firstPurchageDate) {
		this.firstPurchageDate = firstPurchageDate;
	}
	
}
