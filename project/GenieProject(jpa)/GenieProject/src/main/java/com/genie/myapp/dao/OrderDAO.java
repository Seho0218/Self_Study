package com.genie.myapp.dao;

import java.util.List;

import com.genie.myapp.dto.CartDTO;
import com.genie.myapp.dto.OrderDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderDAO {

    // 구매 결제페이지
    public List<CartDTO> readyToPay(CartDTO cvo);

    //장바구니에서 정보가져오기
    public List<OrderDTO> getFromCart(OrderDTO ovo);

    // myorder테이블로
    public int afterPayment(OrderDTO vo);

    // 구매완료 후, 장바구니에서 삭제
    public int afterOrderCart(OrderDTO ovo);

    //결제 완료 후, 정보 가져오기
    public List<OrderDTO> getOrderList(String genie_id);

    
}
