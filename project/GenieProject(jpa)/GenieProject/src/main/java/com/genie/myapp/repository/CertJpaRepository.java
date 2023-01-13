package com.genie.myapp.repository;

import com.genie.myapp.dto.UserDTO;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;

import static com.genie.myapp.entity.Account.QAccount.*;
import static com.genie.myapp.entity.Account.QUser.*;

@Repository
@RequiredArgsConstructor
public class CertJpaRepository {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    //아이디 찾기
    public List<String> FindId(String user_email){
        return queryFactory
                .select(account.genie_id)
                .from(user)
                .where(user.user_email.eq(user_email))
                .fetch();
    }

    /// 비밀번호 찾기 ////

    // 중복확인
    public int overlapCheck(String value, String valueType) {
        return queryFactory
                .select(Wildcard.count)
                .from(user)
                .where(check(value.equals(valueType)))
                .fetchOne();
    }

    public Boolean check(String value, String valueType){
        return value != null ? value.equals(valueType) : null;
    }

    //입력한 이메일이 맞는지 확인
    public boolean emailCheck(String genie_id, String user_email){
        return queryFactory
                .select(Wildcard.count)
                .from(user)
                .where(user.genie_id.eq(genie_id));
    }

    //입력한 메일 가져오기
    public String emailCheck(Map<String, Object> map){}

    //비밀번호 변경
    public long PwdEditOk(UserDTO dto){
        return queryFactory
                .update(account)
                .set(account.genie_pwd, dto.getGenie_id())
                .where(account.genie_id.eq(dto.getGenie_id()))
                .execute();
    }
}
