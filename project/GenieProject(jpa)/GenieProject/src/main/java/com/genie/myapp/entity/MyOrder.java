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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyOrder myOrder = (MyOrder) o;

        if (orderCount != myOrder.orderCount) return false;
        if (productId != myOrder.productId) return false;
        if (orderPrice != myOrder.orderPrice) return false;
        if (orderQty != myOrder.orderQty) return false;
        if (!orderNum.equals(myOrder.orderNum)) return false;
        if (!genieId.equals(myOrder.genieId)) return false;
        if (!productName.equals(myOrder.productName)) return false;
        if (!recipientName.equals(myOrder.recipientName)) return false;
        if (!recipientPhone.equals(myOrder.recipientPhone)) return false;
        if (!recipientAddress.equals(myOrder.recipientAddress)) return false;
        if (!recipientRequest.equals(myOrder.recipientRequest)) return false;
        if (!recipientDeliveryStatus.equals(myOrder.recipientDeliveryStatus)) return false;
        if (!paymentMethod.equals(myOrder.paymentMethod)) return false;
        if (!orderWriteDate.equals(myOrder.orderWriteDate)) return false;
        return status == myOrder.status;
    }

    @Override
    public int hashCode() {
        int result = (int) (orderCount ^ (orderCount >>> 32));
        result = 31 * result + orderNum.hashCode();
        result = 31 * result + genieId.hashCode();
        result = 31 * result + productId;
        result = 31 * result + productName.hashCode();
        result = 31 * result + recipientName.hashCode();
        result = 31 * result + recipientPhone.hashCode();
        result = 31 * result + recipientAddress.hashCode();
        result = 31 * result + recipientRequest.hashCode();
        result = 31 * result + recipientDeliveryStatus.hashCode();
        result = 31 * result + orderPrice;
        result = 31 * result + orderQty;
        result = 31 * result + paymentMethod.hashCode();
        result = 31 * result + orderWriteDate.hashCode();
        result = 31 * result + status.hashCode();
        return result;
    }
}
