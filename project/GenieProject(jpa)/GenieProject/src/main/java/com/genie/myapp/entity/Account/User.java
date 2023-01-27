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


@Entity
@Getter @Setter
@DynamicUpdate
@NoArgsConstructor
@DiscriminatorValue("USER")
public class User extends Account {

    private String userName;

    @OneToMany(mappedBy = "genieId")
    private List<Address> address = new ArrayList<>(); // mappedBy를 맞춰줘야 외래키 입력 가능

    @OneToMany(mappedBy = "genieId")
    private List<Inquiry> inquiries;

    @OneToMany(mappedBy = "genieId")
    private List<ProductLike> productLike;

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

//    public void setAddress(Address address) {
//        this.address.add(address);
//        if (address.getGenieId() != this) {
//            address.setGenieId(this);
//        }
//    }
}
