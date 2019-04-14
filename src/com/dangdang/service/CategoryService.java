package com.dangdang.service;

import java.util.List;

import com.dangdang.entity.Category;

public interface CategoryService {
	 //一级标题
    List<Category> selectRoots();
    //二级标题
    List<Category> selectBranches();
    
    Category selectOne(Long id);
    Category selectTwo(Long id);
}
