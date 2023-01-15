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
@Table(name="myorder")
@Getter @Setter @NotEmpty
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order implements Serializable {

    private Long order_num;

    @Id @GeneratedValue
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="genie_id")
    private User genie_id;

    private int product_id;

    private String recipient_name;

    private String recipient_phone;

    private String recipient_address;

    private String recipient_request;

    private int order_price;

    private int order_qty;

    private LocalDateTime order_writedate;

    private OrderStatus status;

}