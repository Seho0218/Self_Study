package com.genie.myapp.entity.Account;

import com.genie.myapp.entity.Address;
import com.genie.myapp.entity.Cart;
import com.genie.myapp.entity.MyOrder;
import com.genie.myapp.entity.Product.Inquiry;
import com.genie.myapp.entity.Product.ProductLike;
import com.genie.myapp.entity.Product.Reply_product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;


@Entity
@Getter @Setter
@DynamicUpdate
@NoArgsConstructor
@DiscriminatorValue("USER")
public class User extends Account {

    private String userName;

    //서로 조회 가능하게 양방향으로 설정. 하지만 수정은 불가능한 경우는 mappedBy 설정
    @OneToMany(mappedBy = "genieId", cascade = REMOVE)
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(mappedBy = "genieId")
    private List<Inquiry> inquiries = new ArrayList<>();

    @OneToMany(mappedBy = "genieId")
    private List<ProductLike> productLikes = new ArrayList<>();

    @OneToMany(mappedBy = "genieId")
    private List<Cart> carts = new ArrayList<>();

    @OneToMany(mappedBy = "genieId")
    private List<MyOrder> orders = new ArrayList<>();

    @OneToMany(mappedBy = "genieId")
    private List<Reply_product> replyProducts = new ArrayList<>();

    private String userTel;

    private String userEmail;

    private char userGender;

    private String paymentMethod;

    private LocalDateTime signInDate = LocalDateTime.now();

}
