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
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime writeDate;
    private String sellerStatus;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime approvalDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Seller seller = (Seller) o;

        if (!productList.equals(seller.productList)) return false;
        if (!sellerTel.equals(seller.sellerTel)) return false;
        if (!sellerEmail.equals(seller.sellerEmail)) return false;
        if (!sellerRegNo.equals(seller.sellerRegNo)) return false;
        if (!companyName.equals(seller.companyName)) return false;
        if (!ceoName.equals(seller.ceoName)) return false;
        if (!sellerAddress.equals(seller.sellerAddress)) return false;
        if (!sellerWebsite.equals(seller.sellerWebsite)) return false;
        if (!writeDate.equals(seller.writeDate)) return false;
        if (!sellerStatus.equals(seller.sellerStatus)) return false;
        return approvalDate.equals(seller.approvalDate);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + productList.hashCode();
        result = 31 * result + sellerTel.hashCode();
        result = 31 * result + sellerEmail.hashCode();
        result = 31 * result + sellerRegNo.hashCode();
        result = 31 * result + companyName.hashCode();
        result = 31 * result + ceoName.hashCode();
        result = 31 * result + sellerAddress.hashCode();
        result = 31 * result + sellerWebsite.hashCode();
        result = 31 * result + writeDate.hashCode();
        result = 31 * result + sellerStatus.hashCode();
        result = 31 * result + approvalDate.hashCode();
        return result;
    }
}
