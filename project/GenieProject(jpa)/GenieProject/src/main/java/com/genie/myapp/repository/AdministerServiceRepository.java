package com.genie.myapp.repository;

import com.genie.myapp.entity.Account.Account;
import com.genie.myapp.entity.Account.Administer;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static com.genie.myapp.entity.Account.QAccount.account;
import static com.genie.myapp.entity.Account.QAdminister.administer;

@Repository
@RequiredArgsConstructor
public class AdministerServiceRepository {

    @PersistenceContext
    private final EntityManager em;

    private final JPAQueryFactory queryFactory;

    public Administer loginOk(Account administerEntity) {
        return queryFactory
                .select(administer)
                .from(account, administer)
                .where(
                        administer.genieId.eq(administerEntity.getGenieId()),
                        administer.geniePwd.eq(administerEntity.getGeniePwd())
                )
                .fetchOne();
    }
}
