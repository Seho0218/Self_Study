package com.genie.myapp.entity.Product;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Tag {

    @Id
    private String product_tag_id;

    private String product_tag;

    private String product_tag_eng;
}
