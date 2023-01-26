package com.genie.myapp.repository;

import com.genie.myapp.entity.Account.Seller;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static com.genie.myapp.entity.Account.QAccount.account;
import static com.genie.myapp.entity.Account.QSeller.seller;

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
                        seller.genieId.eq(sellerEntity.getGenieId()),
                        account.withdrawal.eq(1)
                )
                .fetchOne();
    }

}
