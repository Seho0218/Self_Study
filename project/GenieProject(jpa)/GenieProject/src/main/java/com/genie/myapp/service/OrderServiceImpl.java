package com.genie.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genie.myapp.dao.OrderDAO;
import com.genie.myapp.dto.CartDTO;
import com.genie.myapp.dto.OrderDTO;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderDAO dao;

    @Override
    public List<CartDTO> readyToPay(CartDTO cvo) {
        return dao.readyToPay(cvo);
    }

    @Override
    public List<OrderDTO> getFromCart(OrderDTO ovo) {
        return dao.getFromCart(ovo);
    }

    @Override
    public int afterPayment(OrderDTO lvo) {
        return dao.afterPayment(lvo);
    }

    @Override
    public int afterOrderCart(OrderDTO ovo) {
        return dao.afterOrderCart(ovo);
    }

    @Override
    public List<OrderDTO> getOrderList(String genie_id) {
        return dao.getOrderList(genie_id);
    }
    




    
}
