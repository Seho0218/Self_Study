package com.genie.myapp.domain.Account;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "account")
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account {

    @Id
    private String genie_id;

    @NotEmpty
    private String genie_pwd;

    @NotEmpty
    private char ROLE;

    @NotEmpty
    private boolean withdrawal;

    @OneToMany(mappedBy = "genie_id")
    private List<User> user = new ArrayList<>();

    @OneToMany(mappedBy = "genie_id")
    private List<Administer> administers = new ArrayList<>();

    @OneToMany(mappedBy = "genid_id")
    private List<Seller> sellers = new ArrayList<>();



}
