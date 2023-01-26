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

    private LocalDateTime orderWritedate = LocalDateTime.now();

    private OrderStatus status;

}
