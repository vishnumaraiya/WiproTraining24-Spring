package com.example.demo.cts;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Order;

import feign.Headers;

@Headers("Content-Type: application/json")
//@FeignClient(name = "emp-ws", url = "${feign.url}")

//@FeignClient(name = "emp-ws", url = "${EMPLOYEE_SERVICE:http://localhost:7000}")
@FeignClient(name = "productservice", url = "${PRODUCT_SERVICE:http://localhost:9196}",fallback = OrderFeignClientFallback.class)
public interface OrderFeignClient {
//	@GetMapping("/api/product/products") // it means call /products mapping from service whose name id "productservice
//	String productResponse();
	
	@GetMapping("/api/products")	
	List<Order> productResponse();
	
	 @RequestMapping(method = RequestMethod.GET, value = "NOT_FOUND")
	    String getException();

}
// EMPLOYEE_SERVICE=http://33.25.56.120:7000
