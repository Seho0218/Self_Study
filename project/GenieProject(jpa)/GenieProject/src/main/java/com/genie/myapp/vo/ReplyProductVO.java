package com.genie.myapp.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplyProductVO {
    private String genie_id;
    private int reply_no;
    private int product_id;
    private String comment;
    private String writedate;
    private int rating;
    
    
    
	
	@Override
	public String toString() {
		return "ReplyProductVO [genie_id=" + genie_id + ", reply_no=" + reply_no + ", product_id=" + product_id
				+ ", comment=" + comment + ", writedate=" + writedate + ", rating=" + rating + "]";
	}
	public String getGenie_id() {
		return genie_id;
	}
	public void setGenie_id(String genie_id) {
		this.genie_id = genie_id;
	}
	public int getReply_no() {
		return reply_no;
	}
	public void setReply_no(int reply_no) {
		this.reply_no = reply_no;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getWritedate() {
		return writedate;
	}
	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
    
    
}