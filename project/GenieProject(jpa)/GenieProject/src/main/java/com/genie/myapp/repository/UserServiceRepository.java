package com.genie.myapp.repository;

import com.genie.myapp.dto.AccountDTO;
import com.genie.myapp.dto.UserDTO;
import com.genie.myapp.entity.Account.Account;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.genie.myapp.entity.Account.QAccount.account;
import static com.genie.myapp.entity.Account.QUser.*;
import static com.genie.myapp.entity.Product.QProduct.*;
import static com.genie.myapp.entity.Product.QProductLike.*;
import static com.genie.myapp.entity.QAddress.address;

@Repository
@RequiredArgsConstructor
public class UserServiceRepository {

    private final JPAQueryFactory queryFactory;

    public Long idCheck(String genieId){

        return queryFactory
                .select(account.genieId.count())
                .from(account)
                .where(account.genieId.eq(genieId))
                .fetchOne();
    }

    public Account loginOk(Account accountEntity) {

        return queryFactory
                .selectFrom(account)
                .where(
                       account.genieId.eq(accountEntity.getGenieId()),
                       account.withdrawal.eq(true)
                )
                .fetchOne();
    }

    public void delDelivery(int addressNum) {
        queryFactory
                .delete(address)
                .where(address.addressNum.eq(addressNum))
                .execute();
    }

    public Long emailCheck(UserDTO userDTO) {
        return queryFactory
                .select(user.userEmail.count())
                .from(user)
                .where(user.userEmail.eq(userDTO.getUserEmail()))
                .fetchOne();
    }

    public List<Tuple> getLikeList(AccountDTO accountDTO) {
        return queryFactory
                .select(productLike, product)
                .from(productLike)
                .join(product).on(productLike.productId.productId.eq(product.productId))
                .where(productLike.genieId.genieId.eq(accountDTO.getGenieId()))
                .fetch();
    }
}
