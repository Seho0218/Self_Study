package com.genie.myapp.entity;

import com.genie.myapp.entity.Account.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="address")
@Getter @Setter @NotEmpty
public class Address {

    @Id @GeneratedValue
    private Long address_num;

    @ManyToOne
    @JoinColumn(name = "genie_id")
    private User genie_id;

    private String receiver_name;
    private String receiver_tel;
    private String receiver_zipcode;
    private String receiver_addr;
    private String receiver_detailaddr;

}
