package com.allmart.dto;

public class ProductDto {

	private String productName;
	private String productCategory;
	private String ProductBrand;
	private Integer price;
	private Integer ProductQty;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductBrand() {
		return ProductBrand;
	}
	public void setProductBrand(String productBrand) {
		ProductBrand = productBrand;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getProductQty() {
		return ProductQty;
	}
	public void setProductQty(Integer productQty) {
		ProductQty = productQty;
	}
	
	

}
