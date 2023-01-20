package com.genie.myapp.entity;

import com.genie.myapp.entity.Account.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
@Table(name = "myorder")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MyOrder implements Serializable {

    @Id
    private String order_num;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="genie_id")
    private User genie_id;

    private int product_id;

    private String product_name;

    private String recipient_name;

    private String recipient_phone;

    private String recipient_address;

    private String recipient_request;

    private String recipient_delivery_status;

    private int order_price;

    private int order_qty;

    private String payment_method;

    private LocalDateTime order_writedate;

    private OrderStatus status;

}
