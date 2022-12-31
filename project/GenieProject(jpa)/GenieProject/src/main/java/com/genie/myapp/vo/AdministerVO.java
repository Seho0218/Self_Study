package com.genie.myapp.vo;


public class AdministerVO {
    private String genie_id;
    private String administer_name;
    private String administer_phone;
    private String genie_pwd;
    private String genie_pwd2;
    private String administer_email;
    private String ROLE;
    private String DATETIME;

    
    @Override
    public String toString() {
        return "AdministerVO [genie_id=" + genie_id + ", administer_name=" + administer_name + ", administer_phone="
                + administer_phone + ", genie_pwd=" + genie_pwd + ", genie_pwd2=" + genie_pwd2 + ", administer_email="
                + administer_email + ", ROLE=" + ROLE + ", DATETIME=" + DATETIME + "]";
    }
    
    public String getGenie_id() {
        return genie_id;
    }
    public void setGenie_id(String genie_id) {
        this.genie_id = genie_id;
    }
    public String getAdminister_name() {
        return administer_name;
    }
    public void setAdminister_name(String administer_name) {
        this.administer_name = administer_name;
    }
    public String getAdminister_phone() {
        return administer_phone;
    }
    public void setAdminister_phone(String administer_phone) {
        this.administer_phone = administer_phone;
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
    public String getAdminister_email() {
        return administer_email;
    }
    public void setAdminister_email(String administer_email) {
        this.administer_email = administer_email;
    }
    public String getROLE() {
        return ROLE;
    }
    public void setROLE(String rOLE) {
        ROLE = rOLE;
    }
    public String getDATETIME() {
        return DATETIME;
    }
    public void setDATETIME(String dATETIME) {
        DATETIME = dATETIME;
    }


    

    
}
