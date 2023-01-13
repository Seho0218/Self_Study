package com.genie.myapp.service;

import java.util.List;

import com.genie.myapp.repository.OrderJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genie.myapp.dto.CartDTO;
import com.genie.myapp.dto.OrderDTO;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderJpaRepository repository;

    @Override
    public List<CartDTO> readyToPay(CartDTO cvo) {
        return repository.readyToPay(cvo);
    }

    @Override
    public List<OrderDTO> getFromCart(OrderDTO odto) {
        return repository.getFromCart(odto);
    }

    @Override
    public int afterPayment(OrderDTO lvo) {
        return repository.afterPayment(lvo);
    }

    @Override
    public int afterOrderCart(OrderDTO odto) {
        return repository.afterOrderCart(odto);
    }

    @Override
    public List<OrderDTO> getOrderList(String genie_id) {
        return repository.getOrderList(genie_id);
    }
    




    
}
