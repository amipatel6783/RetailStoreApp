package com.retailstore.model;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class Order {
	
	
	private int orderId;
	private List<Product> products;
	private double discountPercent;
	private double finalPrice;
    private Date orderDate;
	private int userId;
	
	
	public Order(List<Product> products, double discountPercent, double finalPrice, int userId) {
		super();
		Random rand = new Random();
		this.orderId = Math.abs(rand.nextInt());
		this.products = products;
		this.discountPercent = discountPercent;
		this.finalPrice = finalPrice;
		this.orderDate = new Date();
		this.userId = userId;
		
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}


	public double getDiscountPercent() {
		return discountPercent;
	}


	public void setDiscountPercent(double discountPercent) {
		this.discountPercent = discountPercent;
	}


	public double getFinalPrice() {
		return finalPrice;
	}


	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}


	public Date getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", products=" + products + ", discountPercent=" + discountPercent
				+ ", finalPrice=" + finalPrice + ", orderDate=" + orderDate + ", userId=" + userId + "]";
	}

}
