package com.genie.myapp.service;

import java.util.List;
import java.util.Optional;

import com.genie.myapp.dto.AddressDTO;
import com.genie.myapp.dto.ProductDTO;
import com.genie.myapp.entity.Account.User;
import com.genie.myapp.entity.Address;
import com.genie.myapp.entity.MyOrder;
import com.genie.myapp.repository.jpa.AccountRepository;
import com.genie.myapp.repository.jpa.AddressRepository;
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

    @PersistenceContext private final EntityManager em;

    @Autowired UserDAO dao;
    @Autowired AccountRepository accountRepository;
    @Autowired UserServiceRepository repository;
    @Autowired UserRepository userRepository; //JPA 레포지토리
    @Autowired AddressRepository addressRepository; //JPA 레포지토리


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
    public UserDTO loginOk(UserDTO userDTO) {

        //DTO -> Entity
        User user = UserDTO.convertDTOtoEntity(userDTO);

        //Entity -> DTO
        return UserDTO.convertEntityToDTO(repository.loginOk(user));
    }

    @Override
    public UserDTO getUser(UserDTO userDTO) {
        return UserDTO.convertEntityToDTO(repository.getUser(userDTO.getGenie_id()));
    }


    @Override
    public void UserEditOk(UserDTO userDTO) {
        
        User findUser = em.find(User.class, userDTO.getGenie_id());
        System.out.println("findUser = " + findUser.getGenie_id());


    }

    @Override
    public void PwdEditOk(UserDTO userDTO) {
        
        //DTO -> Entity
        User user = UserDTO.convertDTOtoEntity(userDTO);

        User findUser = em.find(User.class, user.getGenie_id());
        findUser.setGenie_pwd(userDTO.getGenie_pwd());
    }
    


    @Override
    public void addDelivery(AddressDTO addressDTO) {
        Address address = AddressDTO.convertDTOtoEntity(addressDTO);
        addressRepository.save(address);
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
 