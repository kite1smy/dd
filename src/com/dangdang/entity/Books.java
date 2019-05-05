package com.dangdang.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Books implements Serializable{
	private final String base = "http://localhost:8989/productImages/";
	
	
	private Integer bookId;

	private Category category;

	private String bookName;

	private BigDecimal bookPrice;

	private BigDecimal dangPrice;

	private String bookState;
	
	private String press;
	
	private String messages;

	private Integer inventory;

	private String author;

	private BigDecimal customeScore;

	private String productImage;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Books other = (Books) obj;
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		return true;
	}

	private BigDecimal salenum;

	public Integer getBookId() {
		return bookId;
	}
	
	

	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public BigDecimal getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(BigDecimal bookPrice) {
		this.bookPrice = bookPrice;
	}

	public BigDecimal getDangPrice() {
		return dangPrice;
	}

	public void setDangPrice(BigDecimal dangPrice) {
		this.dangPrice = dangPrice;
	}

	public String getBookState() {
		return bookState;
	}

	public void setBookState(String bookState) {
		this.bookState = bookState;
	}

	public Integer getInventory() {
		return inventory;
	}

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public BigDecimal getCustomeScore() {
		return customeScore;
	}

	public void setCustomeScore(BigDecimal customeScore) {
		this.customeScore = customeScore;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = base+productImage;
	}

	public BigDecimal getSalenum() {
		return salenum;
	}

	public void setSalenum(BigDecimal salenum) {
		this.salenum = salenum;
	}

	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}

	public Books(Integer bookId, Category category, String bookName,
			BigDecimal bookPrice, BigDecimal dangPrice, String bookState,
			Integer inventory, String author, BigDecimal customeScore,
			String productImage, BigDecimal salenum) {
		super();
		this.bookId = bookId;
		this.category = category;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.dangPrice = dangPrice;
		this.bookState = bookState;
		this.inventory = inventory;
		this.author = author;
		this.customeScore = customeScore;
		this.productImage = productImage;
		this.salenum = salenum;
	}

	@Override
	public String toString() {
		return "Books [bookId=" + bookId + ", category=" + category
				+ ", bookName=" + bookName + ", bookPrice=" + bookPrice
				+ ", dangPrice=" + dangPrice + ", bookState=" + bookState
				+ ", inventory=" + inventory + ", author=" + author
				+ ", customeScore=" + customeScore + ", productImage="
				+ productImage + ", salenum=" + salenum +", press=" + press +", messages=" + messages + "]";
	}

}