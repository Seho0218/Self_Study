package com.genie.myapp.entity.Account;

import com.genie.myapp.entity.Address;
import com.genie.myapp.entity.Cart;
import com.genie.myapp.entity.MyOrder;
import com.genie.myapp.entity.Product.Inquiry;
import com.genie.myapp.entity.Product.ProductLike;
import com.genie.myapp.entity.Product.Reply_product;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter @Setter
@DynamicUpdate
@DynamicInsert
@RequiredArgsConstructor
@DiscriminatorValue("USER")
public class User extends Account {

    private String userName;

    //서로 조회 가능하게 양방향으로 설정. 하지만 수정은 불가능한 경우는 mappedBy 설정
    @OneToMany(mappedBy = "genieId", orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(mappedBy = "genieId")
    private List<Inquiry> inquiries = new ArrayList<>();

    @OneToMany(mappedBy = "genieId")
    private List<ProductLike> productLikes = new ArrayList<>();

    @OneToMany(mappedBy = "genieId", orphanRemoval = true)
    private List<Cart> carts = new ArrayList<>();

    @OneToMany(mappedBy = "genieId")
    private List<MyOrder> orders = new ArrayList<>();

    @OneToMany(mappedBy = "genieId")
    private List<Reply_product> replyProducts = new ArrayList<>();

    private String userTel;

    private String userEmail;

    private char userGender;

    @Column(columnDefinition = "varchar(255) default 'Card'")
    private String paymentMethod;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime signInDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        if (!super.equals(o)) return false;

        if (userGender != user.userGender) return false;
        if (!userName.equals(user.userName)) return false;
        if (!addresses.equals(user.addresses)) return false;
        if (!inquiries.equals(user.inquiries)) return false;
        if (!productLikes.equals(user.productLikes)) return false;
        if (!carts.equals(user.carts)) return false;
        if (!orders.equals(user.orders)) return false;
        if (!replyProducts.equals(user.replyProducts)) return false;
        if (!userTel.equals(user.userTel)) return false;
        if (!userEmail.equals(user.userEmail)) return false;
        if (!paymentMethod.equals(user.paymentMethod)) return false;
        return signInDate.equals(user.signInDate);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + userName.hashCode();
        result = 31 * result + addresses.hashCode();
        result = 31 * result + inquiries.hashCode();
        result = 31 * result + productLikes.hashCode();
        result = 31 * result + carts.hashCode();
        result = 31 * result + orders.hashCode();
        result = 31 * result + replyProducts.hashCode();
        result = 31 * result + userTel.hashCode();
        result = 31 * result + userEmail.hashCode();
        result = 31 * result + (int) userGender;
        result = 31 * result + (paymentMethod != null ? paymentMethod.hashCode() : 0);
        result = 31 * result + signInDate.hashCode();
        return result;
    }
}
