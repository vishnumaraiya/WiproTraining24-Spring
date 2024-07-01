package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.demo.entity.Product;

public interface IProductService {

	List<Product> getProductsFromDatabase();

	Optional<Product> getProductById(int id);

	void deleteProductById(int id);

	Product createProduct(Product newProduct);

	ResponseEntity<Product> updateProduct(Integer productId, Product newProduct);

}
