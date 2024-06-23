package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Order;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.IOrderService;

@RestController
@RequestMapping("/api") // http://localhost:9191/api/hello
public class OrderController {

	@Autowired
	private IOrderService orderService;

	@GetMapping("/hello")
	String hello() {
		return "Hello World, Spring Boot.... Welcome to You!";
	}

	//@GetMapping(path = "/orders", produces = {MediaType.APPLICATION_XML_VALUE})
	@GetMapping("/orders") // http://localhost:9191/api/orders
	 List<Order> getAllOrders() {
		return orderService.getOrdersFromDatabase();
	}

	@GetMapping("/orders/{id}")
	public Optional<Order> getOrderById(@PathVariable int id) throws ResourceNotFoundException {
		Optional<Order> order = orderService.getOrderById(id);
		order.orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + id));
		return order;
	}

	@DeleteMapping("/orders/{id}")
	public void deleteOrderById(@PathVariable int id) {
		orderService.deleteOrderById(id);
	}

	@PostMapping("/orders")
	public Order createOrder(@Validated @RequestBody Order newOrder) {
		return orderService.createOrder(newOrder);
	}

	@PutMapping("/orders/{id}")
	public ResponseEntity<Order> updateOrder(@PathVariable(value = "id") Integer orderId,
			@Validated @RequestBody Order newOrder) {
		return orderService.updateOrder(orderId, newOrder);
	}

	@GetMapping("/orders/req")
	public Optional<Order> findOrderByOrderIdUsingRequestParam(@RequestParam int id) {
		return orderService.getOrderById(id);
	}

}
