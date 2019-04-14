package com.dangdang.dao.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.dangdang.dao.BooksMapper;
import com.dangdang.dao.UserDao;
import com.dangdang.entity.Books;
import com.dangdang.utils.MybatisUtils;

public class TestDao {
	@Test
	public void TestBooks(){
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		BooksMapper mapper = sqlSession.getMapper(BooksMapper.class);
		
		Books selectByPrimaryKey = mapper.selectByPrimaryKey(1);
		sqlSession.commit();
		Books selectByPrimaryKey2 = mapper.selectByPrimaryKey(1);
		
		MybatisUtils.close(sqlSession);
	}
}
