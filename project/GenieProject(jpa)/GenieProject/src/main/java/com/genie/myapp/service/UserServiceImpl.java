package com.genie.myapp.service;

import java.util.List;

import com.genie.myapp.entity.Account.Account;
import com.genie.myapp.entity.Account.User;
import com.genie.myapp.entity.Address;
import com.genie.myapp.entity.Order;
import com.genie.myapp.repository.jpa.AccountRepository;
import com.genie.myapp.repository.jpa.UserRepository;
import com.genie.myapp.repository.UserServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.genie.myapp.dao.UserDAO;
import com.genie.myapp.dto.ProductDTO;
import com.genie.myapp.dto.UserDTO;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired UserDAO dao;
    @Autowired AccountRepository accountRepository;
    @Autowired UserRepository userRepository;
    @Autowired UserServiceRepository repository;

    @Autowired PasswordEncoder passwordEncoder;


    @Override
    public long idCheck(String genie_id) {
        return repository.idCheck(genie_id);
    }

    @Override
    public Account AccountWrite(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public User UserWrite(User user) {
        return userRepository.save(user);
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
        return repository.UserEditOk(dto);
    }

    @Override
    public int PwdEditOk(UserDTO dto) {
        return repository.PwdEditOk(dto);
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
    public List<Address> getDeliveryList(String genie_id) {
        return repository.getDeliveryList(genie_id);
    }

    @Override
    public int delDelivery(int address_num, String genie_id) {
        return repository.delDelivery(address_num, genie_id);
    }

    @Override
    public List<Order> getOrder(String genie_id) {
        return repository.getOrder(genie_id);
    }

    @Override
    public List<ProductDTO> getLikeList(String genie_id) {
        return dao.getLikeList(genie_id);
    }

       
}
 