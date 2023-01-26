package com.genie.myapp.entity;

import com.genie.myapp.entity.Account.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
    private User user;

    private String userName;

    private String userTel;

    private String userZipcode;
    private String userAddr;
    private String userDetailaddr;


//    public void setUser(User genie_id) {
//        if (this.genie_id != null) {
//            this.genie_id.getAddress().remove(this);
//        }
//        this.genie_id = genie_id;
//        genie_id.getAddress().add(this);
//    }
}
