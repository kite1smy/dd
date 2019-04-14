package com.dangdang.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dangdang.dao.BooksMapper;
import com.dangdang.entity.Books;
import com.dangdang.service.BooksService;
import com.dangdang.utils.MybatisUtils;

public class BooksServiceImpl implements BooksService{

	@Override
	public void insert(Books books) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		BooksMapper bm = sqlSession.getMapper(BooksMapper.class);
		try {
			bm.insert(books);
			sqlSession.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			MybatisUtils.close(sqlSession);
		}
	}

	@Override
	public List<Books> selectRecommend() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		BooksMapper bm = sqlSession.getMapper(BooksMapper.class);
		List<Books> list = bm.selectRecommend();
		sqlSession.commit();
		MybatisUtils.close(sqlSession);
		return list;
	}

	@Override
	public List<Books> selectHot() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		BooksMapper bm = sqlSession.getMapper(BooksMapper.class);
		List<Books> list = bm.selectHot();
		sqlSession.commit();
		MybatisUtils.close(sqlSession);
		return list;
	}

	@Override
	public List<Books> selectNew() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		BooksMapper bm = sqlSession.getMapper(BooksMapper.class);
		List<Books> list = bm.selectNew();
		sqlSession.commit();
		MybatisUtils.close(sqlSession);
		return list;
	}

	@Override
	public List<Books> selectNewAndHot() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		BooksMapper bm = sqlSession.getMapper(BooksMapper.class);
		List<Books> list = bm.selectNewAndHot();
		sqlSession.commit();
		MybatisUtils.close(sqlSession);
		return list;
	}

	@Override
	public Books select(int id) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		BooksMapper bm = sqlSession.getMapper(BooksMapper.class);
		Books book = bm.selectByPrimaryKey(id);
		sqlSession.commit();
		MybatisUtils.close(sqlSession);
		return book;
	}

	@Override
	public List<Books> selectByPage(int pageIndex, int pageSize,
			Long categoryId, int level) {
		int start = (pageIndex-1)*pageSize+1;
		int end = pageIndex*pageSize;
		
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		BooksMapper bm = sqlSession.getMapper(BooksMapper.class);
		
		List<Books> list = bm.selectByPage(start, end, categoryId, level);
		sqlSession.commit();
		MybatisUtils.close(sqlSession);
		return list;
	}

}
