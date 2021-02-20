package com.cg.ovs.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * This Order class will be working as a data traveller object from layer to layer
 * 
 * @author Tashi
 *
 */
@Entity
public class OrderDetail
{
    /**
	 *This is the order Id.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	/**
	 * This is the order Amount.
	 */
	private double totalAmount;
	/**
	 * This is the order Number, which will be unique.
	 */
	@Size(min=4,max=5, message="Size must be 4 to 5 character")
	@Column(unique=true, updatable=false)
	private String orderNo;
	/**
	 * This is the date in which the order is placed.
	 */
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date orderDate;
	/**
	 * This is the order status, placed or pending.
	 */
	@NotBlank(message= "Status Required")
	private String status;
	/**
	 * This is the user Id.
	 */
	private int userId;
	
	/**
	 *One to Many Mapping with Vegetable.
	*/
	@OneToMany(mappedBy = "order",fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Vegetable> vegetableList;
	
	/**
	 *Constructor.
	*/
	public OrderDetail()
	 {
	    super();
	 }
    /**
	 * Parameterized Constructor.
	*/
    public OrderDetail(Long id, double totalAmount, Date orderDate, String status ,String orderNo) 
    {
	      super();
		  this.id = id;
		  this.totalAmount = totalAmount;
		  this.orderDate = orderDate;
		  this.status = status;
		  this.orderNo=orderNo;
	}
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public List<Vegetable> getVegetableList() {
		return vegetableList;
	}
	public void setVegetableList(List<Vegetable> vegetableList) {
		this.vegetableList = vegetableList;
	}
    public Long getId() {
		return id;
	}     
	public void setId(Long id) {
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
