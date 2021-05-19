package com.infosys.infyshop.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.infyshop.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findAll();
	List<Product> findByCategory(String category);
	List<Product> findByProductName(String productName);
	Product findByProdId(Integer prodId);
}