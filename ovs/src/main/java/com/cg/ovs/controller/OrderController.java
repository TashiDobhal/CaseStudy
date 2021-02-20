package com.cg.ovs.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ovs.domain.OrderDetail;
import com.cg.ovs.service.MapValidationErrorService;
import com.cg.ovs.service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderController
{
@Autowired
private OrderService orderService;
@Autowired
private MapValidationErrorService mapValidationErrorService;

@GetMapping("/all")
public Iterable<OrderDetail>getAllOrders(){
	return orderService.getAllOrders();
}

@GetMapping("/{orderNo}")
public ResponseEntity<?>getOrder(@PathVariable String orderNo) {
	OrderDetail order = orderService.findOrderByNumber(orderNo);
	return new ResponseEntity<OrderDetail>(order, HttpStatus.OK);
}

@PostMapping("")
public ResponseEntity<?> saveOrUpdate(@Valid @RequestBody OrderDetail order, BindingResult result) {
	ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
	if (errorMap != null)
		return errorMap;
	OrderDetail or = orderService.saveOrUpdate(order);
	return new ResponseEntity<OrderDetail>(or, HttpStatus.OK);
}
@DeleteMapping("/{orderNo}")
public ResponseEntity<?> deleteOrder(@PathVariable String orderNo) {
	 orderService.deleteOrderByNumber(orderNo);
	 return new ResponseEntity<String>("Order with id : "+orderNo+" deleted successfully.",HttpStatus.OK);
}

}

