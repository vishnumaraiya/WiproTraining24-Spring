package com.example.demo.cts;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.demo.entity.Order;

public class OrderFeignClientFallback implements OrderFeignClient {

	@Override
    public List<Order> productResponse() {
        return Stream.of(
                new Order(119,"order1"),
                new Order(345, "Headset"),
                new Order(475, "Sound bar"),
                new Order(574, "Puma Shoes"),
                new Order(678, "Vegetable chopper"),
                new Order(532, "Oven Gloves")
        ).collect(Collectors.toList());
    }

	@Override
	public String getException() {
		
		return "Fixed Response";
	}

}
