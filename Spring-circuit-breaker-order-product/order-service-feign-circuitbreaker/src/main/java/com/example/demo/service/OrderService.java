package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.demo.entity.Order;
import com.example.demo.repo.OrderRepository;

@Service
public class OrderService implements IOrderService {

	private final Logger logger = LoggerFactory.getLogger(OrderService.class);

	@Autowired
	OrderRepository orderRepo;

	@Override
	public List<Order> getOrdersFromDatabase() {
		logger.info("Fetching all orders...");
		return orderRepo.findAll();
	}

	@Override
	public Optional<Order> getOrderById(int id) {
		return orderRepo.findById(id);
	}

	@Override
	public void deleteOrderById(int id) {
		orderRepo.deleteById(id);
	}

	@Override
	public Order createOrder(@Validated Order newOrder) {
		return orderRepo.save(newOrder);
	}

	@Override
	public ResponseEntity<Order> updateOrder(Integer orderId, @Validated Order newOrder) {
		Optional<Order> existingOrder = orderRepo.findById(orderId);
		existingOrder.ifPresent(order -> {
			order.setDescription(newOrder.getDescription());
			orderRepo.save(order);
		});
		return ResponseEntity.of(existingOrder);
	}
}
