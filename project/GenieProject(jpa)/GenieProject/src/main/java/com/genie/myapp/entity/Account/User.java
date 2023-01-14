package com.genie.myapp.entity.Account;

import com.genie.myapp.entity.Address;
import com.genie.myapp.entity.Cart;
import com.genie.myapp.entity.Myorder;
import com.genie.myapp.entity.OrderStatus;
import com.genie.myapp.entity.Product.Inquiry;
import com.genie.myapp.entity.Product.Product_like;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.EnumType.*;
import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter @NotEmpty
public class User implements Serializable {

    @Id @ManyToOne(fetch = LAZY)
    @JoinColumn(name="genie_id")
    private Account genie_id;

    private String user_name;

    @OneToMany(mappedBy = "genie_id")
    private List<Address> address;

    @OneToMany(mappedBy = "genie_id")
    private List<Inquiry> inquiries;

    @OneToMany(mappedBy = "genie_id")
    private List<Product_like> product_like;

    @OneToMany(mappedBy = "genie_id")
    private List<Cart> carts = new ArrayList<>();

    @OneToMany(mappedBy = "genie_id")
    private List<Myorder> orders = new ArrayList<>();

    private String user_tel;

    private String user_email;

    private char user_gender;

    private LocalDateTime sign_in_date;

    @Enumerated(STRING)
    private OrderStatus status;



}