package com.genie.myapp.service;

import java.util.List;

import com.genie.myapp.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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

    @Autowired
    UserJpaRepository repository;
    @Autowired PasswordEncoder passwordEncoder;

    @Override
    public int idCheck(String genie_id) {
        return repository.idCheck(genie_id);
    }

    @Override
    public int UserWrite(UserDTO dto) {
        return repository.UserWrite(dto);
    }

    @Override
    public UserDTO loginOk(UserDTO dto) {
        return repository.loginOk(dto);
    }

    @Override
    public UserDTO getUser(String genie_id) {
        return repository.getUser(genie_id);
    }

    @Override
    public int UserEditOk(UserDTO dto) {
        return repository.UserEditOk(dto);
    }

    @Override
    public int PwdEditOk(UserDTO dto) {
        return repository.PwdEditOk(dto);
    }

    @Override
    public int addDelivery(UserDTO dto) {
        return repository.addDelivery(dto);
    }
    
    @Override
    public int Delivery(UserDTO dto) {
        return repository.Delivery(dto);
    } 
    @Override
    public int AccountWrite(AccountDTO adto) {
       return repository.AccountWrite(adto);
    }

    @Override
    public List<DeliveryDTO> getDeliveryList(String genie_id) {
        return repository.getDeliveryList(genie_id);
    }

    @Override
    public int delDelivery(int address_num, String genie_id) {
        return repository.delDelivery(address_num, genie_id);
    }

    @Override
    public List<OrderDTO> getOrder(String genie_id) {
        return repository.getOrder(genie_id);
    }

    @Override
    public List<ProductDTO> getLikeList(String genie_id) {
        return repository.getLikeList(genie_id);
    }

       
}
 