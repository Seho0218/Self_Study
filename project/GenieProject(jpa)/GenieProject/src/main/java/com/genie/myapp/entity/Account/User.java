package com.genie.myapp.entity.Account;

import com.genie.myapp.entity.Address;
import com.genie.myapp.entity.Cart;
import com.genie.myapp.entity.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
public class User implements Serializable {

    @Id @ManyToOne(fetch = LAZY)
    @JoinColumn(name="genie_id")
    private Account genie_id;

    @NotEmpty
    private String name;

    @Embedded
    private Address address;

    @NotEmpty
    private String user_email;

    @NotEmpty
    private char user_gender;

    @NotEmpty
    private LocalDateTime sign_in_date;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

//    @OneToMany(mappedBy = "genie_id")
//    private List<Myorder> orders = new ArrayList<>();

    @OneToMany(mappedBy = "genie_id")
    private List<Cart> carts = new ArrayList<>();

}