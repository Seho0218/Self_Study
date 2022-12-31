package com.genie.myapp.vo;

public class DeliveryVO {

    private String address_num;
    private String genie_id;
	private String receiver_name;
    private String receiver_tel;
    private String receiver_zipcode;
    private String receiver_addr;
    private String receiver_detailaddr;
    
	@Override
	public String toString() {
		return "DeliveryVO [address_num=" + address_num + ", genie_id=" + genie_id + ", receiver_name=" + receiver_name
				+ ", receiver_tel=" + receiver_tel + ", receiver_zipcode=" + receiver_zipcode + ", receiver_addr="
				+ receiver_addr + ", receiver_detailaddr=" + receiver_detailaddr + "]";
	}
	public String getAddress_num() {
		return address_num;
	}
	public void setAddress_num(String address_num) {
		this.address_num = address_num;
	}
	public String getGenie_id() {
		return genie_id;
	}
	public void setGenie_id(String genie_id) {
		this.genie_id = genie_id;
	}
	public String getReceiver_name() {
		return receiver_name;
	}
	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}
	public String getReceiver_tel() {
		return receiver_tel;
	}
	public void setReceiver_tel(String receiver_tel) {
		this.receiver_tel = receiver_tel;
	}
	public String getReceiver_zipcode() {
		return receiver_zipcode;
	}
	public void setReceiver_zipcode(String receiver_zipcode) {
		this.receiver_zipcode = receiver_zipcode;
	}
	public String getReceiver_addr() {
		return receiver_addr;
	}
	public void setReceiver_addr(String receiver_addr) {
		this.receiver_addr = receiver_addr;
	}
	public String getReceiver_detailaddr() {
		return receiver_detailaddr;
	}
	public void setReceiver_detailaddr(String receiver_detailaddr) {
		this.receiver_detailaddr = receiver_detailaddr;
	}

}
