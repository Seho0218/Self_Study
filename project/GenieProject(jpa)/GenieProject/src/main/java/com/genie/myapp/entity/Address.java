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
    private int addressNum;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "genieId")
    private User genieId; // User의 외래키와 맞춰줘야함

    private String userName;

    private String userTel;

    private String zipCode;
    private String addr;
    private String detailAddr;


//    public void setUser(User genieId) {
//        if (this.genieId != null) {
//            this.genieId.getAddress().remove(this);
//        }
//        this.genieId = genieId;
//        genieId.getAddress().add(this);
//    }
}
