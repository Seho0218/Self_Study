package com.genie.myapp.repository;

import com.genie.myapp.entity.Cart;
import com.genie.myapp.entity.MyOrder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.genie.myapp.entity.Product.QProduct.*;
import static com.genie.myapp.entity.QCart.*;


@Repository
@RequiredArgsConstructor
public class OrderServiceRepository {

    public final JPAQueryFactory queryFactory;

////    카트에서 제품정보 가져오기
//    public List<Cart> readyToPay(Cart cartEntity) {
//        return queryFactory
//                .select(cart, product)
//                .from(cart)
//                .join(product).on(product.productId.eq(cart.productId.productId))
//                .where(cart.productId.cartList.get(0))
//                .fetch();
//    }

//    public List<MyOrder> getFromCart(MyOrder myOrder) {
//        return queryFactory
//                .selectFrom(cart)
//                .join(product)
//                .where(cart.cartNum.eq(myOrder.get)
//                .fetch();
//    }

}
