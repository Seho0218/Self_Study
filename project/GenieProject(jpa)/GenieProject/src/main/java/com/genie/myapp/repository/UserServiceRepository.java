package com.genie.myapp.repository;

import com.genie.myapp.dto.UserDTO;
import com.genie.myapp.entity.Account.User;
import com.genie.myapp.entity.Address;
import com.genie.myapp.entity.MyOrder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.genie.myapp.entity.Account.QAccount.*;
import static com.genie.myapp.entity.Account.QUser.*;
import static com.genie.myapp.entity.QAddress.address;
import static com.genie.myapp.entity.QMyOrder.*;

@Repository
@RequiredArgsConstructor
public class UserServiceRepository {

    private final JPAQueryFactory queryFactory;

    public long idCheck(String genie_id){

        return queryFactory
                .select(account.genie_id.count().as("cnt"))
                .from(account)
                .where(account.genie_id.eq(genie_id))
                .fetchOne();
    }

    public User loginOk(User userEntity) {

        return queryFactory
                .select(user)
                .from(account, user)
                .where(
                       user.genie_id.eq(userEntity.getGenie_id()),
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

    public List<MyOrder> getOrder(UserDTO userDTO) {

        return queryFactory
                .select(myOrder)
                .from(myOrder, user)
                .where(
                        user.genie_id.eq(userDTO.getGenie_id())
                )
                .orderBy(myOrder.order_writedate.desc())
                .fetch();
    }

    public List<Address> getDeliveryList(UserDTO userDTO) {
        return queryFactory
                .select(address)
                .from(address, user)
                .where(user.genie_id.eq(userDTO.getGenie_id()))
                .fetch();
    }


    public long delDelivery(int address_num) {

        return queryFactory
                .delete(address)
                .where(address.address_num.eq(address_num))
                .execute();
    }

}
