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
    public void UserWrite(UserDTO userDTO) {
        User user = UserDTO.convertDTOtoEntity(userDTO);
        userRepository.save(user);
    }

    @Override
    public UserDTO loginOk(UserDTO loginDTO) {

        //DTO -> Entity
        User user = UserDTO.convertDTOtoEntity(loginDTO);

        //Entity -> DTO
        return UserDTO.convertEntityToDTO(repository.loginOk(user));
    }

    @Override
    public UserDTO getUser(UserDTO userDTO) {
        return UserDTO.convertEntityToDTO(repository.getUser(userDTO.getGenie_id()));
    }


    @Override
    public long UserEditOk(UserDTO userDTO) {
        return repository.UserEditOk(userDTO);
    }

    @Override
    public int PwdEditOk(UserDTO dto) {
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
 