package com.infosys.infyshop.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.infosys.infyshop.product.dto.ProductDTO;
import com.infosys.infyshop.product.entity.Product;
import com.infosys.infyshop.product.repository.ProductRepository;
import com.infosys.infyshop.product.repository.SubscribedProductRepository;

@Service
@Transactional
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	SubscribedProductRepository subscribedProductRepository;
	
	//Fetch all products list
	public List<ProductDTO> getAllProducts() {
		List<Product>products = productRepository.findAll();
		List<ProductDTO> productDTOs = new ArrayList<>();
			
		for(Product product:products) {
			ProductDTO productDTO = ProductDTO.valueOf(product);
			productDTOs.add(productDTO);
		}
		return productDTOs;
	}	
	
	//fetch product list by category
	public List<ProductDTO> getProductByCategory(@PathVariable String category) {
		
		List<Product> products = productRepository.findByCategory(category);
		List<ProductDTO> productDTOs = new ArrayList<>();
		
		for(Product product:products) {
			productDTOs.add(ProductDTO.valueOf(product));
		}	
		return productDTOs;
	}
	
	//fetch product list by name
	public List<ProductDTO> getProductByName(@PathVariable String productName) {

		List<Product> products = productRepository.findByProductName(productName);
		List<ProductDTO> productDTOs = new ArrayList<>();
			
		for(Product product:products) {
			productDTOs.add(ProductDTO.valueOf(product));
		}
		return productDTOs;
	}
	
	//add a product
	public String addProduct(@RequestBody ProductDTO productDTO) {
			List<Product> product = productRepository.findByProductName(productDTO.getProductName());
			if(product.isEmpty()) {
				Product products = productDTO.createEntity();
				productRepository.save(products);
				return "Product added successfully";
			}
			return "Product already exists";
	}
	
	//remove a product
	public String removeProduct(Integer productid)
	{
		Optional<Product> product = productRepository.findById(productid);
		if(product.isPresent()) {
			Product product1 = product.get();
			productRepository.delete(product1);
			return "Product removed succefully";
		}else {
			return "Product doesn't exist";
		}
	}

	//update stock
	public String updateStock(ProductDTO productDTO){
		
		Product product = productRepository.findByProdId(productDTO.getProdId());
		if(product!=null)
		{
			//Product product1 = productDTO.createEntity();
			product.setStock(productDTO.getStock());
			productRepository.save(product);
			return "Product stock updated succefully";
		}
		return "Product not found!!";
	}
	
}
