package com.dangdang.service;

import java.util.List;

import com.dangdang.entity.Address;
import com.dangdang.entity.User;


public interface AddressService {
	//��ɾ�Ĳ�
	void insert(Address address);
	void delete(int id);
	void update(Address address);
	List<Address> selectAll(User user);
	//��ΪĬ��
	void updateDefault(int id);
} 
