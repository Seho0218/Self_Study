package com.genie.myapp.repository;

import com.genie.myapp.dto.AdminProductDTO;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class AdminProductJpaRepository {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    //public List<AdminProductDTO> adminProduct(AdminProductDTO dto);
}
