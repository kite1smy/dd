package com.dangdang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dangdang.entity.Books;

public interface BooksMapper {
    int deleteByPrimaryKey(Integer bookId);

    int insert(Books record);

    int insertSelective(Books record);

    Books selectByPrimaryKey(Integer bookId);

    int updateByPrimaryKeySelective(Books record);
    
    //购买图书
    void updateInventory(Integer bookId,int num);
    
    //推荐
    List<Books> selectRecommend();
    //热销
    List<Books> selectHot();
    //最新上架
    List<Books> selectNew();
    //新书热卖
    List<Books> selectNewAndHot();
    
    //分页查询
    List<Books> selectByPage(@Param("start")int start,@Param("end")int end,
    		@Param("categoryId")Long categoryId,@Param("level")int level);
}