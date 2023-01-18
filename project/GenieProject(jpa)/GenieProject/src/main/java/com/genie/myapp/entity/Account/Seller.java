package com.genie.myapp.entity.Account;

import com.genie.myapp.entity.Product.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
@NotEmpty @DiscriminatorValue("Seller")
public class Seller extends Account{


    @OneToMany(mappedBy = "genie_id")
    private List<Product> productList = new ArrayList<>();

    private String seller_tel;
    private String seller_email;
    private String seller_reg_no;
    private String company_name;
    private String ceo_name;
    private String seller_address;
    private String seller_website;
    private LocalDateTime writedate;
    private boolean seller_status;
    private LocalDateTime approval_date;



}
