package com.dangdang.action;

import java.util.Map;

import com.dangdang.entity.Books;
import com.dangdang.entity.ShoppingCart;
import com.dangdang.service.BooksService;
import com.dangdang.service.impl.BooksServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShoppingCartAction extends ActionSupport{
	private Books books;
	private BooksService bs = new BooksServiceImpl();
	private ShoppingCart cart;
	private int count;
	private Map<String, Object> session = ActionContext.getContext().getSession();
	
	{
		if(session.containsKey("cart")){
			cart=(ShoppingCart) session.get("cart");
		}else{
			cart=new ShoppingCart();
			session.put("cart", cart);
		}
	}
	
	//
	public String show(){
		if(session.get("user")!=null){
			return "cartList.jsp";
		}
		return "login.jsp";
	}
	
	//买书
	public String add(){
		books=bs.select(books.getBookId());
		cart.add(books);
		return "show";
	}
	
	//删除
	public String remove(){
		books=bs.select(books.getBookId());
		cart.delete(books);
		return "show";
	}
	
	//变更数量
	public String changeQuantity(){
		cart.quantity(books.getBookId(), count);
		return "show";
	}
	
	//恢复
	public String recover(){
		books=bs.select(books.getBookId());
		cart.recover(books);
		return "show";
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

	public ShoppingCart getCart() {
		return cart;
	}

	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
