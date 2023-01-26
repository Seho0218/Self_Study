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
    @JoinColumn(name = "genieId")
    private User genieId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "productId")
    private Product productId;

    private int rating;

    private int replyNo;
    private String comment;
    private LocalDateTime writeDate;


}
