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
    
    //����ͼ��
    void updateInventory(Integer bookId,int num);
    
    //�Ƽ�
    List<Books> selectRecommend();
    //����
    List<Books> selectHot();
    //�����ϼ�
    List<Books> selectNew();
    //��������
    List<Books> selectNewAndHot();
    
    //��ҳ��ѯ
    List<Books> selectByPage(@Param("start")int start,@Param("end")int end,
    		@Param("categoryId")Long categoryId,@Param("level")int level);
}