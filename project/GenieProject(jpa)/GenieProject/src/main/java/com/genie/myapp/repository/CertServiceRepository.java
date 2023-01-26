package com.genie.myapp.repository;

import com.genie.myapp.dto.UserDTO;
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

    public int PwdEditOk(UserDTO dto){
        return (int) queryFactory
                .update(account)
                .set(account.geniePwd, dto.getGeniePwd2())
                .where(account.genieId.eq(dto.getGenieId()))
                .execute();
    }
}
