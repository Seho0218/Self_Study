package com.genie.myapp.vo;

public class LikeVO {
    private String genie_id;
    private int product_id;
    private int like_num;

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
    public int getLike_num() {
        return like_num;
    }
    public void setLike_num(int like_num) {
        this.like_num = like_num;
    }

}
