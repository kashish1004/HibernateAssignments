package com.phoenix.entities;
/*
 * Author kashish.jain@stltech.in
 * Creation date - 7-jul-2021
 * Version 1.0
 * Copyright Sterlite Technologies Ltd.
 * Description It is a POJO class which acts 
 * 			   as a persistent class or entity
 *             class in Hibernate
 * */
public class Product {
	//attributes or instance variables
	private int productId;
	private String brand;
	private String productName;
	private float price;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product(int productId, String brand, String productName, float price) {
		super();
		this.productId = productId;
		this.brand = brand;
		this.productName = productName;
		this.price = price;
	}
	
	//setter and getter methods
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", brand=" + brand + ", productName=" + productName + ", price="
				+ price + "]";
	}
	
	
}
