package com.genie.myapp.entity.Account;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import static javax.persistence.InheritanceType.*;

@Entity
@Getter @Setter
@DynamicUpdate @DynamicInsert
@NoArgsConstructor
@DiscriminatorColumn
@Inheritance(strategy = JOINED)
public class Account {

    @Id
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String genieId;
    private String geniePwd;

    //회원 가입 여부 1은 회원상태, 0은 탈퇴 혹은 제재상태
    private boolean withdrawal=true;

    private String ROLE;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account account)) return false;

        if (withdrawal != account.withdrawal) return false;
        if (!genieId.equals(account.genieId)) return false;
        if (!geniePwd.equals(account.geniePwd)) return false;
        return ROLE.equals(account.ROLE);
    }

    @Override
    public int hashCode() {
        int result = genieId.hashCode();
        result = 31 * result + geniePwd.hashCode();
        result = 31 * result + (withdrawal ? 1 : 0);
        result = 31 * result + ROLE.hashCode();
        return result;
    }
}
