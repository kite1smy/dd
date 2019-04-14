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
		//订单mapper
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		OrderDao orderMapper = sqlSession.getMapper(OrderDao.class);
		
		//图书的mappper
		BooksMapper booksMapper = sqlSession.getMapper(BooksMapper.class);
		
		try {
			//插入订单
			orderMapper.insertOrder(order);
			int id = order.getId();
			List<OrderItem> itemList = order.getOrderItemList();
			for (OrderItem item : itemList) {
				//订单详情外键赋值
				Order oo = new Order();
				oo.setId(id);
				item.setOrder(oo);
				//查询要购买的书的数量
				Integer bookId = item.getBooks().getBookId();
				Books books = booksMapper.selectByPrimaryKey(bookId);
				//库存
				Integer inventory = books.getInventory();
				//购买数量
				int count = item.getCount();
				if (count > inventory) {
					throw new RuntimeException(books.getBookName() + "库存不足");
				}
				//插入订单详情
				orderMapper.insertItem(item);
				//删除数量
				books.setInventory(inventory - count);
				booksMapper.updateInventory(bookId, inventory-count);
				
				//提交事务
				sqlSession.commit();
			}
		} catch (Exception e) {
			//回滚
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
