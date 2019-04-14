package com.dangdang.action;

import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;



import com.dangdang.entity.Category;
import com.dangdang.service.CategoryService;
import com.dangdang.service.impl.CategoryServiceImpl;

public class Init extends HttpServlet {
	@Override
	public void init() throws ServletException {
		CategoryService cs = new CategoryServiceImpl();
		//获取app对象
		ServletContext application = getServletContext();
		//放入一级标签
		List<Category> rootsList = cs.selectRoots();
		application.setAttribute("rootsList", rootsList);
		//放入二级标签
		List<Category> branchesList = cs.selectBranches();
		//System.out.println(2);
		System.out.println(branchesList);
		application.setAttribute("branchesList", branchesList);
	}
}
