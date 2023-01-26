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
    private LocalDateTime inquiryWriteDate;

}
