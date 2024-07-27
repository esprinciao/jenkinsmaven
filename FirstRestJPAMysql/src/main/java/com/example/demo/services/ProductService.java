package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
	
	
	
	@Autowired
	ProductRepository repository;
	
	public Product save(Product product) {
		
		return repository.save(product);
	
}

	public Product fetch(Long productId) {
		
		Optional<Product> optional = repository.findById(productId);
		
		if(optional.isPresent()) 
			return optional.get();
		else
			return null;
		
	}

	public List<Product> fetchAll() {

		return repository.findAll();
	}

	public Boolean delete(Long productId) {
		
		if(repository.existsById(productId)) {
			repository.deleteById(productId);
			return true;
		}else
			return false;
	}
}
