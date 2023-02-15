package com.genie.myapp.service;

import java.util.List;

import com.genie.myapp.entity.MyOrder;
import com.genie.myapp.repository.OrderServiceRepository;
import com.genie.myapp.repository.jpa.CartRepository;
import com.genie.myapp.repository.jpa.OrderRepository;
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
    public final OrderServiceRepository orderServiceRepository;
    public final OrderRepository orderRepository;
    public final CartRepository cartRepository;


    @Override
    public List<CartDTO> readyToPay(CartDTO cartDTO) {

        return dao.readyToPay(cartDTO);
//        Cart cart = CartDTO.convertDTOToEntity(cartDTO);
//        return CartDTO.convertEntityToDTO(orderServiceRepository.readyToPay(cart));
    }

    @Override
    public List<OrderDTO> getFromCart(OrderDTO orderDTO) {
        return dao.getFromCart(orderDTO);
    }

    @Override
    public void afterPayment(OrderDTO orderDTO) {
        MyOrder myOrder = OrderDTO.convertDTOtoEntity(orderDTO);
        orderRepository.save(myOrder);
    }

    @Override
    public void afterOrderCart(OrderDTO orderDTO) {
        cartRepository.deleteCartsByCartNumIn(orderDTO.getCartList());
    }

    @Override
    public List<OrderDTO> getOrderList(String genie_id) {
        return dao.getOrderList(genie_id);
    }

}
