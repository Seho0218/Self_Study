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
    private User genieId;

    private String userName;

    private String userTel;

    private String zipCode;
    private String addr;
    private String detailAddr;

//    public void setGenieId(User genieId) {
//        this.genieId = genieId;
//        genieId.getAddresses().add(this);
//    }

}
