package com.genie.myapp.domain.Account;

import com.genie.myapp.domain.Address;
import com.genie.myapp.domain.Cart;
import com.genie.myapp.domain.Myorder;
import com.genie.myapp.domain.OrderStatus;
import com.genie.myapp.domain.Product.Product_like;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.EAGER;

@Entity
@Getter @Setter
@NotEmpty
public class User implements Serializable {

    @Id @ManyToOne(fetch = EAGER)
    @JoinColumn(name="genie_id")
    private Account genie_id;

    private String name;

    @OneToMany(mappedBy = "genie_id")
    private List<Address> address = new ArrayList<>();

    @OneToMany(mappedBy = "product_id")
    private List<Product_like> product_like;

    private String user_email;
    private char user_gender;
    private LocalDateTime sign_in_date;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToMany(mappedBy = "genie_id")
    private List<Myorder> orders = new ArrayList<>();

    @OneToMany(mappedBy = "genie_id")
    private List<Cart> carts = new ArrayList<>();

}