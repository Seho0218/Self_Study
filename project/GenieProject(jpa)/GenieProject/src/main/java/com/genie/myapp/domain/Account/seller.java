package com.genie.myapp.domain.Account;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
public class Seller {

    @Id @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "genie_id")
    private Account genie_id;
}
