package com.genie.myapp.service;

import java.util.List;

import com.genie.myapp.dto.ProductDTO;
import com.genie.myapp.entity.Account.User;
import com.genie.myapp.entity.Address;
import com.genie.myapp.entity.MyOrder;
import com.genie.myapp.repository.jpa.AccountRepository;
import com.genie.myapp.repository.jpa.UserRepository;
import com.genie.myapp.repository.UserServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genie.myapp.dao.UserDAO;
import com.genie.myapp.dto.UserDTO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    @Autowired UserDAO dao;

    @PersistenceContext
    private final EntityManager em;

    @Autowired AccountRepository accountRepository;
    @Autowired UserRepository userRepository;
    @Autowired UserServiceRepository repository;


    @Override
    public long idCheck(String genie_id) {
        return repository.idCheck(genie_id);
    }

    @Override
    public User UserWrite(User user) {
        return userRepository.save(user);
    }

    @Override
    public User loginOk(User dto) {
        return repository.loginOk(dto);
    }

    @Override
    public User getUser(String genie_id) {
        return repository.getUser(genie_id);
    }

    @Override
    public UserDTO getMypage(String genie_id) {
        return dao.getMypage(genie_id);
    }

    @Override
    public int UserEditOk(UserDTO dto) {
        return repository.UserEditOk(dto);
    }

    @Override
    public int PwdEditOk(User dto) {
        return repository.PwdEditOk(dto);
    }

    @Override
    public int addDelivery(Address address) {
        em.persist(address);
        return 1;
    }

    @Override
    public List<Address> getDeliveryList(String genie_id) {
        return repository.getDeliveryList(genie_id);
    }

    @Override
    public int delDelivery(int address_num) {
        return repository.delDelivery(address_num);
    }

    @Override
    public List<MyOrder> getOrder(String genie_id) {
        return repository.getOrder(genie_id);
    }

    @Override
    public List<ProductDTO> getLikeList(String genie_id) {
        return dao.getLikeList(genie_id);
    }

       
}
 