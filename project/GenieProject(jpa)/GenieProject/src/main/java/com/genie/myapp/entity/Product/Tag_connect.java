package com.genie.myapp.entity.Product;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@NotEmpty
public class Tag_connect {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long tag_connect_id;

    @MapsId @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "product_tag_id")
    private Tag tag_id;

    private long product_id;
}
