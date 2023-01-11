package com.genie.myapp.service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.genie.myapp.dao.UserDAO;
import com.genie.myapp.dto.AccountDTO;
import com.genie.myapp.dto.DeliveryDTO;
import com.genie.myapp.dto.OrderDTO;
import com.genie.myapp.dto.ProductDTO;
import com.genie.myapp.dto.UserDTO;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired UserDAO dao;
    @Autowired PasswordEncoder passwordEncoder;

    @Override
    public int idCheck(String genie_id) {
        return dao.idCheck(genie_id);
    }

    @Override
    public int UserWrite(UserDTO dto) {
        return dao.UserWrite(dto);
    }

    @Override
    public UserDTO loginOk(UserDTO dto) {
        return dao.loginOk(dto);
    }

    @Override
    public UserDTO getUser(String genie_id) {
        return dao.getUser(genie_id);
    }

    @Override
    public int UserEditOk(UserDTO dto) {
        return dao.UserEditOk(dto);
    }

    @Override
    public int PwdEditOk(UserDTO dto) {
        return dao.PwdEditOk(dto);
    }

    @Override
    public int addDelivery(UserDTO dto) {
        return dao.addDelivery(dto);
    }
    
    @Override
    public int Delivery(UserDTO dto) {
        return dao.Delivery(dto);
    } 
    @Override
    public int AccountWrite(AccountDTO adto) {
       return dao.AccountWrite(adto);
    }

    @Override
    public List<DeliveryDTO> getDeliveryList(String genie_id) {
        return dao.getDeliveryList(genie_id);
    }

    @Override
    public int delDelivery(int address_num, String genie_id) {
        return dao.delDelivery(address_num, genie_id);
    }

    @Override
    public List<OrderDTO> getOrder(String genie_id) {
        return dao.getOrder(genie_id);
    }

    @Override
    public List<ProductDTO> getLikeList(String genie_id) {
        return dao.getLikeList(genie_id);
    }

       
}
 