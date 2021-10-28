package com.demo.products.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.products.model.Products;
import com.demo.products.repository.ProductsRepository;

@Service
public class ProductsService {

	@Autowired
	public ProductsRepository productsRepository;

	public ResponseEntity<?> saveProduct(Products item) {
		productsRepository.save(item);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	public ResponseEntity<?> deleteProduct(Products item) {
		productsRepository.delete(item);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	public List<Products> getAllProducts() {
		return productsRepository.findAll();
	}

}
