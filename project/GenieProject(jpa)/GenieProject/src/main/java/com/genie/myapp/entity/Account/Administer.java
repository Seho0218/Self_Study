package com.genie.myapp.entity.Account;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.*;

@Entity
@Getter @Setter @NotEmpty
public class Administer implements Serializable {

    @Id @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "genie_id")
    private Account genie_id;

   @Column(name= "administer_name")
    private String name;

    @Column(name = "administer_phone")
    private String phone;

    @Column(name= "administer_email")
    private String email;

    private LocalDateTime writedate;

}
