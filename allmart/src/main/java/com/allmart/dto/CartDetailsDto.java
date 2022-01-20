package com.allmart.dto;

import java.util.List;

public class CartDetailsDto {
	private Integer productsId;
	private Integer ProductQty;
	private Integer customerId;
	private String custAccountNumber;
	public Integer getProductsId() {
		return productsId;
	}
	public void setProductsId(Integer productsId) {
		this.productsId = productsId;
	}
	public Integer getProductQty() {
		return ProductQty;
	}
	public void setProductQty(Integer productQty) {
		ProductQty = productQty;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustAccountNumber() {
		return custAccountNumber;
	}
	public void setCustAccountNumber(String custAccountNumber) {
		this.custAccountNumber = custAccountNumber;
	}
	
	 
	
		
    

}
