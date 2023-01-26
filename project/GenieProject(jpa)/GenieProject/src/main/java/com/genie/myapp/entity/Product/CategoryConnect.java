package com.genie.myapp.entity.Product;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.*;

@Entity
@Getter @Setter
public class CategoryConnect {

    @Id @GeneratedValue(strategy = IDENTITY)
    private long categoryConnectId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "categoryId")
    private Category categoryId;

    private long productId;
}
