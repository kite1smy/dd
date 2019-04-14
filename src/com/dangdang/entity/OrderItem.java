package com.dangdang.entity;

import java.io.Serializable;

public class OrderItem implements Serializable{
	private int id;
	private Books books;
	private Order order;
	private int count;
	private double amount;
	private double saveMoney;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Books getBooks() {
		return books;
	}
	public void setBooks(Books books) {
		this.books = books;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getSaveMoney() {
		return saveMoney;
	}
	public void setSaveMoney(double saveMoney) {
		this.saveMoney = saveMoney;
	}
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", books=" + books + ", order=" + order
				+ ", count=" + count + ", amount=" + amount + ", saveMoney="
				+ saveMoney + "]";
	}
	public OrderItem(int id, Books books, Order order, int count,
			double amount, double saveMoney) {
		super();
		this.id = id;
		this.books = books;
		this.order = order;
		this.count = count;
		this.amount = amount;
		this.saveMoney = saveMoney;
	}
	
}
