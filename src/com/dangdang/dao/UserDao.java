package com.dangdang.dao;

import com.dangdang.entity.User;

public interface UserDao {
	//µÇÂ½
	User selectByName(String name,String password);
	//×¢²á
	void insert(User user);
	//¼¤»î
	void updateState(String email);
}
