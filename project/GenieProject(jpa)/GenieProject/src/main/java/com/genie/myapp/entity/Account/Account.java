package com.genie.myapp.entity.Account;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "account")
@Getter @Setter
@NotEmpty
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account {

    @Id
    private String genie_id;

    private String genie_pwd;
    private String ROLE;

    @ColumnDefault("1")
    private boolean withdrawal;

    @OneToMany(mappedBy = "genie_id")
    private List<User> user = new ArrayList<>();

    @OneToMany(mappedBy = "genie_id")
    private List<Administer> administers = new ArrayList<>();

    @OneToMany(mappedBy = "genie_id")
    private List<Seller> sellers = new ArrayList<>();


}
