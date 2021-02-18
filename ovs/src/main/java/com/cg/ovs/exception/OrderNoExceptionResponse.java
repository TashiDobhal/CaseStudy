package com.cg.ovs.exception;

public class OrderNoExceptionResponse {
	private String orderNo;


	public OrderNoExceptionResponse(String orderNo) {
		super();
		this.orderNo = orderNo;
	}
	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	
}
