package com.dangdang.service;

import java.util.List;

import com.dangdang.entity.Books;

public interface BooksService {
	//����ͼ��
	void insert(Books books);
	
	//�Ƽ�
    List<Books> selectRecommend();
    //����
    List<Books> selectHot();
    //�����ϼ�
    List<Books> selectNew();
    //��������
    List<Books> selectNewAndHot();
    
    Books select(int id);
    
    List<Books> selectByPage(int pageIndex,int pageSize,Long categoryId,int level);
}
