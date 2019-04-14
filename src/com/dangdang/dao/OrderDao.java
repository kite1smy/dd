package com.dangdang.dao;

import java.util.List;

import com.dangdang.entity.Order;
import com.dangdang.entity.OrderItem;


public interface OrderDao {
	
	//查询所有的订单信息
	List<Order> selectAll();
	//新建订单，未付款
	void insertOrder (Order order);
	void insertItem(OrderItem item);
	
	//付款成功
	void updatePayment(int orderId);
	
	
}
