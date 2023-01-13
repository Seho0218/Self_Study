package com.genie.myapp.repository;

import com.genie.myapp.dto.AdminProductDTO;
import com.genie.myapp.dto.ProductDTO;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AdminProductJpaRepository {

    private final JPAQueryFactory queryFactory;

    public List<ProductDTO> adminProduct(AdminProductDTO adto){

        return queryFactory
                .selectFrom();

    }
}
