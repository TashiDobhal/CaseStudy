package com.cg.ovs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ovs.domain.OrderDetail;
import com.cg.ovs.exception.OrderNoException;
import com.cg.ovs.exception.OrderNotFoundException;
import com.cg.ovs.repository.OrderRepository;
@Service
public class OrderService {
@Autowired
private OrderRepository orderRepository;

public Iterable<OrderDetail> getAllOrders() {
	return orderRepository.findAll();
}

public OrderDetail findOrderByNumber(String orderNo) {
	OrderDetail order = orderRepository.findByOrderNo(orderNo);
	if (order == null) {
		throw new OrderNoException("Order No: " +orderNo + " does not exist.");
	}
	return order;
}
public OrderDetail saveOrUpdate(OrderDetail order) {
	try {
		order.setOrderNo(order.getOrderNo());
return	orderRepository.save(order);
}catch(Exception e) {
	throw new OrderNoException("Order No: "+order.getOrderNo() + " already exists");
}
}
public void deleteOrderByNumber(String orderNo){
OrderDetail order = orderRepository.findByOrderNo(orderNo);
   if(order==null) {
	   throw new OrderNoException("Order No: "+orderNo+" does not exist.");
   }
   orderRepository.delete(order);
}

}


