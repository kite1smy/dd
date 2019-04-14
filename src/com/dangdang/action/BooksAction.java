package com.dangdang.action;

import java.math.BigDecimal;
import java.util.List;

import com.dangdang.entity.Books;
import com.dangdang.entity.Category;
import com.dangdang.service.BooksService;
import com.dangdang.service.CategoryService;
import com.dangdang.service.impl.BooksServiceImpl;
import com.dangdang.service.impl.CategoryServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class BooksAction extends ActionSupport {
	private List<Books> booksList;
	private List<Category> categoryList;
	private BooksService bs = new BooksServiceImpl();
	private CategoryService cs = new CategoryServiceImpl();
	private Books books;
	private Category category;
	private int pageIndex=1;
	private int pageSize=3;
	//��ǩ�ּ�
	private int level;
	private BigDecimal pageTotal;
	private String branchName;
	private Long branchId;
	
	//��ҳ
	public String selectByPage(){
		if(category.getCategoryId()==null){
			level=1;
			booksList=bs.selectByPage(pageIndex, pageSize, category.getParentCategory().getCategoryId(), level);
			System.err.println(booksList + "| 1");
			category=cs.selectOne(category.getParentCategory().getCategoryId());
			pageTotal = category.getCount().divide(new BigDecimal(pageSize), 0,BigDecimal.ROUND_UP);
		}else{
			level=2;
			booksList=bs.selectByPage(pageIndex, pageSize, category.getCategoryId(), level);
			
			branchId=category.getCategoryId();
			branchName=cs.selectTwo(branchId).getCategoryName();
			category=cs.selectOne(category.getParentCategory().getCategoryId());
			if(booksList.size()==0){
				pageTotal=new BigDecimal(0);
			}else{
				pageTotal=booksList.get(0).getCategory().getCount().divide(new BigDecimal(pageSize), 0,BigDecimal.ROUND_UP);
			}
		}
		if(pageTotal.equals(new BigDecimal(0))) pageIndex=0;
		return "toBookList.jsp";
	}
	
	//ͼ������
	public String select(){
		books=bs.select(books.getBookId());
		return "toProduct.jsp";
	}
	//����ǩչʾ
	public String showCategory(){
		categoryList=cs.selectRoots();
		return "toCategory.jsp";
	}
	//�༭�Ƽ�
	public String showRecommend(){
		booksList=bs.selectRecommend();
		return "toRecommend.jsp";
	}
	//����
	public String showHot(){
		booksList=bs.selectHot();
		return "toHot.jsp";
	}
	//����
	public String showNew(){
		booksList=bs.selectNew();
		return "toNew.jsp";
	}
	//��������
	public String showNewAndHot(){
		booksList=bs.selectNewAndHot();
		return "toHotBoard.jsp";
	}
	
	public List<Books> getBooksList() {
		return booksList;
	}

	public void setBooksList(List<Books> booksList) {
		this.booksList = booksList;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public BooksService getBs() {
		return bs;
	}

	public void setBs(BooksService bs) {
		this.bs = bs;
	}

	public CategoryService getCs() {
		return cs;
	}

	public void setCs(CategoryService cs) {
		this.cs = cs;
	}
	public Books getBooks() {
		return books;
	}
	public void setBooks(Books books) {
		this.books = books;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public BigDecimal getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(BigDecimal pageTotal) {
		this.pageTotal = pageTotal;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	
}
