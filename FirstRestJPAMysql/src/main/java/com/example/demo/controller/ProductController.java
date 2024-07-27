package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.services.ProductService;

@RestController
@RequestMapping("/product/api.1.0")

public class ProductController {
	

	
	@Autowired
	ProductService service;
	
	@PostMapping
	@RequestMapping(path="create",
	consumes=MediaType.APPLICATION_JSON_VALUE,
	produces=MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<Product> createProduct(@RequestBody Product productReq){
		
		Product newProduct = service.save(productReq);
		return new ResponseEntity<Product>(newProduct,HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/fetch/{productId}")
	public ResponseEntity<Product> fetch(@PathVariable Long productId){
		
		
		return ResponseEntity.ok(service.fetch(productId));
		
		
	}
	
	@DeleteMapping("/delete/{productId}")
	public ResponseEntity<Boolean> delete(@PathVariable Long productId){
		
		
		return ResponseEntity.ok(service.delete(productId));
		
		
	}
	
	//@GetMapping
	@GetMapping("/fetchall")
	
	public ResponseEntity<List<Product>> fetchAll(){
		
		
		return ResponseEntity.ok(service.fetchAll());
		
		
	}
	

}
