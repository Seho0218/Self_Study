package com.genie.myapp.repository;

import com.genie.myapp.dto.AdministerDTO;
import com.genie.myapp.dto.QAdministerDTO;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.genie.myapp.entity.Account.QAccount.account;
import static com.genie.myapp.entity.Account.QAdminister.administer;
import static org.springframework.util.StringUtils.*;

@Repository
@RequiredArgsConstructor
public class AdministerJpaRepository {

    private final JPAQueryFactory queryFactory;

    // 로그인
    public List<AdministerDTO> loginOk(AdministerDTO dto){
        return queryFactory
                .select(
                        new QAdministerDTO(
                                account.ROLE,
                                administer.genie_id,
                                administer.name
                        ))
                .from(account)
                .join(administer.genie_id)
                .where(
                        GenieId(dto.getGenie_id())
                )
                .fetch();
    }

    private BooleanExpression GenieId(String genie_id){
        return hasText(genie_id) ? account.genie_id.eq(genie_id) : null;
    }
}
