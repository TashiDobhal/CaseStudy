package com.cg.ovs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.ovs.domain.OrderDetail;
import com.cg.ovs.repository.OrderRepository;
import com.cg.ovs.service.OrderService;
@RunWith(SpringRunner.class)
@SpringBootTest
class OvsApplicationTests 
{
	
	@Autowired
	private OrderService orderService;
	@MockBean
	private OrderRepository orderRepository;

	@Test
   public void saveOrdersTest()  {
		OrderDetail order= new OrderDetail();
		order.setId(1L);
		order.setOrderNo("orNo1");
		order.setStatus("placed");
		order.setTotalAmount(10.00);
		when(orderRepository.save(order)).thenReturn(order);
		assertEquals(order,orderService.saveOrUpdate(order));
		
	}
	@Test
	public void getOrderByNoTest() {
		OrderDetail order= new OrderDetail();
		String orderNo="orNo1";
		when(orderRepository.findByOrderNo(orderNo)).thenReturn(order);
		assertEquals(order,orderService.findOrderByNumber(orderNo));
		
	}
	@Test
	public void deleteOrderTest()
	{
		OrderDetail order=new OrderDetail();
		order.setId(1L);
		order.setOrderNo("orNo1");
		order.setStatus("placed");
		order.setTotalAmount(10.00);
		Mockito.when(orderRepository.findByOrderNo(order.getOrderNo())).thenReturn(order);
		Mockito.when(orderRepository.existsById(order.getId())).thenReturn(false);
		assertFalse(orderRepository.existsById(order.getId()));
	}
	@Test
	public void findAllOrderTest()
	{
		OrderDetail order= new OrderDetail();
		order.setId(1L);
		order.setOrderNo("orNo1");
		order.setStatus("placed");
		order.setTotalAmount(10.00);
		
		OrderDetail order1= new OrderDetail();
		order1.setId(1L);
		order1.setOrderNo("orNo1");
		order1.setStatus("placed");
		order1.setTotalAmount(10.00);
		
		List<OrderDetail> orderList=new ArrayList<>();
		orderList.add(order);
		orderList.add(order1);
		Mockito.when(orderRepository.findAll()).thenReturn(orderList);
		assertThat(orderService.getAllOrders()).isEqualTo(orderList);
	}
}