package com.genie.myapp.vo;

public class AdminProductVO {

	private String product_id;
	private String seller_id;
	private String product_category;
	private String product_tag; 
	private String product_tag_id; 
	private String product_name; 
	private String product_price;
	private String product_info; 
	private int product_stock; 
	private int product_quantity; 
	private int product_hit; 
	private String product_writedate; 
	private String product_image1; 
	private String product_image2;
	private String product_image3;
	
	@Override
	public String toString() {
		return "AdminProductVO [product_id=" + product_id + ", seller_id=" + seller_id + ", product_category="
				+ product_category + ", product_tag=" + product_tag + ", product_tag_id=" + product_tag_id
				+ ", product_name=" + product_name + ", product_price=" + product_price + ", product_info="
				+ product_info + ", product_stock=" + product_stock + ", product_quantity=" + product_quantity
				+ ", product_hit=" + product_hit + ", product_writedate=" + product_writedate + ", product_image1="
				+ product_image1 + ", product_image2=" + product_image2 + ", product_image3=" + product_image3 + "]";
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}
	public String getProduct_category() {
		return product_category;
	}
	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}
	public String getProduct_tag() {
		return product_tag;
	}
	public void setProduct_tag(String product_tag) {
		this.product_tag = product_tag;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_price() {
		return product_price;
	}
	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}
	public String getProduct_info() {
		return product_info;
	}
	public void setProduct_info(String product_info) {
		this.product_info = product_info;
	}
	public int getProduct_stock() {
		return product_stock;
	}
	public void setProduct_stock(int product_stock) {
		this.product_stock = product_stock;
	}
	public int getProduct_quantity() {
		return product_quantity;
	}
	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}
	public int getProduct_hit() {
		return product_hit;
	}
	public void setProduct_hit(int product_hit) {
		this.product_hit = product_hit;
	}
	public String getProduct_writedate() {
		return product_writedate;
	}
	public void setProduct_writedate(String product_writedate) {
		this.product_writedate = product_writedate;
	}
	public String getProduct_image1() {
		return product_image1;
	}
	public void setProduct_image1(String product_image1) {
		this.product_image1 = product_image1;
	}
	public String getProduct_image2() {
		return product_image2;
	}
	public void setProduct_image2(String product_image2) {
		this.product_image2 = product_image2;
	}
	public String getProduct_image3() {
		return product_image3;
	}
	public void setProduct_image3(String product_image3) {
		this.product_image3 = product_image3;
	}

	public String getProduct_tag_id() {
		return product_tag_id;
	}

	public void setProduct_tag_id(String product_tag_id) {
		this.product_tag_id = product_tag_id;
	}
	
}
