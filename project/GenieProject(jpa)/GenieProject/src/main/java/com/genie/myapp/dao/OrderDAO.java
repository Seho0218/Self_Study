package com.genie.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.genie.myapp.vo.CartVO;
import com.genie.myapp.vo.OrderVO;

@Mapper
@Repository
public interface OrderDAO {

    // 구매 결제페이지
    public List<CartVO> readyToPay(CartVO cvo);

    //장바구니에서 정보가져오기
    public List<OrderVO> getFromCart(OrderVO ovo);

    // myorder테이블로
    public int afterPayment(OrderVO vo);

    // 구매완료 후, 장바구니에서 삭제
    public int afterOrderCart(OrderVO ovo);

    //결제 완료 후, 정보 가져오기
    public List<OrderVO> getOrderList(String genie_id);

    
}
