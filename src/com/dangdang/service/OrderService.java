package com.dangdang.service;

import java.util.List;

import com.dangdang.entity.Order;


public interface OrderService {
	//生成订单
	void insert(Order order);
	//查询订单
	List<Order> selectAll();
	//订单付款
	void update(int orderId);
}
