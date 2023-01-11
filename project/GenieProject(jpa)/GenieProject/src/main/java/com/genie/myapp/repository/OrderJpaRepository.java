package com.genie.myapp.repository;

import com.genie.myapp.dto.CartDTO;
import com.genie.myapp.dto.OrderDTO;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderJpaRepository {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

//    // 구매 결제페이지
//    public List<CartDTO> readyToPay(CartDTO cdto);
//
//    //장바구니에서 정보가져오기
//    public List<OrderDTO> getFromCart(OrderDTO odto);
//
//    // myorder테이블로
//    public int afterPayment(OrderDTO dto);
//
//    // 구매완료 후, 장바구니에서 삭제
//    public int afterOrderCart(OrderDTO odto);
//
//    //결제 완료 후, 정보 가져오기
//    public List<OrderDTO> getOrderList(String genie_id);
}
