package com.genie.myapp.repository;

import com.genie.myapp.entity.Product.Product;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.genie.myapp.entity.Product.QProduct.*;

@Repository
@RequiredArgsConstructor
public class AdminProductServiceRepository {

    private final JPAQueryFactory queryFactory;

    public List<Product> adminProduct() {

        return queryFactory
                .selectFrom(product)
                .fetch();
    }
}
