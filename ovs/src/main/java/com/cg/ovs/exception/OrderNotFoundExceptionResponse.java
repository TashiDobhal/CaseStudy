package com.cg.ovs.exception;

public class OrderNotFoundExceptionResponse {
	private String orderNo;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public OrderNotFoundExceptionResponse(String orderNo) {
		super();
		this.orderNo = orderNo;
	}
	
}
