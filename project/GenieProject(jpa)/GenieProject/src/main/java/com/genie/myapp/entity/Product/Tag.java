package com.genie.myapp.entity.Product;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter @Setter
public class Tag {

    @Id @GeneratedValue(strategy = IDENTITY)
    private long productTagId;

    @OneToMany(mappedBy = "tagConnectId")
    private List<Tag_connect> connectList = new ArrayList<>();

    private String productTag;
    private String productTagEng;
}
