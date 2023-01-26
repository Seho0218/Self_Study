package com.genie.myapp.entity.Account;

import com.genie.myapp.entity.Address;
import com.genie.myapp.entity.Cart;
import com.genie.myapp.entity.MyOrder;
import com.genie.myapp.entity.Product.Inquiry;
import com.genie.myapp.entity.Product.Product_like;
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
    private List<MyOrder> orders = new ArrayList<>();

    @OneToMany(mappedBy = "genie_id")
    private List<Reply_product> replyProducts = new ArrayList<>();

    private String user_tel;

    private String user_email;

    private char user_gender;

    private String payment_method;

    private LocalDateTime sign_in_date = LocalDateTime.now();

//    public void setAddress(Address address) {
//        this.address.add(address);
//        if (address.getGenie_id() != this) {
//            address.setGenie_id(this);
//        }
//    }
}
