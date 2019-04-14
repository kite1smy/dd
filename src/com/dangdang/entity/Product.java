package com.dangdang.entity;

import java.io.Serializable;

public class Product implements Serializable{
	//…Ã∆∑±Ì
	private Books books;
	private int count;
	
	
	public Product(Books books, int count) {
		super();
		this.books = books;
		this.count = count;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public double subSaveMoney(){
		return books.getBookPrice().doubleValue()*count-subCurrentMoney();
	}
	
	public double subCurrentMoney(){
		return books.getDangPrice().doubleValue()*count;
	}
	
	@Override
	public String toString() {
		return "Product [books=" + books + ", count=" + count + "]";
	}
	public Books getBooks() {
		return books;
	}
	public void setBooks(Books books) {
		this.books = books;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
