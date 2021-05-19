package com.infosys.infyshop.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.infyshop.product.dto.ProductDTO;
import com.infosys.infyshop.product.dto.SubscribedProductDTO;
import com.infosys.infyshop.product.service.ProductService;
import com.infosys.infyshop.product.service.SubscribedProductService;

@RestController
@CrossOrigin
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	SubscribedProductService subscribedProductService;
	
	@GetMapping(value="/api/products", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductDTO>> getAllProducts(){
		List<ProductDTO> productList=productService.getAllProducts();
		return new ResponseEntity<>(productList, HttpStatus.OK);
	}
	
	@GetMapping(value="/api/products/productName/{productName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductDTO>> getProductByName(@PathVariable String productName){
		List<ProductDTO> productListName=productService.getProductByName(productName);
		return new ResponseEntity<>(productListName, HttpStatus.OK);
	}
	
	@GetMapping(value="/api/products/category/{category}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductDTO>> getProductByCategory(@PathVariable String category){
		List<ProductDTO> productList=productService.getProductByCategory(category);
		return new ResponseEntity<>(productList, HttpStatus.OK);
	}
	
	@PostMapping(value="/api/products/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addProduct(@RequestBody ProductDTO newProduct){
		String message=productService.addProduct(newProduct);
		return new ResponseEntity<>(message, HttpStatus.CREATED);
	}
	
	@GetMapping(value="/api/products/remove/{prodId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> removeProductByProductId(@PathVariable Integer prodId){
		String message=productService.removeProduct(prodId);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
	@PostMapping(value="/api/products/updatestock", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateStock(@RequestBody ProductDTO changeProduct){
		String message=productService.updateStock(changeProduct);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
	@GetMapping(value="/api/subscriptions/buyerId/{buyerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SubscribedProductDTO>> getSubscribedProducts(@PathVariable Integer buyerId){
		List<SubscribedProductDTO> subscribedProducts=subscribedProductService.getSubscribedProducts(buyerId);
		return new ResponseEntity<>(subscribedProducts, HttpStatus.OK);
	}
	
	@PostMapping(value="/api/subscriptions/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addSubscribedProduct(@RequestBody SubscribedProductDTO subProduct){
		String message=subscribedProductService.addSubscribedProduct(subProduct);
		return new ResponseEntity<>(message, HttpStatus.CREATED);
	}
	
}
