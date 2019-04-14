package com.dangdang.service;

import java.util.List;

import com.dangdang.entity.Address;
import com.dangdang.entity.User;


public interface AddressService {
	//增删改查
	void insert(Address address);
	void delete(int id);
	void update(Address address);
	List<Address> selectAll(User user);
	//设为默认
	void updateDefault(int id);
} 
