package com.genie.myapp.entity;

import com.genie.myapp.entity.Account.User;
import com.genie.myapp.entity.Product.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.*;

@Entity
@Table(name="cart")
@Getter @Setter
public class Cart {

    @Id @GeneratedValue(strategy = IDENTITY)
    private int cartNum;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="genieId")
    private User genieId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="productId")
    private Product productId;

    private int cartPrice;

    private int cartQty;

    private LocalDateTime cartWriteDate = LocalDateTime.now();

}
