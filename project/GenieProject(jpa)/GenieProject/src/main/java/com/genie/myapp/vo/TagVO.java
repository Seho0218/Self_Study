package com.genie.myapp.vo;

public class TagVO{
    private String genie_who;
    private String genie_day;
    private String genie_old;
    private String gender;
    private int product_price;
    private int money_low;
    private int money_max;



    @Override
    public String toString() {
        return "TagVO [gender=" + gender + ", genie_day=" + genie_day + ", genie_old=" + genie_old + ", genie_who="
                + genie_who + ", money_low=" + money_low + ", money_max=" + money_max + ", product_price="
                + product_price + "]";
    }
    
    public String getGenie_who() {
        return genie_who;
    }
    public void setGenie_who(String genie_who) {
        this.genie_who = genie_who;
    }
    public String getGenie_day() {
        return genie_day;
    }
    public void setGenie_day(String genie_day) {
        this.genie_day = genie_day;
    }
    public String getGenie_old() {
        return genie_old;
    }
    public void setGenie_old(String genie_old) {
        this.genie_old = genie_old;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getProduct_price() {
        return product_price;
    }
    public void setProduct_price(int product_price) {
        this.product_price = product_price;
    }
    public int getMoney_low() {
        return money_low;
    }
    public void setMoney_low(int money_low) {
        this.money_low = money_low;
    }
    public int getMoney_max() {
        return money_max;
    }
    public void setMoney_max(int money_max) {
        this.money_max = money_max;
    }


    


    
    
    
}