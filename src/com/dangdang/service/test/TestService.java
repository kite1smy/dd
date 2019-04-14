package com.dangdang.service.test;

import java.util.List;

import org.junit.Test;

import com.dangdang.entity.Address;
import com.dangdang.entity.Books;
import com.dangdang.entity.Category;
import com.dangdang.entity.User;
import com.dangdang.service.AddressService;
import com.dangdang.service.BooksService;
import com.dangdang.service.CategoryService;
import com.dangdang.service.impl.AddressServiceImpl;
import com.dangdang.service.impl.BooksServiceImpl;
import com.dangdang.service.impl.CategoryServiceImpl;

public class TestService {
	BooksService bs = new BooksServiceImpl();
	CategoryService cs = new CategoryServiceImpl();
	AddressService as = new AddressServiceImpl();
	@Test
	public void testCa(){
		List<Category> selectRoots = cs.selectRoots();
		for(Category s:selectRoots){
			System.out.println(s.getCategoryName()+"\t");
			for(Category d:s.getChildrenCategory()){
				System.out.println("\t"+d.getCategoryName());
			}
		}
	}
	
	@Test
	public void TestBooks(){
		List<Books> list = bs.selectByPage(1, 5, new Long(1), 2);
		for(Books b:list){
			System.out.println(b);
		}
	}
	@Test
	public void TestSelectOne(){
		Category one = cs.selectOne(new Long(1));
		System.out.println(one);
	}
	@Test
	public void Tests(){
		User user = new User();
		user.setId(1);
		List<Address> selectAll = as.selectAll(user);
		Address address = new Address();
//		as.update(address);
		System.out.println(selectAll);
	}
}
