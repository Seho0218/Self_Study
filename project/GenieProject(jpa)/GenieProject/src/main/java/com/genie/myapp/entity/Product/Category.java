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
    private long categoryId;

    @OneToMany(mappedBy = "categoryConnectId", cascade = ALL)
    private List<CategoryConnect> connectList = new ArrayList<>();

    private String productCategory;
    private String productCategoryEng;

}
