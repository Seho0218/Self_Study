package com.genie.myapp.repository;

import com.genie.myapp.entity.Account.Account;
import com.genie.myapp.entity.Account.QSeller;
import com.genie.myapp.entity.Account.Seller;
import com.genie.myapp.entity.Account.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static com.genie.myapp.entity.Account.QAccount.account;
import static com.genie.myapp.entity.Account.QSeller.seller;
import static com.genie.myapp.entity.Account.QUser.user;

@Repository
@RequiredArgsConstructor
public class SellerServiceRepository {

    @PersistenceContext
    private final EntityManager em;

    private final JPAQueryFactory queryFactory;

    public Seller loginOk(Seller sellerEntity) {
        return queryFactory
                .select(seller)
                .from(account, seller)
                .where(
                        seller.genie_id.eq(sellerEntity.getGenie_id()),
                        account.withdrawal.eq(1)
                )
                .fetchOne();
    }

}
