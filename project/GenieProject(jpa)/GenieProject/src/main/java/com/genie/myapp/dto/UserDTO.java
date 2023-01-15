package com.genie.myapp.dto;

import com.querydsl.core.annotations.QueryProjection;
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

    @QueryProjection
    public UserDTO(String genie_num, String genie_id, String genie_pwd, String genie_pwd2, String ROLE, String user_num, String user_name, String user_tel, String user_phone_num1, String user_phone_num2, String user_phone_num3, String address_num, String user_email, String user_zipcode, String user_addr, String user_detailaddr, char user_gender, String sign_in_date, String payment_method) {
        this.genie_num = genie_num;
        this.genie_id = genie_id;
        this.genie_pwd = genie_pwd;
        this.genie_pwd2 = genie_pwd2;
        this.ROLE = ROLE;
        this.user_num = user_num;
        this.user_name = user_name;
        this.user_tel = user_tel;
        this.user_phone_num1 = user_phone_num1;
        this.user_phone_num2 = user_phone_num2;
        this.user_phone_num3 = user_phone_num3;
        this.address_num = address_num;
        this.user_email = user_email;
        this.user_zipcode = user_zipcode;
        this.user_addr = user_addr;
        this.user_detailaddr = user_detailaddr;
        this.user_gender = user_gender;
        this.sign_in_date = sign_in_date;
        this.payment_method = payment_method;
    }
}

