package com.genie.myapp.entity.Product;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter @Setter
public class Tag_connect {

    @Id @GeneratedValue(strategy = IDENTITY)
    private long tagConnectId;

    @MapsId @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "productTagId")
    private Tag tagId;

    private long productId;
}
