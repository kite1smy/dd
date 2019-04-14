package com.dangdang.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dangdang.dao.AddressDao;
import com.dangdang.entity.Address;
import com.dangdang.entity.User;
import com.dangdang.service.AddressService;
import com.dangdang.utils.MybatisUtils;

public class AddressServiceImpl implements AddressService {

	@Override
	public void insert(Address address) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		AddressDao addressDao = sqlSession.getMapper(AddressDao.class);
		address.setDeleteState(0);
		addressDao.insert(address);
		sqlSession.commit();
		MybatisUtils.close(sqlSession);
		
	}

	@Override
	public void delete(int id) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		AddressDao addressDao = sqlSession.getMapper(AddressDao.class);
		Address address = addressDao.selectOne(id);
		address.setDeleteState(1);
		address.setSelectedState(0);
		addressDao.update(address);
		sqlSession.commit();
		MybatisUtils.close(sqlSession);
		
	}

	@Override
	public void update(Address address) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		AddressDao addressDao = sqlSession.getMapper(AddressDao.class);
		addressDao.update(address);
		sqlSession.commit();
		MybatisUtils.close(sqlSession);
	}

	@Override
	public List<Address> selectAll(User user) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		AddressDao addressDao = sqlSession.getMapper(AddressDao.class);
		List<Address> list = addressDao.selectAll(user);
		sqlSession.commit();
		MybatisUtils.close(sqlSession);
		return list;
	}

	@Override
	public void updateDefault(int id) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		AddressDao addressDao = sqlSession.getMapper(AddressDao.class);
		Address address = addressDao.selectOne(id);
		if(address!=null){
			int userId = address.getUser().getId();
			addressDao.updateToZero(userId);
			address.setSelectedState(1);
			addressDao.update(address);
		}
		sqlSession.commit();
		MybatisUtils.close(sqlSession);
	}
	public static void main(String[] args) {
		AddressServiceImpl as = new AddressServiceImpl();
		as.updateDefault(24);
	}
}
