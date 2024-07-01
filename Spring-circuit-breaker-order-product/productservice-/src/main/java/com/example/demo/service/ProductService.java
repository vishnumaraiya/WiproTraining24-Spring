package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.demo.entity.Product;
import com.example.demo.repo.ProductRepository;

@Service
public class ProductService implements IProductService {
	
	private final Logger logger = LoggerFactory.getLogger(ProductService.class);

	@Autowired
	ProductRepository productRepo;

	@Override
	public List<Product> getProductsFromDatabase() {
		logger.info("Fetching all records...");
		return productRepo.findAll();
	}

	@Override
	public Optional<Product> getProductById(int id) {
		
		return productRepo.findById(id);
	}

	@Override
	public void deleteProductById(int id) {
		productRepo.deleteById(id);
		
	}

	@Override
	public Product createProduct(@Validated Product newProduct) {
		// TODO Auto-generated method stub
		return productRepo.save(newProduct);
	}

	@Override
	public ResponseEntity<Product> updateProduct(Integer productId,@Validated Product newProduct) {
		Optional<Product> existingProduct = productRepo.findById(productId);
		existingProduct.get().setPname(newProduct.getPname());
		existingProduct.get().setPrice(newProduct.getPrice());
		productRepo.save(existingProduct.get());
		return ResponseEntity.ok(existingProduct.get());
		
	}

	
	
}
