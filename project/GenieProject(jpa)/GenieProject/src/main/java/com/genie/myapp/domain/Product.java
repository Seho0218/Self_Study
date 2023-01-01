package com.genie.myapp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter @Setter
public class Product {

    @Id @GeneratedValue
    private Long product_id;

    @NotEmpty
    private String product_category;

    @NotEmpty
    private String Product_tag;

    @NotEmpty
    private String Product_name;

    @NotEmpty
    private int Product_price;

    @NotEmpty
    private String Product_info;

    @NotEmpty
    private int Product_stock;

    @NotEmpty
    private int Product_quantity;

    @NotEmpty
    private int Product_hit;

    @NotEmpty
    private int like;



    @NotEmpty
    private int product_stock;

    public void addStock(int quantity){
        this.product_stock += quantity;
    }

    public void removeStock(int quantity) {
        int restStock = this.product_stock - quantity;
        if(restStock<0){
            //throw new NotEnoughStockException("need more stock");
        }
        this.product_stock=restStock;
    }

}
