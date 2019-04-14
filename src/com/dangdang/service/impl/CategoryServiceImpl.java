package com.dangdang.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dangdang.dao.CategoryMapper;
import com.dangdang.entity.Category;
import com.dangdang.service.CategoryService;
import com.dangdang.utils.MybatisUtils;

public class CategoryServiceImpl implements CategoryService {

	@Override
	public List<Category> selectRoots() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		CategoryMapper cm = sqlSession.getMapper(CategoryMapper.class);
		List<Category> rootsList = cm.selectRoots();
		sqlSession.commit();
		MybatisUtils.close(sqlSession);
		return rootsList;
	}

	@Override
	public List<Category> selectBranches() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		CategoryMapper cm = sqlSession.getMapper(CategoryMapper.class);
		List<Category> branchesList = cm.selectBranches();
		sqlSession.commit();
		MybatisUtils.close(sqlSession);
		return branchesList;
	}

	@Override
	public Category selectOne(Long id) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		CategoryMapper cm = sqlSession.getMapper(CategoryMapper.class);
		Category category = cm.selectOne(id);
		sqlSession.commit();
		MybatisUtils.close(sqlSession);
		return category;
	}

	@Override
	public Category selectTwo(Long id) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		CategoryMapper cm = sqlSession.getMapper(CategoryMapper.class);
		Category category = cm.selectTwo(id);
		sqlSession.commit();
		MybatisUtils.close(sqlSession);
		return category;
	}

}
