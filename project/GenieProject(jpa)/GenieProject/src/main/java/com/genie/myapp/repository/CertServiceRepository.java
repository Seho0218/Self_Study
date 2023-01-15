package com.genie.myapp.repository;

import com.genie.myapp.dto.UserDTO;
import com.genie.myapp.entity.Account.Account;
import com.genie.myapp.entity.Address;
import com.genie.myapp.entity.QAddress;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static com.genie.myapp.entity.Account.QAccount.*;
import static com.genie.myapp.entity.Account.QUser.*;
import static com.genie.myapp.entity.QAddress.*;

@Repository
@RequiredArgsConstructor
public class CertServiceRepository {

    @PersistenceContext
    private final EntityManager em;

    private final JPAQueryFactory queryFactory;


    public List<Account> FindId(String user_email){
        return queryFactory
                .select(user.genie_id)
                .from(user)
                .where(user.user_email.eq(user_email))
                .fetch();
    }

    public int PwdEditOk(UserDTO dto){
        return (int) queryFactory
                .update(account)
                .set(account.genie_pwd, dto.getGenie_pwd2())
                .where(account.genie_id.eq(dto.getGenie_id()))
                .execute();
    }
}
