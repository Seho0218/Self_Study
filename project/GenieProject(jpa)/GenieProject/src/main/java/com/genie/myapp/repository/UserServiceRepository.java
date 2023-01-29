package com.genie.myapp.repository;

import com.genie.myapp.entity.Account.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.genie.myapp.entity.Account.QAccount.*;
import static com.genie.myapp.entity.Account.QUser.*;

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

    public User loginOk(User userEntity) {

        return queryFactory
                .selectFrom(user)
                .where(
                       user.genieId.eq(userEntity.getGenieId()),
                       user.withdrawal.eq(1)
                )
                .fetchOne();
    }

}
