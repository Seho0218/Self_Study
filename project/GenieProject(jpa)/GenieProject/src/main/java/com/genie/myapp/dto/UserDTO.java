package com.genie.myapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {

    private String genie_num;
    private String genie_id;
	private String genie_pwd;
    private String genie_pwd2;
    private String ROLE;
    
  	private String user_num;
    private String user_name;
    
	private String user_tel;
	private String user_phone_num1;
	private String user_phone_num2;
	private String user_phone_num3;

    private String address_num;
	private String user_email;
	private String user_zipcode;
	private String user_addr;
	private String user_detailaddr;
    private char user_gender;
	
    private String sign_in_date;
    private String payment_method;


    public String getUser_tel() {
        return user_phone_num1 + "-"+user_phone_num2+"-"+user_phone_num3;
    }
    public void setUser_tel(String user_tel) {
        this.user_tel = user_tel;
        String telSplit[] = user_tel.split("-");
		user_phone_num1 = telSplit[0];
		user_phone_num2 = telSplit[1];
		user_phone_num3 = telSplit[2];
    }
}

