package com.genie.myapp.entity.Account;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.InheritanceType.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@DiscriminatorColumn
@Inheritance(strategy = JOINED)
public abstract class Account {

    @Id
    private String genie_id;

    private String genie_pwd;
    private int withdrawal;
    private String ROLE;

//    @OneToOne(mappedBy = "genie_id", cascade = ALL)
//    private User user;
//
//    @OneToOne(mappedBy = "genie_id", cascade = ALL)
//    private Administer administers;
//
//    @OneToOne(mappedBy = "genie_id", cascade = ALL)
//    private Seller sellers;


}
