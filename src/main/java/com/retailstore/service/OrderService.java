package com.retailstore.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

import com.retailstore.dto.OrderDTO;
import com.retailstore.enumeration.ProductTypes;
import com.retailstore.enumeration.UserTypes;
import com.retailstore.exception.ApiRequestException;
import com.retailstore.model.Order;
import com.retailstore.model.Product;

@Service
public class OrderService {
	
	
	public Order giveOrder(OrderDTO orderDto) {
		
		double discPercent = 0;
		
		if(orderDto != null) {
			
			Date inputDate = orderDto.getUser().getCreatedOn();
			LocalDate createdDate = inputDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			Period period = Period.between(createdDate, LocalDate.now());
			int custPeriod = period.getYears();	
			
			if(orderDto.getUser().getUserType() == UserTypes.EMPLOYEE) {
				discPercent = 30;
			}
			else if(orderDto.getUser().getUserType() == UserTypes.AFFILIATED) {
				discPercent = 10;
			}
			else if(orderDto.getUser().getUserType() == UserTypes.CUSTOMER && custPeriod>=2) {
				discPercent = 5;
			}
			else {
				discPercent = 0;
			}
			
			List<Product> productsForDisc = new ArrayList<>();
			List<Product> groceryProducts = new ArrayList<>();
			
			for(Product p: orderDto.getProducts()) 
			{	
				if(p.getProductType() != ProductTypes.GROCERIES) 
				{
					productsForDisc.add(p);
				}
				else{
					groceryProducts.add(p);
				}
			}
			
			double finalPrice = this.calculateFinalPrice(productsForDisc, groceryProducts, discPercent);
			Order order;
			
			if(finalPrice != 0.0) {
				
				order = new Order(orderDto.getProducts(), 
						discPercent, finalPrice, orderDto.getUser().getUserId());
			}
			
			else {
				throw new ApiRequestException("Failed to calculate the discount and final price!");
			}
			
			return order;
			
		}
		else {
			throw new ApiRequestException("Failed to load the order details!");
		}
	}

	
	public double calculateFinalPrice(List<Product> otherProducts, List<Product> groceryProducts, double discPercent) {
		
		double discountedPrice = 0;
		double finalPrice = 0;
		double otherProductsPrice = 0;
		double groceryProductsPrice = 0;
		
		for(Product p1: otherProducts) {
			otherProductsPrice = otherProductsPrice + p1.getProductPrice();
		}
		
		for(Product p2: groceryProducts) {
			groceryProductsPrice = groceryProductsPrice + p2.getProductPrice();
		}
		
		//final discount calculation of products other than groceries
		
		discountedPrice = otherProductsPrice - ((discPercent/100) * otherProductsPrice);
		finalPrice = discountedPrice + groceryProductsPrice;
		
		if(finalPrice != 0.0) {
			return finalPrice;
		}
		
		else {
			throw new ApiRequestException("Failed to calculate the discount and final price!");
		}

	}
}
