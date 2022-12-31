package com.genie.myapp.vo;

public class InquiryVO {
	public String genie_id;
	public int product_id;
	public String inquiry_title;
	public String inquiry_content;
	public String inquiry_status;
	public String inquiry_writedate;
	public String product_name;
	
	@Override
	public String toString() {
		return "InquiryVO [genie_id=" + genie_id + ", product_id=" + product_id + ", inquiry_title=" + inquiry_title
				+ ", inquiry_content=" + inquiry_content + ", inquiry_status=" + inquiry_status + ", inquiry_writedate="
				+ inquiry_writedate + "]";
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
	public String getInquiry_title() {
		return inquiry_title;
	}
	public void setInquiry_title(String inquiry_title) {
		this.inquiry_title = inquiry_title;
	}
	public String getInquiry_content() {
		return inquiry_content;
	}
	public void setInquiry_content(String inquiry_content) {
		this.inquiry_content = inquiry_content;
	}
	public String getInquiry_status() {
		return inquiry_status;
	}
	public void setInquiry_status(String inquiry_status) {
		this.inquiry_status = inquiry_status;
	}
	public String getInquiry_writedate() {
		return inquiry_writedate;
	}
	public void setInquiry_writedate(String inquiry_writedate) {
		this.inquiry_writedate = inquiry_writedate;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	
	
}
