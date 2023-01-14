package com.genie.myapp.entity.Product;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter @Setter
public class Tag {

    @Id @GeneratedValue(strategy = IDENTITY)
    private long product_tag_id;

    @OneToMany(mappedBy = "tag_connect_id", cascade = ALL)
    private List<Tag_connect> connectList = new ArrayList<>();

    private String product_tag;

    private String product_tag_eng;
}
