package com.retailstore.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.retailstore.dto.OrderDTO;
import com.retailstore.exception.ApiRequestException;
import com.retailstore.model.Order;
import com.retailstore.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/addNew")
	public Order saveOrder(@RequestBody OrderDTO orderDTO) {
		
		Order savedOrder = this.orderService.giveOrder(orderDTO);
		if(savedOrder != null) {
			return savedOrder;
		}
		else {
			throw new ApiRequestException("Failed to generate order!");
		}
	}
	

	
	

}
