package com.genie.myapp.entity;

import com.genie.myapp.entity.Account.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.*;

@Entity
@Getter @Setter
public class Address implements Serializable {

    @Id @GeneratedValue(strategy = IDENTITY)
    private int address_num;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "genie_id")
    private User genie_id;
    private String user_name;

    private String user_tel;

    private String user_zipcode;
    private String user_addr;
    private String user_detailaddr;
}
