package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.demo.entity.Order;

public interface IOrderService {

	List<Order> getOrdersFromDatabase();

	Optional<Order> getOrderById(int id);

	void deleteOrderById(int id);

	Order createOrder(Order newOrder);

	ResponseEntity<Order> updateOrder(Integer orderId, Order newOrder);
}
