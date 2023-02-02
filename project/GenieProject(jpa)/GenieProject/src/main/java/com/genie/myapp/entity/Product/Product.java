package com.genie.myapp.entity.Product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.genie.myapp.entity.Account.Seller;
import com.genie.myapp.entity.Cart;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.*;

@Entity
@Getter @Setter
@DynamicUpdate
public class Product {

    @Id @GeneratedValue(strategy = IDENTITY)
    private int productId;

    @JsonIgnore
    @OneToMany(mappedBy = "productId" )
    private List<Cart> cartList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "productId")
    private List<Reply_product> replyProducts = new ArrayList<>();

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "genieId")
    private Seller genieId;

    private String productCategory;
    private String productTag;
    private String productName;
    private int productPrice;
    private String productInfo;

    private int productStock=0;
    private int productQuantity=0;
    private int productHit=0;

    private int productLike;

    private LocalDateTime productWriteDate = LocalDateTime.now();

    private String productImage1;
    private String productImage2;
    private String productImage3;

    private String productMBTI;


    public void addStock(int quantity){
        this.productStock += quantity;
    }

    public void removeStock(int quantity) {
        int restStock = this.productStock - quantity;
        if(restStock<0){
            //throw new NotEnoughStockException("need more stock");
        }
        this.productStock=restStock;
    }

}

