package com.genie.myapp.entity.Product;

import com.genie.myapp.entity.Account.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import java.io.Serializable;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
@NotEmpty
public class Inquiry implements Serializable {

    @Id @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "genieId")
    private User genieId;

    private long productId;
    private String inquiryTitle;
    private String inquiryContent;
    private String inquiryStatus;
    private LocalDateTime inquiryWriteDate = LocalDateTime.now();



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Inquiry inquiry = (Inquiry) o;

        if (productId != inquiry.productId) return false;
        if (!genieId.equals(inquiry.genieId)) return false;
        if (!inquiryTitle.equals(inquiry.inquiryTitle)) return false;
        if (!inquiryContent.equals(inquiry.inquiryContent)) return false;
        if (!inquiryStatus.equals(inquiry.inquiryStatus)) return false;
        return inquiryWriteDate.equals(inquiry.inquiryWriteDate);
    }

    @Override
    public int hashCode() {
        int result = genieId.hashCode();
        result = 31 * result + (int) (productId ^ (productId >>> 32));
        result = 31 * result + inquiryTitle.hashCode();
        result = 31 * result + inquiryContent.hashCode();
        result = 31 * result + inquiryStatus.hashCode();
        result = 31 * result + inquiryWriteDate.hashCode();
        return result;
    }
}
