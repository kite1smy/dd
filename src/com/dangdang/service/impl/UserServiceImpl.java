package com.dangdang.service.impl;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;

import com.dangdang.dao.UserDao;
import com.dangdang.entity.User;
import com.dangdang.service.UserService;
import com.dangdang.utils.MybatisUtils;

public class UserServiceImpl implements UserService {

	@Override
	public User login(String name, String password) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		UserDao ud = sqlSession.getMapper(UserDao.class);
		User user = ud.selectByName(name, password);
		System.err.println(user);
		sqlSession.commit();
		MybatisUtils.close(sqlSession);
		
		return user;
	}

	@Override
	public void register(User user) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		UserDao ud = sqlSession.getMapper(UserDao.class);
		user.setDate(new Date());
		ud.insert(user);
		sqlSession.commit();
		MybatisUtils.close(sqlSession);
	}

	@Override
	public void activation(String email) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		UserDao ud = sqlSession.getMapper(UserDao.class);
		ud.updateState(email);
		sqlSession.commit();
		MybatisUtils.close(sqlSession);
	}

}
