package com.genie.myapp.entity.Account;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

import static javax.persistence.InheritanceType.*;

@Entity
@Getter @Setter @DynamicUpdate
@NoArgsConstructor
@DiscriminatorColumn
@Inheritance(strategy = JOINED)
public class Account {

    @Id
    private String genieId;
    private String geniePwd;

    //회원 가입 여부 1은 회원상태, 0은 탈퇴 혹은 제재상태
    private int withdrawal=1;

    private String ROLE;

}
