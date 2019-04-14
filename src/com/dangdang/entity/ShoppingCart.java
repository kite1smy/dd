package com.dangdang.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class ShoppingCart implements Serializable{
	//购物车
	private Map<Integer,Product> productsMap=new HashMap<>();
	//回收站
	private Set<Books> recycleSet=new HashSet<>();
	
	//购物车根据bookId  删除商品
	public void delete(Books books){
		//获取bookID,购物车删除，回收站添加
		int id = books.getBookId();
		productsMap.remove(id);
		recycleSet.add(books);
	}
	//添加商品
	public void add(Books books){
		int id = books.getBookId();
		if(productsMap.containsKey(id)){
			//不是第一次购买，取出pro,pro的count+1
			Product product = productsMap.get(id);
			product.setCount(product.getCount()+1);
		}else{
			//第一次购买
			Product pro = new Product(books,1);
			productsMap.put(id, pro);
		}
	}	
	
	//变更数量
	public void quantity(int id,int count){
		//根据id获取product,更改count
		productsMap.get(id).setCount(count);
	}
	
	//节省金额
	public double saveMoney(){
		//求出标价 减去 实际价
		double sum=0;
		for(Product pro:productsMap.values()){
			sum+=pro.subSaveMoney();
		}
		return sum;
	}
	
	//总计
	public double totalMoney(){
		double sum=0;
		//循环遍历map，获取所有dangPrice的和
		for(Product pro:productsMap.values()){
			sum+=pro.subCurrentMoney();
		}
		return sum;
	}
	
	//恢复
	public void recover(Books books){
		//判断购物车中是否存在该图书
		if(!productsMap.containsKey(books.getBookId())){
			//不存在则添加
			add(books);
		}
		recycleSet.remove(books);
	}
	@Override
	public String toString() {
		return "ShoppingCart [productsMap=" + productsMap + ", recycleSet="
				+ recycleSet + "]";
	}
	public Map<Integer, Product> getProductsMap() {
		return productsMap;
	}
	
	public Set<Books> getRecycleSet() {
		return recycleSet;
	}
	
	
}
