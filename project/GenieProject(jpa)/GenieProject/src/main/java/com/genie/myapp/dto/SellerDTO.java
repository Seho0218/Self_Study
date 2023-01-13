package com.genie.myapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SellerDTO {
	
	private String genie_id;
	private String genie_pwd;
	private String genie_pwd2;
	private String ROLE;
	private int withdrawal;
	
	private String seller_tel;
	private String tel1;
	private String tel2;
	private String tel3;
	
	private String seller_email;
	private String seller_reg_no;
	private String company_name;
	private String ceo_name;
	private String seller_website;
	
	private String seller_address;
	private String sel_addr;
	private String sel_detailaddr;
	
	private String writedate;
	private String seller_status;
	private String approval_date;



	public String getSeller_tel() {
		return tel1+"-"+tel2+"-"+tel3;
	}
	public void setSeller_tel(String seller_tel) {
		this.seller_tel = seller_tel;
		String telSplit[] = seller_tel.split("-");
		tel1 = telSplit[0];
		tel2 = telSplit[1];
		tel3 = telSplit[2];
	}


	public String getSeller_address() {
		return sel_addr+","+sel_detailaddr;
	}
	public void setSeller_address(String seller_address) {
		this.seller_address = seller_address;
		String addrSplit[] = seller_address.split(",");
		sel_addr = addrSplit[0];
		sel_detailaddr = addrSplit[1];
	}

	
	
}
