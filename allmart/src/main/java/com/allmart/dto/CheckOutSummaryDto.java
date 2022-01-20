package com.allmart.dto;

public class CheckOutSummaryDto {
	
	private Integer OrderId;
	private String OrderStatus;
	private String OrderMessage;
	public Integer getOrderId() {
		return OrderId;
	}
	public void setOrderId(Integer orderId) {
		OrderId = orderId;
	}
	public String getOrderStatus() {
		return OrderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		OrderStatus = orderStatus;
	}
	public String getOrderMessage() {
		return OrderMessage;
	}
	public void setOrderMessage(String orderMessage) {
		OrderMessage = orderMessage;
	}
	

}
