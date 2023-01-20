package com.genie.myapp.repository;

import com.genie.myapp.entity.Account.Administer;
import com.genie.myapp.entity.Account.QAdminister;
import com.genie.myapp.entity.Account.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static com.genie.myapp.entity.Account.QAccount.account;
import static com.genie.myapp.entity.Account.QAdminister.administer;
import static com.genie.myapp.entity.Account.QUser.user;

@Repository
@RequiredArgsConstructor
public class AdministerServiceRepository {

    @PersistenceContext
    private final EntityManager em;

    private final JPAQueryFactory queryFactory;

    public Administer loginOk(Administer adto) {
        return queryFactory
                .select(administer)
                .from(account, administer)
                .where(administer.genie_id.eq(adto.getGenie_id()),
                        administer.genie_pwd.eq(adto.getGenie_pwd())
                )
                .fetchOne();
    }
}
