package com.genie.myapp.entity.Product;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.*;

@Entity
@Getter @Setter
public class Category {

    @Id @GeneratedValue(strategy = IDENTITY)
    private long category_id;

    @OneToMany(mappedBy = "category_connect_id", cascade = ALL)
    private List<Category_connect> connectList = new ArrayList<>();

    private String product_category;
    private String product_category_eng;

}
