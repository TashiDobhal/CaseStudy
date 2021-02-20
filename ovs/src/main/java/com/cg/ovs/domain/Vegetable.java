package com.cg.ovs.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Vegetable {
	/**
	 *This is the vegetable Id.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long vegId;
	/**
	 *This is the vegetable Name.
	 */
	private String name;
	/**
	 *This is the type of the vegetable i.e, leafy green, root etc.
	 */
	private String type;
	/**
	 *This is the price of the vegetable.
	 */
	private double price;
	/**
	 *This is the quantity in which the vegetable is bought.
	 */
	private int quantity;  
	/**
	 *Many to one Mapping with OrderDetail.
	*/
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="orderDetail_id", nullable=false)
	@JsonIgnore
	
	/**
	 *Creating object of OrderDetail.
	*/
    private OrderDetail order;
	
	/**
	 *Constructor.
	*/
	public Vegetable() {
		
	}
	public Long getVegId() {
		return vegId;
	}
	public void setVegId(Long vegId) {
		this.vegId = vegId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public OrderDetail getOrder() {
		return order;
	}
	public void setOrder(OrderDetail order) {
		this.order = order;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
