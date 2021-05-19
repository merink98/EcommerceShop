package com.infosys.infyshop.product.dto;

import com.infosys.infyshop.product.entity.SubscribedProduct;

public class SubscribedProductDTO {

	Integer subId;
	Integer buyerId;
	Integer prodId;
	Integer quantity;
	
	public Integer getSubId() {
		return subId;
	}

	public void setSubId(Integer subId) {
		this.subId = subId;
	}

	public SubscribedProductDTO() {
		super();
	}

	public Integer getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	// Converts Entity into DTO
	public static SubscribedProductDTO valueOf(SubscribedProduct subscribedProduct) {
		SubscribedProductDTO subscribedProductDTO = new SubscribedProductDTO();
		subscribedProductDTO.setSubId(subscribedProduct.getSubId());
		subscribedProductDTO.setBuyerId(subscribedProduct.getBuyerId());
		subscribedProductDTO.setProdId(subscribedProduct.getProdId());
		subscribedProductDTO.setQuantity(subscribedProduct.getQuantity());
		return subscribedProductDTO;
	}
	
	//Converts DTO into Entity
	public SubscribedProduct createEntity() {
		SubscribedProduct subscribedProduct = new SubscribedProduct();
		subscribedProduct.setSubId(subscribedProduct.getSubId());
		subscribedProduct.setBuyerId(this.getBuyerId());
		subscribedProduct.setProdId(this.getProdId());
		subscribedProduct.setQuantity(this.getQuantity());
		return subscribedProduct;
	}
	
	@Override
	public String toString() {
		return "SubscribedproductDTO [subId=" + subId + ",buyerId=" + buyerId + ", prodId=" + prodId
				+ ", quantity=" + quantity + "]";
	}
	
}
