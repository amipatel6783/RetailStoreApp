package com.retailstore.dto;


import java.util.List;
import com.retailstore.model.Product;
import com.retailstore.model.User;

public class OrderDTO {
	
	private User user;
	private List<Product> products;
	
	
	public OrderDTO(User user, List<Product> products) {
		super();
		this.user = user;
		this.products = products;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}


	@Override
	public String toString() {
		return "OrderDTO [user=" + user + ", products=" + products + "]";
	}
	
	
	

}
