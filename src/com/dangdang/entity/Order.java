package com.dangdang.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Order implements Serializable{
	private int id;
	private double goodPrice;
	private Date orderTime;
	private int orderState;
	private User user;
	private Address address;
	
	private List<OrderItem> orderItemList;

	public Order(int id, double goodPrice, Date orderTime, int orderState,
			User user, Address address, List<OrderItem> orderItemList) {
		super();
		this.id = id;
		this.goodPrice = goodPrice;
		this.orderTime = orderTime;
		this.orderState = orderState;
		this.user = user;
		this.address = address;
		this.orderItemList = orderItemList;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", goodPrice=" + goodPrice + ", orderTime="
				+ orderTime + ", orderState=" + orderState + ", user=" + user
				+ ", address=" + address + ", orderItemList=" + orderItemList
				+ "]";
	}

	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}

	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getGoodPrice() {
		return goodPrice;
	}

	public void setGoodPrice(double goodPrice) {
		this.goodPrice = goodPrice;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public int getOrderState() {
		return orderState;
	}

	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
}
