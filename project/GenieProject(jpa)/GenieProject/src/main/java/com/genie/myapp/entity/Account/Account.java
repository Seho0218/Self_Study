package com.genie.myapp.entity.Account;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "account")
@Getter @Setter
@NoArgsConstructor
public class Account {

    @Id
    private String genie_id;

    private String genie_pwd;
    private String ROLE;

    @ColumnDefault("1")
    private boolean withdrawal;

    @OneToMany(mappedBy = "genie_id", cascade = ALL)
    private List<User> user = new ArrayList<>();

    @OneToMany(mappedBy = "genie_id", cascade = ALL)
    private List<Administer> administers = new ArrayList<>();

    @OneToMany(mappedBy = "genie_id", cascade = ALL)
    private List<Seller> sellers = new ArrayList<>();


}
