package com.dangdang.dao;

import com.dangdang.entity.User;

public interface UserDao {
	//��½
	User selectByName(String name,String password);
	//ע��
	void insert(User user);
	//����
	void updateState(String email);
}
