package com.cg.ovs.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class OrderDetail {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private double totalAmount;
	@Size(min=4,max=5, message="Size must be 4 to 5 character")
	@Column(unique=true, updatable=false)
	private String orderNo;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date orderDate;
	@NotBlank(message= "Status Required")
	private String status;
	//private List<Vegetable> vegetableList =  new ArrayList<>();
	//List<Vegetable> vegetableList;
	//private int customerId;
	
public OrderDetail() {
		
		super();
	}
	//public List<Vegetable> getVegetableList() {
	//return vegetableList;
//}
//public void setVegetableList(List<Vegetable> vegetableList) {
	//this.vegetableList = vegetableList;
//}
	public OrderDetail(int id, double totalAmount, Date orderDate, String status ,String orderNo) {
		super();
		this.id = id;
	    this.totalAmount = totalAmount;
		this.orderDate = orderDate;
		this.status = status;
		this.orderNo=orderNo;
	}
	public int getId() {
		return id;
	}     
	public void setId(int id) {
		this.id = id;
	}
	
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
}
