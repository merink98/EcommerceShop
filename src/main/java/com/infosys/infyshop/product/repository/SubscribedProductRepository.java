package com.infosys.infyshop.product.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.infyshop.product.entity.SubscribedProduct;

public interface SubscribedProductRepository extends JpaRepository<SubscribedProduct, Integer>{

	List<SubscribedProduct> findByBuyerId(Integer buyerId);
	Optional<SubscribedProduct> findById(Integer subId);
}
