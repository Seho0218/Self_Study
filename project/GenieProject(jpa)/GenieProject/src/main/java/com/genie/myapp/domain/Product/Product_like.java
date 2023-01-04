package com.genie.myapp.domain.Product;

import com.genie.myapp.domain.Account.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.io.Serializable;

import static javax.persistence.FetchType.*;

@Entity
@Getter @Setter @NotEmpty
public class Product_like implements Serializable {

    @Id
    @JoinColumn(name="product_id")
    private int product_id;

    @MapsId
    @OneToOne @JoinColumn(name = "product_id")
    private Product product;


    @ManyToOne
    @JoinColumn(name="genie_id")
    private User genie_id;

    private int like_num;
}
