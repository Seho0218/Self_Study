package com.genie.myapp.service;

import java.util.List;

import com.genie.myapp.repository.UserServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.genie.myapp.dao.UserDAO;
import com.genie.myapp.dto.AccountDTO;
import com.genie.myapp.dto.DeliveryDTO;
import com.genie.myapp.dto.OrderDTO;
import com.genie.myapp.dto.ProductDTO;
import com.genie.myapp.dto.UserDTO;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired UserDAO dao;
    @Autowired UserServiceRepository repository;
    
    @Autowired PasswordEncoder passwordEncoder;


    @Override
    public int idCheck(String genie_id) {
        return dao.idCheck(genie_id);
    }

    @Override
    public int UserWrite(UserDTO vo) {
        return dao.UserWrite(vo);
    }

    @Override
    public UserDTO loginOk(UserDTO vo) {
        return dao.loginOk(vo);
    }

    @Override
    public UserDTO getUser(String genie_id) {
        return dao.getUser(genie_id);
    }

    @Override
    public int UserEditOk(UserDTO vo) {
        return dao.UserEditOk(vo);
    }

    @Override
    public int PwdEditOk(UserDTO vo) {
        return dao.PwdEditOk(vo);
    }

    @Override
    public int addDelivery(UserDTO vo) {
        return dao.addDelivery(vo);
    }
    
    @Override
    public int Delivery(UserDTO vo) {
        return dao.Delivery(vo);
    } 
    @Override
    public int AccountWrite(AccountDTO avo) {
       return dao.AccountWrite(avo);
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
 