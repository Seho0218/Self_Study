package com.genie.myapp.entity.Account;

import lombok.*;
import org.apache.ibatis.annotations.TypeDiscriminator;
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

}
