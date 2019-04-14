package com.dangdang.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.dangdang.entity.Books;
import com.dangdang.entity.Category;
import com.dangdang.service.BooksService;
import com.dangdang.service.CategoryService;
import com.dangdang.service.impl.BooksServiceImpl;
import com.dangdang.service.impl.CategoryServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class Manager extends ActionSupport {
	private Books books;
	private BooksService bs = new BooksServiceImpl();
	private File image;
	private String imageFileName;
	private List<Category> categoryList;
	private CategoryService cs = new CategoryServiceImpl();
	
	
	
	public String add(){
		//相对路径
		String relativePath = "/upload/"+imageFileName;
		books.setProductImage(relativePath);
		//绝对路径
		String realPath = ServletActionContext.getServletContext().getRealPath(relativePath);
		try {
			FileUtils.copyFile(image, new File(realPath));
			bs.insert(books);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "add.jsp";
	}

	public Books getBooks() {
		return books;
	}

	public void setBooks(Books books) {
		this.books = books;
	}

	public BooksService getBs() {
		return bs;
	}

	public void setBs(BooksService bs) {
		this.bs = bs;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public CategoryService getCs() {
		return cs;
	}

	public void setCs(CategoryService cs) {
		this.cs = cs;
	}
}
