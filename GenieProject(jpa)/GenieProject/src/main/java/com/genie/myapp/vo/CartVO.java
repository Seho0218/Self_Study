package com.genie.myapp.vo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CartVO {
	
    private List<Integer> cartList;
    private int cart_num;
    private String genie_id;
    private int product_id;
    private String product_name;
	private List<String> product_name_List;
    private int cart_price;
    private int product_price;
    private int cart_qty;
    private String cart_writedate;
    private String product_image1;
    private int product_quantity;

	public int getCart_num() {
		return cart_num;
	}
	public void setCart_num(int cart_num) {
		this.cart_num = cart_num;
	}
	public String getGenie_id() {
		return genie_id;
	}
	public void setGenie_id(String genie_id) {
		this.genie_id = genie_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getCart_price() {
		return cart_price;
	}
	public void setCart_price(int cart_price) {
		this.cart_price = cart_price;
	}
	public int getCart_qty() {
		return cart_qty;
	}
	public void setCart_qty(int cart_qty) {
		this.cart_qty = cart_qty;
	}
	public String getCart_writedate() {
		return cart_writedate;
	}
	public void setCart_writedate(String cart_writedate) {
		this.cart_writedate = cart_writedate;
	}
	public String getProduct_image1() {
		return product_image1;
	}
	public void setProduct_image1(String product_image1) {
		this.product_image1 = product_image1;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getProduct_quantity() {
		return product_quantity;
	}
	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public List<Integer> getCartList() {
		return cartList;
	}
	public void setCartList(List<Integer> cartList) {
		this.cartList = cartList;
	}

}