package com.dangdang.service;

import java.util.List;

import com.dangdang.entity.Order;


public interface OrderService {
	//���ɶ���
	void insert(Order order);
	//��ѯ����
	List<Order> selectAll();
	//��������
	void update(int orderId);
}
