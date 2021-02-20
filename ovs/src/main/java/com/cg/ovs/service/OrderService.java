package com.cg.ovs.service;

import org.springframework.stereotype.Service;

import com.cg.ovs.domain.OrderDetail;

@Service
public interface OrderService
{
	
	    public Iterable<OrderDetail> getAllOrders(); 
		public OrderDetail findOrderByNumber(String orderNo); 
		public OrderDetail saveOrUpdate(OrderDetail order) ;
		public void deleteOrderByNumber(String orderNo);

}


	  

	 