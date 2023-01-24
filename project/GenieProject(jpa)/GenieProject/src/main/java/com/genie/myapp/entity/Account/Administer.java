package com.genie.myapp.entity.Account;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
@DiscriminatorValue("Admin")
public class Administer extends Account{

    @Column(name= "administer_name")
    private String name;

    @Column(name = "administer_phone")
    private String phone;

    @Column(name= "administer_email")
    private String email;

    private LocalDateTime writedate  = LocalDateTime.now();

}
