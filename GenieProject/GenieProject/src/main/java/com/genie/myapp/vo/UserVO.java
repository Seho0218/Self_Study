package com.genie.myapp.vo;

public class UserVO {

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



    @Override
    public String toString() {
        return "UserVO [genie_id=" + genie_id + ", genie_num=" + genie_num + ", genie_pwd=" + genie_pwd
                + ", genie_pwd2=" + genie_pwd2 + ", ROLE=" + ROLE + ", payment_method=" + payment_method
                + ", sign_in_date=" + sign_in_date + ", user_addr=" + user_addr + ", user_detailaddr=" + user_detailaddr
                + ", user_email=" + user_email + ", user_gender=" + user_gender + ", user_name=" + user_name
                + ", user_num=" + user_num + ", user_phone_num1=" + user_phone_num1 + ", user_phone_num2="
                + user_phone_num2 + ", user_phone_num3=" + user_phone_num3 + ", user_tel=" + user_tel
                + ", user_zipcode=" + user_zipcode + "]";
    }

    
    
    public String getGenie_num() {
        return genie_num;
    }



    public void setGenie_num(String genie_num) {
        this.genie_num = genie_num;
    }



    public String getGenie_id() {
        return genie_id;
    }



    public void setGenie_id(String genie_id) {
        this.genie_id = genie_id;
    }



    public String getGenie_pwd() {
        return genie_pwd;
    }



    public void setGenie_pwd(String genie_pwd) {
        this.genie_pwd = genie_pwd;
    }



    public String getGenie_pwd2() {
        return genie_pwd2;
    }



    public void setGenie_pwd2(String genie_pwd2) {
        this.genie_pwd2 = genie_pwd2;
    }



    public String getROLE() {
        return ROLE;
    }



    public void setROLE(String ROLE) {
        this.ROLE = ROLE;
    }



    public String getUser_num() {
        return user_num;
    }



    public void setUser_num(String user_num) {
        this.user_num = user_num;
    }



    public String getUser_name() {
        return user_name;
    }



    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }



    public String getUser_email() {
        return user_email;
    }



    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }



    public String getUser_zipcode() {
        return user_zipcode;
    }



    public void setUser_zipcode(String user_zipcode) {
        this.user_zipcode = user_zipcode;
    }



    public String getUser_addr() {
        return user_addr;
    }



    public void setUser_addr(String user_addr) {
        this.user_addr = user_addr;
    }



    public String getUser_detailaddr() {
        return user_detailaddr;
    }



    public void setUser_detailaddr(String user_detailaddr) {
        this.user_detailaddr = user_detailaddr;
    }



    public char getUser_gender() {
        return user_gender;
    }



    public void setUser_gender(char user_gender) {
        this.user_gender = user_gender;
    }



    public String getSign_in_date() {
        return sign_in_date;
    }



    public void setSign_in_date(String sign_in_date) {
        this.sign_in_date = sign_in_date;
    }



    public String getPayment_method() {
        return payment_method;
    }



    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }



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
    public String getUser_phone_num1() {
        return user_phone_num1;
    }
    public void setUser_phone_num1(String user_phone_num1) {
        this.user_phone_num1 = user_phone_num1;
    }
    public String getUser_phone_num2() {
        return user_phone_num2;
    }
    public void setUser_phone_num2(String user_phone_num2) {
        this.user_phone_num2 = user_phone_num2;
    }
    public String getUser_phone_num3() {
        return user_phone_num3;
    }
    public void setUser_phone_num3(String user_phone_num3) {
        this.user_phone_num3 = user_phone_num3;
    }



    public String getAddress_num() {
        return address_num;
    }



    public void setAddress_num(String address_num) {
        this.address_num = address_num;
    }
}

