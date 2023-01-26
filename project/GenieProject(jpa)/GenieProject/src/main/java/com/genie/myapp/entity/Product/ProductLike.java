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
public class ProductLike implements Serializable {

    @Id @OneToOne(fetch = EAGER)
    @MapsId @JoinColumn(name = "productId")
    private Product productId;

    private long likeNum;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "genieId")
    private User genieId;

}
