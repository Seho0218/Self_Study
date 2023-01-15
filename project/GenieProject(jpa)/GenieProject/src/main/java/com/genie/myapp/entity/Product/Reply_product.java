package com.genie.myapp.entity.Product;

import com.genie.myapp.entity.Account.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
public class Reply_product implements Serializable {

    @Id @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "genie_id")
    private User genie_id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "product_id")
    private Product product_id;

    private int rating;

    private int reply_no;
    private String comment;
    private LocalDateTime writedate;


}
