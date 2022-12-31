package com.genie.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genie.myapp.dao.OrderDAO;
import com.genie.myapp.vo.CartVO;
import com.genie.myapp.vo.OrderVO;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderDAO dao;

    @Override
    public List<CartVO> readyToPay(CartVO cvo) {
        return dao.readyToPay(cvo);
    }

    @Override
    public List<OrderVO> getFromCart(OrderVO ovo) {
        return dao.getFromCart(ovo);
    }

    @Override
    public int afterPayment(OrderVO lvo) {
        return dao.afterPayment(lvo);
    }

    @Override
    public int afterOrderCart(OrderVO ovo) {
        return dao.afterOrderCart(ovo);
    }

    @Override
    public List<OrderVO> getOrderList(String genie_id) {
        return dao.getOrderList(genie_id);
    }
    




    
}
