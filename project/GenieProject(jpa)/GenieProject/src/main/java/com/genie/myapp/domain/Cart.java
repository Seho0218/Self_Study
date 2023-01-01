package com.genie.myapp.domain;

import com.genie.myapp.domain.Account.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="cart")
@Getter @Setter
public class Cart {

    @Id
    private int cart_num;

    @ManyToOne
    @JoinColumn(name="genie_id")
    private User genie_id;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product_id;


    private int cart_price;

    private int cart_qty;

}
