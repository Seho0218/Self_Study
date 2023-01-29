package com.genie.myapp.entity;

import com.genie.myapp.entity.Account.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.*;

@Entity
@Getter @Setter
@Table(name = "myorder")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MyOrder implements Serializable {

    @Id @GeneratedValue(strategy = IDENTITY)
    private long orderCount;

    private String orderNum;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="genieId")
    private User genieId;

    private int productId;

    private String productName;

    private String recipientName;

    private String recipientPhone;

    private String recipientAddress;

    private String recipientRequest;

    private String recipientDeliveryStatus;

    private int orderPrice;

    private int orderQty;

    private String paymentMethod;

    private LocalDateTime orderWriteDate = LocalDateTime.now();

    private OrderStatus status;

}
