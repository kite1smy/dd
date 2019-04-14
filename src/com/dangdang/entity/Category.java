package com.dangdang.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class Category implements Serializable{
    private Long categoryId;

    private Category parentCategory;

    private String categoryName;

    private BigDecimal count;

	private List<Category> childrenCategory;
	
	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Category getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public BigDecimal getCount() {
		return count;
	}

	public void setCount(BigDecimal count) {
		this.count = count;
	}

	public List<Category> getChildrenCategory() {
		return childrenCategory;
	}

	public void setChildrenCategory(List<Category> childrenCategory) {
		this.childrenCategory = childrenCategory;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", parentCategory="
				+ parentCategory + ", categoryName=" + categoryName
				+ ", count=" + count + ", childrenCategory=" + childrenCategory
				+ "]";
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(Long categoryId, Category parentCategory,
			String categoryName, BigDecimal count,
			List<Category> childrenCategory) {
		super();
		this.categoryId = categoryId;
		this.parentCategory = parentCategory;
		this.categoryName = categoryName;
		this.count = count;
		this.childrenCategory = childrenCategory;
	}
	
}