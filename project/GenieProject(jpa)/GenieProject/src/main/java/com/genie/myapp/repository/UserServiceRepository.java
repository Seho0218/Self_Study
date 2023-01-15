package com.genie.myapp.repository;

import com.genie.myapp.condition.LoginRequirement;
import com.genie.myapp.dto.AddressDTO;
import com.genie.myapp.dto.OrderDTO;
import com.genie.myapp.dto.QAddressDTO;
import com.genie.myapp.dto.UserDTO;
import com.genie.myapp.entity.Account.QAccount;
import com.genie.myapp.entity.Account.QUser;
import com.genie.myapp.entity.Account.User;
import com.genie.myapp.entity.Product.QProduct;
import com.genie.myapp.entity.QOrder;
import com.querydsl.core.annotations.QueryProjection;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static com.genie.myapp.entity.Account.QAccount.*;
import static com.genie.myapp.entity.Account.QUser.*;
import static com.genie.myapp.entity.Product.QProduct.*;
import static com.genie.myapp.entity.QAddress.address;
import static com.genie.myapp.entity.QOrder.*;

@Repository
@RequiredArgsConstructor
public class UserServiceRepository {

    @PersistenceContext
    private final EntityManager em;

    private final JPAQueryFactory queryFactory;



//    public UserDTO getUser(String genie_id) {
//        return queryFactory
//                .select(new QUser(
//                        user.genie_id,
//                        user.user_name,
//                        user.user_tel,
//                        user.user_email
//                ))
//                .from(user)
//                .where(user.genie_id.eq(genie_id))
//                .fetch();
//    }


    public long idCheck(String genie_id){
        return queryFactory
                .select(account.genie_id.count().as("cnt"))
                .from(account)
                .where(account.genie_id.eq(genie_id))
                .fetchOne();
    }

    public int PwdEditOk(UserDTO dto){
        return (int) queryFactory
                .update(account)
                .set(account.genie_pwd, dto.getGenie_pwd2())
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

    public int delDelivery(int address_num, String genie_id) {
        return (int) queryFactory
                .delete(address)
                .where(address.address_num.eq(address_num))
                .execute();
    }

//    public List<AddressDTO> getDeliveryList(LoginRequirement condition) {
//        return queryFactory
//                .selectFrom(new QAddressDTO(
//                        address.address_num,
//                        user.genie_id,
//                        address.receiver_name,
//                        address.receiver_tel,
//                        address.receiver_zipcode,
//                        address.receiver_addr,
//                        address.receiver_detailaddr
//                ))
//                .where(account.genie_id.eq(condition.getGenie_id()));
//    }

}
