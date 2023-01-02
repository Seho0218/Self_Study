package com.genie.myapp.domain.Product;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Category {

    @Id
    private String category_id;

    private String product_category;

    private String product_category_eng;

}
