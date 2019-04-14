package com.dangdang.dao;

import java.util.List;

import com.dangdang.entity.Order;
import com.dangdang.entity.OrderItem;


public interface OrderDao {
	
	//��ѯ���еĶ�����Ϣ
	List<Order> selectAll();
	//�½�������δ����
	void insertOrder (Order order);
	void insertItem(OrderItem item);
	
	//����ɹ�
	void updatePayment(int orderId);
	
	
}
