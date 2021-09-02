package com.retailstore.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.retailstore.dto.OrderDTO;
import com.retailstore.enumeration.ProductTypes;
import com.retailstore.enumeration.UserTypes;
import com.retailstore.exception.ApiRequestException;
import com.retailstore.model.Order;
import com.retailstore.model.Product;
import com.retailstore.model.User;
import com.retailstore.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/addNew")
	public Order saveOrder() throws ParseException {
		
		Date custJoinDate = new SimpleDateFormat("yyyy-MM-dd").parse("2017-09-02");  
		User user = new User(1,"patelami", UserTypes.CUSTOMER, custJoinDate);
		List<Product> products = Arrays.asList(
				new Product(101, "groceryProduct", 125.00, ProductTypes.GROCERIES),
				new Product(102, "groceryProduct", 235.00, ProductTypes.GROCERIES),
				new Product(201, "housewareProduct", 95.00, ProductTypes.HOUSEWARES),
				new Product(301, "clothingProduct", 575.00, ProductTypes.CLOTHING));
		OrderDTO orderDTO = new OrderDTO(user, products);
		Order savedOrder = this.orderService.giveOrder(orderDTO);
		if(savedOrder != null) {
			return savedOrder;
		}
		else {
			throw new ApiRequestException("Failed to generate order!");
		}
	}
	

	
	

}
