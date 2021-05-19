package com.infosys.infyshop.product.dto;

import com.infosys.infyshop.product.entity.Product;

public class ProductDTO {

	Integer prodId;
	String brand;
	String category;
	String description;
	String image;
	double price;
	String productName;
	String rating;
	int sellerId;
	int stock;
	String subcategory;
	
	public ProductDTO() {
		super();
	}
	
	public Integer getProdId() {
		return prodId;
	}
	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	
	// Converts Entity into DTO
	public static ProductDTO valueOf(Product product) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setBrand(product.getBrand());
		productDTO.setCategory(product.getCategory());
		productDTO.setDescription(product.getDescription());
		productDTO.setImage(product.getImage());
		productDTO.setPrice(product.getPrice());
		productDTO.setProdId(product.getProdId());
		productDTO.setProductName(product.getProductName());
		productDTO.setRating(product.getRating());
		productDTO.setSellerId(product.getSellerId());
		productDTO.setStock(product.getStock());
		productDTO.setSubcategory(product.getSubcategory());
		return productDTO;
	}	
	

	//convert dto into entity
	public Product createEntity(){
		Product product = new Product();
		product.setBrand(this.getBrand());
		product.setCategory(this.getCategory());
		product.setDescription(this.getDescription());
		product.setImage(this.getImage());
		product.setPrice(this.getPrice());
		product.setProdId(this.getProdId());
		product.setProductName(this.getProductName());
		product.setRating(this.getRating());
		product.setSellerId(this.getSellerId());
		product.setStock(this.getStock());
		product.setSubcategory(this.getSubcategory());
		return product;
	}
	
	@Override
	public String toString() {
		return "ProductDTO [prodId=" + prodId + ", brand=" + brand + ", category=" + category + ", description="
				+ description + ", image=" + image + ", price=" + price + ", productName=" + productName + ", rating="
				+ rating + ", sellerId=" + sellerId + ", stock=" + stock + ", subcategory=" + subcategory + "]";
	}
	
}
