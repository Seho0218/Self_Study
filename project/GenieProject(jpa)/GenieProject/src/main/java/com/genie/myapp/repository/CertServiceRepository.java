package com.genie.myapp.repository;

import com.genie.myapp.dto.AccountDTO;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static com.genie.myapp.entity.Account.QAccount.*;
import static com.genie.myapp.entity.Account.QUser.*;

@Repository
@RequiredArgsConstructor
public class CertServiceRepository {

    @PersistenceContext
    private final EntityManager em;

    private final JPAQueryFactory queryFactory;


    public List<String> FindId(String userEmail){
        return queryFactory
                .select(user.genieId)
                .from(user)
                .where(user.userEmail.eq(userEmail))
                .fetch();
    }

    public void PwdEditOk(AccountDTO accountDTO){
            queryFactory
                .update(account)
                .set(account.geniePwd, accountDTO.getChangedPwd())
                .where(account.genieId.eq(accountDTO.getGenieId()))
                .execute();
    }
}
