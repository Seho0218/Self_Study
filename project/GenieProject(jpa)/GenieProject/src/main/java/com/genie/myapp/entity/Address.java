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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (addressNum != address.addressNum) return false;
        if (!genieId.equals(address.genieId)) return false;
        if (!userName.equals(address.userName)) return false;
        if (!userTel.equals(address.userTel)) return false;
        if (!zipCode.equals(address.zipCode)) return false;
        if (!addr.equals(address.addr)) return false;
        return detailAddr.equals(address.detailAddr);
    }

    @Override
    public int hashCode() {
        int result = addressNum;
        result = 31 * result + genieId.hashCode();
        result = 31 * result + userName.hashCode();
        result = 31 * result + userTel.hashCode();
        result = 31 * result + zipCode.hashCode();
        result = 31 * result + addr.hashCode();
        result = 31 * result + detailAddr.hashCode();
        return result;
    }
}
