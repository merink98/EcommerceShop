package com.infosys.infyshop.product.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.infosys.infyshop.product.dto.SubscribedProductDTO;
import com.infosys.infyshop.product.entity.SubscribedProduct;
import com.infosys.infyshop.product.repository.SubscribedProductRepository;

@Service
@Transactional
public class SubscribedProductService {

	@Autowired
	SubscribedProductRepository subscribedproductRepository;
	
	public String addSubscribedProduct(@RequestBody SubscribedProductDTO subscribedProductDTO){
		SubscribedProduct sub = subscribedProductDTO.createEntity();
		subscribedproductRepository.save(sub);
		return "Product added successfully for subscriber";
	}
	
	public List<SubscribedProductDTO> getSubscribedProducts(@PathVariable Integer buyerId){
		List<SubscribedProduct> subscribedProducts = subscribedproductRepository.findByBuyerId(buyerId);
		List<SubscribedProductDTO> subscribedProductDTOs = new ArrayList<>();
		if(!subscribedProducts.isEmpty()) {
			for(SubscribedProduct subscribedProduct : subscribedProducts ) {
				SubscribedProductDTO subscribedProductDTO = SubscribedProductDTO.valueOf(subscribedProduct);
				subscribedProductDTOs.add(subscribedProductDTO);
			}
			return subscribedProductDTOs;
		}
		return subscribedProductDTOs;
	}
	
}
