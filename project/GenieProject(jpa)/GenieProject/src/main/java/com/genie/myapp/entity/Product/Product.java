package com.genie.myapp.entity.Product;

import com.genie.myapp.entity.Account.Seller;
import com.genie.myapp.entity.Cart;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
@Getter @Setter
@NotEmpty
public class Product {

    @Id @GeneratedValue
    @Column(name = "product_id")
    private Long product_id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "genie_id")
    private Seller genie_id;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product_like product_like;

    @OneToMany
    private List<Cart> carts = new ArrayList<>();

    private String product_category;
    private String product_tag;
    private String product_name;
    private int product_price;

    private String product_info;
    private int product_stock;
    private int product_quantity;
    private int product_hit;
    private String product_writedate;

    private String product_image1;
    private String product_image2;
    private String product_image3;

    private String product_mbti;






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
