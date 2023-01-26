package com.genie.myapp.repository;

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

@Repository
@RequiredArgsConstructor
public class UserServiceRepository {

    private final JPAQueryFactory queryFactory;

    public long idCheck(String genieId){

        return queryFactory
                .select(account.genieId.count().as("cnt"))
                .from(account)
                .where(account.genieId.eq(genieId))
                .fetchOne();
    }

    public User loginOk(User userEntity) {

        return queryFactory
                .selectFrom(user)
                .where(
                       user.genieId.eq(userEntity.getGenieId()),
                       user.withdrawal.eq(1)
                )
                .fetchOne();
    }

    public User getUser(String genieId) {

        return queryFactory
                .selectFrom(user)
                .where(user.genieId.eq(genieId))
                .fetchOne();
    }

    public List<MyOrder> getOrder(User userEntity) {

        return null;
    }

    public List<Address> getDeliveryList(User userEntity) {

        System.out.println("userDTO.getgenieId() = " + userEntity.getGenieId());

        return queryFactory
                .select(address)
                .from(address, user)
                .where(user.genieId.eq(userEntity.getGenieId()))
                .fetch();
    }

    public long delDelivery(int address_num) {

        return queryFactory
                .delete(address)
                .where(address.address_num.eq(address_num))
                .execute();
    }

}
