package com.genie.myapp.repository;

import com.genie.myapp.dto.AdministerDTO;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class AdministerJpaRepository {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    // 로그인
    public AdministerDTO loginOk(AdministerDTO dto){
        return null;
    }
    //회원 선택: 로그인 한 회원
    public AdministerDTO getAdminister(String genie_id){
        return null;
    }

}
