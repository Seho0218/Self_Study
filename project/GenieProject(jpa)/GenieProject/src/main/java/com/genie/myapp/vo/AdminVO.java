package com.genie.myapp.vo;

public class AdminVO {
	private String category_id;
	private String product_category;
	private String product_tag_id;
	private String product_tag;
	

	@Override
	public String toString() {
		return "AdminVO [category_id=" + category_id + ", product_category=" + product_category + ", product_tag_id="
				+ product_tag_id + ", product_tag=" + product_tag + "]";
	}
	public String getproduct_category() {
		return product_category;
	}
	public void setproduct_category(String product_category) {
		this.product_category = product_category;
	}
	public String getcategory_id() {
		return category_id;
	}
	public void setcategory_id(String category_id) {
		this.category_id = category_id;
	}

	public String getproduct_tag_id() {
		return product_tag_id;
	}
	public void setproduct_tag_id(String product_tag_id) {
		this.product_tag_id = product_tag_id;
	}
	
	public String getproduct_tag() {
		return product_tag;
	}
	public void setproduct_tag(String product_tag) {
		this.product_tag = product_tag;
	}
	
}
