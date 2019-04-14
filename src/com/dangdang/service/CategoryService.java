package com.dangdang.service;

import java.util.List;

import com.dangdang.entity.Category;

public interface CategoryService {
	 //һ������
    List<Category> selectRoots();
    //��������
    List<Category> selectBranches();
    
    Category selectOne(Long id);
    Category selectTwo(Long id);
}
