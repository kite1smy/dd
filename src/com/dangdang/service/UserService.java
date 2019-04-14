package com.dangdang.service;

import com.dangdang.entity.User;

public interface UserService {
	User login(String name,String password);
	void register(User user);
	//¼¤»î
	void activation(String email);
}
