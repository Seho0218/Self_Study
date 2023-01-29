package com.genie.myapp.entity.Account;

import com.genie.myapp.entity.Product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Getter @Setter @DynamicUpdate
@NoArgsConstructor
@DiscriminatorValue("Seller")
public class Seller extends Account{

    @OneToMany(mappedBy = "genieId")
    private List<Product> productList;

    private String sellerTel;
    private String sellerEmail;
    private String sellerRegNo;
    private String companyName;
    private String ceoName;
    private String sellerAddress;
    private String sellerWebsite;
    private LocalDateTime writeDate = LocalDateTime.now();
    private String sellerStatus;
    private LocalDateTime approvalDate = LocalDateTime.now();

}
