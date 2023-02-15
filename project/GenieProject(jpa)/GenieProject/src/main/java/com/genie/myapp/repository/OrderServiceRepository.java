package com.genie.myapp.repository;

import com.genie.myapp.entity.Cart;
import com.genie.myapp.entity.QCart;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.genie.myapp.entity.Product.QProduct.*;


@Repository
@RequiredArgsConstructor
public class OrderServiceRepository {

    public final JPAQueryFactory queryFactory;

    //카트에서 제품정보 가져오기
    public List<Cart> readyToPay(Cart cart) {
        return queryFactory
                .selectFrom(QCart.cart)
                .join(product)
                .where(QCart.cart.cartNum.eq(cart.getCartNum()))
                .fetch();
    }

//    public List<MyOrder> getFromCart(MyOrder myOrder) {
//        return queryFactory
//                .selectFrom(QCart.cart)
//                .join(product)
//                .where(QCart.cart.cartNum.eq(myOrder.get)
//                .fetch();
//    }

}
