package com.genie.myapp.entity.Product;

import com.genie.myapp.entity.Account.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.io.Serializable;

import static javax.persistence.FetchType.*;

@Entity
@Getter @Setter @NotEmpty
public class Product_like implements Serializable {

    @Id @OneToOne
    @JoinColumn(name = "product_id")
    private Product product_id;

    private long like_num;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "genie_id")
    private User genie_id;

}
