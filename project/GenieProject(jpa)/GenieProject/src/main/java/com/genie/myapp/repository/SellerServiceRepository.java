package com.genie.myapp.repository;

import com.genie.myapp.dto.SellerDTO;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.genie.myapp.entity.Account.QSeller.*;

@Repository
@RequiredArgsConstructor
public class SellerServiceRepository {

    private final JPAQueryFactory queryFactory;

    public Long emailCheck(SellerDTO sellerDTO) {

        return queryFactory
                .select(seller.sellerEmail.count())
                .from(seller)
                .where(seller.sellerEmail.eq(sellerDTO.getSellerEmail()))
                .fetchOne();
    }
}
