package com.s3s.finalProject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name= "orderId", nullable= false, updatable= false)
	private Long orderId;
	
	private String orderItem;
	
	private int quantity;
	
	private double pricePerUnit;
	
	
	@ManyToOne
	@JoinColumn(name= "user_id")
	private Users user;



	public Orders(String orderItem, int quantity, double pricePerUnit) {
		super();
		this.orderItem = orderItem;
		this.quantity = quantity;
		this.pricePerUnit = pricePerUnit;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(String orderItem) {
		this.orderItem = orderItem;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderItem=" + orderItem + ", quantity=" + quantity + ", pricePerUnit="
				+ pricePerUnit + ", user=" + user + "]";
	}

	
	
	

}
