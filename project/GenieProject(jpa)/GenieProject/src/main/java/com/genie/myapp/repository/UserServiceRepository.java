package com.genie.myapp.repository;

import com.genie.myapp.dto.*;
import com.genie.myapp.entity.Account.User;
import com.genie.myapp.entity.Address;
import com.genie.myapp.entity.MyOrder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static com.genie.myapp.entity.Account.QAccount.*;
import static com.genie.myapp.entity.Account.QUser.*;
import static com.genie.myapp.entity.QAddress.address;
import static com.genie.myapp.entity.QMyOrder.*;

@Repository
@RequiredArgsConstructor
public class UserServiceRepository {

    @PersistenceContext
    private final EntityManager em;

    private final JPAQueryFactory queryFactory;

    public User loginOk(User dto) {
        return queryFactory
                .select(user)
                .from(account, user)
                .where(
                       user.genie_id.eq(dto.getGenie_id()),
                       account.withdrawal.eq(1)
                )
                .fetchOne();
    }


    public User getUser(String genie_id) {
        return queryFactory
                .selectFrom(user)
                .where(user.genie_id.eq(genie_id))
                .fetchOne();
    }

    public long idCheck(String genie_id){
        return queryFactory
                .select(account.genie_id.count().as("cnt"))
                .from(account)
                .where(account.genie_id.eq(genie_id))
                .fetchOne();
    }

    public List<MyOrder> getOrder(String genie_id) {

        return queryFactory
                .select(myOrder)
                .from(myOrder, user)
                .where(user.genie_id.eq(genie_id))
                .orderBy(myOrder.order_writedate.desc())
                .fetch();
    }

    public List<Address> getDeliveryList(String genie_id) {
        return queryFactory
                .select(address)
                .from(address, user)
                .where(user.genie_id.eq(genie_id))
                .fetch();
    }



    public int PwdEditOk(UserDTO dto){
        return (int) queryFactory
                .update(account)
                .set(account.genie_pwd, dto.getGenie_pwd())
                .where(account.genie_id.eq(dto.getGenie_id()))
                .execute();
    }

    public int UserEditOk(UserDTO dto){
        return (int) queryFactory
                .update(user)
                .set(user.user_tel, dto.getUser_tel())
                .where(account.genie_id.eq(dto.getGenie_id()))
                .execute();
    }


    public int delDelivery(int address_num) {
        return (int) queryFactory
                .delete(address)
                .where(address.address_num.eq(address_num)
                )
                .execute();
    }

}
