package com.dangdang.service;

import com.dangdang.entity.User;

public interface UserService {
	User login(String name,String password);
	void register(User user);
	//����
	void activation(String email);
}
