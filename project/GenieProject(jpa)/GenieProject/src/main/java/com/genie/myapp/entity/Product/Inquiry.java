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
    @JoinColumn(name = "genie_id")
    private User genie_id;

    private long product_id;
    private String inquery_title;
    private String inquery_content;
    private String inquery_status;
    private LocalDateTime inquiry_writedate;

}
