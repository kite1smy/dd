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
    
    //һ������
    List<Category> selectRoots();
    //��������
    List<Category> selectBranches();
    //һ����ǩ�������ӱ�ǩ����
    Category selectOne(Long id);
    //����������ǩ
    Category selectTwo(Long id);
    
}