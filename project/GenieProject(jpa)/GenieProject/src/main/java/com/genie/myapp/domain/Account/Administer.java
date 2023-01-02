package com.genie.myapp.domain.Account;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.*;

@Entity
@Getter @Setter
public class Administer implements Serializable {

    @Id @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "genie_id")
    private Account genie_id;

    @NotEmpty @Column(name= "administer_name")
    private String name;

    @NotEmpty @Column(name = "administer_phone")
    private String phone;

    @NotEmpty @Column(name= "administer_email")
    private String email;

    @NotEmpty
    private LocalDateTime writedate;

}
