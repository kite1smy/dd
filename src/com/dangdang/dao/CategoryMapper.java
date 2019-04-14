package com.dangdang.dao;

import java.util.List;

import com.dangdang.entity.Category;

public interface CategoryMapper {
    int deleteByPrimaryKey(Long categoryId);

    int insert(Category record);

    int insertSelective(Category record);
  
    Category selectByPrimaryKey(Long categoryId);
   
    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
    
    //一级标题
    List<Category> selectRoots();
    //二级标题
    List<Category> selectBranches();
    //一级标签及二级子标签集合
    Category selectOne(Long id);
    //单个二级标签
    Category selectTwo(Long id);
    
}