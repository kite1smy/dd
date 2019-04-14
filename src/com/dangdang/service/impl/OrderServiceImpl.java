package com.dangdang.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dangdang.dao.BooksMapper;
import com.dangdang.dao.OrderDao;
import com.dangdang.entity.Books;
import com.dangdang.entity.Order;
import com.dangdang.entity.OrderItem;
import com.dangdang.service.OrderService;
import com.dangdang.utils.MybatisUtils;

public class OrderServiceImpl implements OrderService{

	@Override
	public void insert(Order order) {
		//����mapper
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		OrderDao orderMapper = sqlSession.getMapper(OrderDao.class);
		
		//ͼ���mappper
		BooksMapper booksMapper = sqlSession.getMapper(BooksMapper.class);
		
		try {
			//���붩��
			orderMapper.insertOrder(order);
			int id = order.getId();
			List<OrderItem> itemList = order.getOrderItemList();
			for (OrderItem item : itemList) {
				//�������������ֵ
				Order oo = new Order();
				oo.setId(id);
				item.setOrder(oo);
				//��ѯҪ������������
				Integer bookId = item.getBooks().getBookId();
				Books books = booksMapper.selectByPrimaryKey(bookId);
				//���
				Integer inventory = books.getInventory();
				//��������
				int count = item.getCount();
				if (count > inventory) {
					throw new RuntimeException(books.getBookName() + "��治��");
				}
				//���붩������
				orderMapper.insertItem(item);
				//ɾ������
				books.setInventory(inventory - count);
				booksMapper.updateInventory(bookId, inventory-count);
				
				//�ύ����
				sqlSession.commit();
			}
		} catch (Exception e) {
			//�ع�
			sqlSession.rollback();
			throw e;
		}finally{
			MybatisUtils.close(sqlSession);
		}
	}

	@Override
	public List<Order> selectAll() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		OrderDao orderMapper = sqlSession.getMapper(OrderDao.class);
		List<Order> list = orderMapper.selectAll();
		sqlSession.commit();
		MybatisUtils.close(sqlSession);
		return list;
	}

	@Override
	public void update(int orderId) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		OrderDao orderMapper = sqlSession.getMapper(OrderDao.class);
		orderMapper.updatePayment(orderId);
		sqlSession.commit();
		MybatisUtils.close(sqlSession);
	}

}
