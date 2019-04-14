package com.dangdang.dao;

import java.util.List;

import com.dangdang.entity.Address;
import com.dangdang.entity.User;

public interface AddressDao {
	void insert(Address address);
	//void delete(int id);
	void update(Address address);
	List<Address> selectAll(User user);
	Address selectOne(int id);
	//Ä¬ÈÏµØÖ·ÖÃÁã
	void updateToZero(int uid);
}
