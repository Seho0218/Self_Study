package com.genie.myapp.repository;

import com.genie.myapp.entity.Account.Account;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.genie.myapp.entity.Account.QAccount.*;

@Repository
@RequiredArgsConstructor
public class UserServiceRepository {

    private final JPAQueryFactory queryFactory;

    public Long idCheck(String genieId){

        return queryFactory
                .select(account.genieId.count())
                .from(account)
                .where(account.genieId.eq(genieId))
                .fetchOne();
    }

    public Account loginOk(Account accountEntity) {

        return queryFactory
                .selectFrom(account)
                .where(
                       account.genieId.eq(accountEntity.getGenieId()),
                       account.withdrawal.eq(1)
                )
                .fetchOne();
    }

}
