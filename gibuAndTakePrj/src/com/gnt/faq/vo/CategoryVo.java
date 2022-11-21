package com.gnt.faq.vo;

public class CategoryVo {

	public CategoryVo() {
		
	}
	
	
	
	public CategoryVo(String categoryNo, String categoryName) {
		super();
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
	}

	private String categoryNo;
	private String categoryName;
	
	public String getCategoryNo() {
		return categoryNo;
	}



	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}



	public String getCategoryName() {
		return categoryName;
	}



	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}



	@Override
	public String toString() {
		return "CategoryVo [categoryNo=" + categoryNo + ", categoryName=" + categoryName + "]";
	}
	
	
}
