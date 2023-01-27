package com.genie.myapp.service;

import java.util.List;

import com.genie.myapp.repository.OrderServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.genie.myapp.dao.OrderDAO;
import com.genie.myapp.dto.CartDTO;
import com.genie.myapp.dto.OrderDTO;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    public final OrderDAO dao;
    public final OrderServiceRepository repository;

    @Override
    public List<CartDTO> readyToPay(CartDTO cartDTO) {
        return dao.readyToPay(cartDTO);
    }

    @Override
    public List<OrderDTO> getFromCart(OrderDTO orderDTO) {
        return dao.getFromCart(orderDTO);
    }

    @Override
    public void afterPayment(OrderDTO orderDTO) {
        dao.afterPayment(orderDTO);
    }

    @Override
    public void afterOrderCart(OrderDTO orderDTO) {
        dao.afterOrderCart(orderDTO);
    }

    @Override
    public List<OrderDTO> getOrderList(String genie_id) {
        return dao.getOrderList(genie_id);
    }
    




    
}
