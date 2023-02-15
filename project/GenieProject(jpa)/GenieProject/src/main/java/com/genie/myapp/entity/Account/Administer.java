package com.genie.myapp.entity.Account;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
@DynamicInsert
@DiscriminatorValue("Admin")
public class Administer extends Account{

    @Column(name= "administer_name")
    private String name;

    @Column(name = "administer_phone")
    private String phone;

    @Column(name= "administer_email")
    private String email;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime writedate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Administer that = (Administer) o;

        if (!name.equals(that.name)) return false;
        if (!phone.equals(that.phone)) return false;
        if (!email.equals(that.email)) return false;
        return writedate.equals(that.writedate);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + phone.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + writedate.hashCode();
        return result;
    }
}
