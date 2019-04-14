package com.dangdang.service;

import java.util.List;

import com.dangdang.entity.Books;

public interface BooksService {
	//插入图书
	void insert(Books books);
	
	//推荐
    List<Books> selectRecommend();
    //热销
    List<Books> selectHot();
    //最新上架
    List<Books> selectNew();
    //新书热卖
    List<Books> selectNewAndHot();
    
    Books select(int id);
    
    List<Books> selectByPage(int pageIndex,int pageSize,Long categoryId,int level);
}
