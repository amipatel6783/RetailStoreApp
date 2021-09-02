package com.retailstore;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.retailstore.dto.OrderDTO;
import com.retailstore.enumeration.ProductTypes;
import com.retailstore.enumeration.UserTypes;
import com.retailstore.model.User;
import com.retailstore.service.OrderService;
import com.retailstore.model.Order;
import com.retailstore.model.Product;

@SpringBootTest
class RetailStoreApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	
	@Autowired
	OrderService orderService;
	
	@Test
	public void testCustomerDiscount() throws Exception {

		//convert String to Date
		Date custJoinDate = new SimpleDateFormat("yyyy-MM-dd").parse("2017-09-02");  
		User user = new User(1,"patelami", UserTypes.CUSTOMER, custJoinDate);
		List<Product> products = Arrays.asList(
				new Product(101, "groceryProduct", 125.00, ProductTypes.GROCERIES),
				new Product(102, "groceryProduct", 235.00, ProductTypes.GROCERIES),
				new Product(201, "housewareProduct", 95.00, ProductTypes.HOUSEWARES),
				new Product(301, "clothingProduct", 575.00, ProductTypes.CLOTHING));
		OrderDTO dto = new OrderDTO(user, products);
		Order order = this.orderService.giveOrder(dto);
		assertEquals(996.5, order.getFinalPrice(), 0.5);
	
	}
	
	@Test
	public void testAffiliateDiscount() throws Exception {

		//convert String to Date
		Date custJoinDate = new SimpleDateFormat("yyyy-MM-dd").parse("2020-12-01");  
		User user = new User(2,"jennie", UserTypes.AFFILIATED, custJoinDate);
		List<Product> products = Arrays.asList(
				new Product(101, "electronicProduct1", 645.00, ProductTypes.ELECTRONICS),
				new Product(102, "electronicProduct2", 2000.00, ProductTypes.ELECTRONICS),
				new Product(201, "housewareProduct1", 455.00, ProductTypes.HOUSEWARES),
				new Product(301, "clothingProduct", 875.00, ProductTypes.CLOTHING),
				new Product(301, "housewareProduct2", 140.00, ProductTypes.HOUSEWARES));
		OrderDTO dto = new OrderDTO(user, products);
		Order order = this.orderService.giveOrder(dto);
		assertEquals(3703.5, order.getFinalPrice(), 0.5);
	
	}
	
	@Test
	public void testEmployeeDiscount() throws Exception {

		//convert String to Date
		Date custJoinDate = new SimpleDateFormat("yyyy-MM-dd").parse("2021-12-01");  
		User user = new User(3,"mark", UserTypes.EMPLOYEE, custJoinDate);
		List<Product> products = Arrays.asList(
				new Product(101, "electronicProduct1", 6430.00, ProductTypes.ELECTRONICS),
				new Product(102, "electronicProduct2", 2500.00, ProductTypes.ELECTRONICS),
				new Product(201, "housewareProduct1", 550.00, ProductTypes.HOUSEWARES),
				new Product(301, "clothingProduct", 800.00, ProductTypes.CLOTHING),
				new Product(202, "housewareProduct2", 340.00, ProductTypes.HOUSEWARES),
				new Product(401, "groceryProduct1", 70.00, ProductTypes.GROCERIES),
				new Product(402, "groceryProduct2", 60.00, ProductTypes.GROCERIES));
		OrderDTO dto = new OrderDTO(user, products);
		Order order = this.orderService.giveOrder(dto);
		assertEquals(7564.0, order.getFinalPrice(), 0.5);
	
	}
}
