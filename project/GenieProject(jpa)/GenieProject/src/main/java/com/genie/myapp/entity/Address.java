package com.genie.myapp.entity;

import com.genie.myapp.entity.Account.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

import static javax.persistence.FetchType.*;

@Entity
@Getter @Setter @NotEmpty
public class Address implements Serializable {

    @Id @GeneratedValue
    private int address_num;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "genie_id")
    private User genie_id;

    private String receiver_name;
    private String receiver_tel;
    private String receiver_zipcode;
    private String receiver_addr;
    private String receiver_detailaddr;
}
