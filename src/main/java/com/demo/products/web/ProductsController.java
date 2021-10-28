package com.demo.products.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.products.model.Products;
import com.demo.products.service.ProductsService;

@RestController
public class ProductsController {

	@Autowired
	public ProductsService productsService;

	@GetMapping(path = "products")
	public List<Products> getProducts() {
		return productsService.getAllProducts();
	}

	@PostMapping(path = "products")
	public ResponseEntity<?> createProduct(@RequestBody Products product) {
		return productsService.saveProduct(product);
	}

	@PutMapping(path = "products")
	public ResponseEntity<?> updateProduct(@RequestBody Products product) {
		return productsService.saveProduct(product);
	}

	@DeleteMapping(path = "products")
	public ResponseEntity<?> deleteProduct(@RequestBody Products product) {
		return productsService.deleteProduct(product);
	}

}
