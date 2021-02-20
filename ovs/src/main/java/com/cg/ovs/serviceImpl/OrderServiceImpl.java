package com.cg.ovs.serviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ovs.domain.OrderDetail;
import com.cg.ovs.domain.Vegetable;
import com.cg.ovs.exception.OrderNoException;
import com.cg.ovs.repository.OrderRepository;
import com.cg.ovs.repository.VegetableRepository;
import com.cg.ovs.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private VegetableRepository vegetableRepository;

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
			
				//if(order.getId() == null) {
				Vegetable vegetable= new Vegetable();
				//order.setVegetableList(null);
				//vegetable.setOrder(order);
				//vegetable.setOrderNo(order.getOrderNo());
			//}
			//if(order.getId()!=null)
			//{
				//order.setVegetableList(vegetableRepository.findByOrderNo(order.getOrderNo()));
			//}
			
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




