package com.genie.myapp.domain;

import com.genie.myapp.domain.Account.User;
import com.genie.myapp.domain.Product.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Entity
@Table(name="cart")
@Getter @Setter @NotEmpty
public class Cart {

    @Id @GeneratedValue
    private int cart_num;

    @ManyToOne
    @JoinColumn(name="genie_id")
    private User genie_id;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product_id;

    private int cart_price;

    private int cart_qty;

    private LocalDateTime cart_writedate;

}
