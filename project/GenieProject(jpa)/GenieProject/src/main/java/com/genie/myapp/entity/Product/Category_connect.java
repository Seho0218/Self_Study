package com.genie.myapp.entity.Product;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.*;

@Entity
@Getter
@Setter
@NotEmpty
public class Category_connect {

    @Id @GeneratedValue(strategy = IDENTITY)
    private long category_connect_id;

    @MapsId @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "category_id")
    private Category category_id;

    private long product_id;
}
