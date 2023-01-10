package com.genie.myapp.repository;

import com.genie.myapp.dto.AdministerDTO;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    // 로그인
    public Optional<AdministerDTO> loginOk(AdministerDTO vo){
        AdministerDTO AdministerDTO = em.find(AdministerDTO.class, id);
        return Optional.ofNullable(AdministerDTO);

    }
    //회원 선택: 로그인 한 회원
    public AdministerDTO getAdminister(String genie_id){
        return null;
    }
    
}
