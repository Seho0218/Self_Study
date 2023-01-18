package com.genie.myapp.repository;

import com.genie.myapp.entity.Account.Account;
import com.genie.myapp.entity.Account.Seller;
import com.genie.myapp.entity.Account.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@RequiredArgsConstructor
public class SellerServiceRepository {

    @PersistenceContext
    private final EntityManager em;

    private final JPAQueryFactory queryFactory;

}
