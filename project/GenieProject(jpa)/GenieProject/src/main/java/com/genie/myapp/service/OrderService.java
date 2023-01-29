package com.genie.myapp.service;

import java.util.List;

import com.genie.myapp.dto.CartDTO;
import com.genie.myapp.dto.OrderDTO;

public interface OrderService {

    // 구매 결제페이지
    List<CartDTO> readyToPay(CartDTO cartDTO);

    //장바구니에서 정보가져오기
    List<OrderDTO> getFromCart(OrderDTO orderDTO);

    // myorder테이블로
    void afterPayment(OrderDTO orderDTO);

    // 구매완료 후, 장바구니에서 삭제
    void afterOrderCart(OrderDTO orderDTO);

    //결제 완료 후, 정보 가져오기
    List<OrderDTO> getOrderList(String genie_id);

    
    
}
