package com.genie.myapp.service;

import java.util.List;

import com.genie.myapp.dto.*;
import com.genie.myapp.entity.Account.Account;
import com.genie.myapp.entity.Account.User;
import com.genie.myapp.entity.Address;
import com.genie.myapp.repository.jpa.*;
import com.genie.myapp.repository.UserServiceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.genie.myapp.dao.UserDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{

    @PersistenceContext private final EntityManager em;

    public final UserDAO dao;
    public final UserServiceRepository repository;
    public final AccountRepository accountRepository; //JPA 레포지토리
    public final UserRepository userRepository; //JPA 레포지토리

    public final AddressRepository addressRepository; //JPA 레포지토리
    public final OrderRepository orderRepository; //JPA 레포지토리
    public final CartRepository cartRepository; //JPA 레포지토리

    public final PasswordEncoder passwordEncoder;


    @Override
    public long idCheck(String genieId) {
        return repository.idCheck(genieId);
    }

    @Override
    public long emailCheck(UserDTO userDTO) {
        return repository.emailCheck(userDTO);
    }

    @Override
    public void UserWrite(UserDTO userDTO) {

        //비밀번호 암호화
        userDTO.setGeniePwd(passwordEncoder.encode(userDTO.getGeniePwd()));

        User user = UserDTO.convertDTOtoEntity(userDTO);
        userRepository.save(user);
    }

    @Override
    public AccountDTO loginOk(AccountDTO accountDTO) {

        //DTO -> Entity
        Account account = AccountDTO.convertDTOtoEntity(accountDTO);

        //Entity -> DTO
        return AccountDTO.convertEntityToDTO(repository.loginOk(account));
    }

    @Override
    public UserDTO getUser(AccountDTO accountDTO) {

        return UserDTO.convertEntityToDTO(
                userRepository.findByGenieId(accountDTO.getGenieId())
        );
    }

    @Override
    public void UserEditOk(UserDTO userDTO) {

        User user = UserDTO.convertDTOtoEntity(userDTO);
        User findUser = em.find(User.class, user.getGenieId());

        findUser.setUserTel(userDTO.getUserTel());
        findUser.setUserEmail(userDTO.getUserEmail());

        em.persist(findUser);
    }

    @Override
    public void PwdEditOk(AccountDTO accountDTO) {

        //DTO -> Entity
        Account account = AccountDTO.convertDTOtoEntity(accountDTO);

        //유저 정보 찾기
        User findUser = em.find(User.class, account.getGenieId());

        //비밀번호 암호화
        account.setGeniePwd(passwordEncoder.encode(accountDTO.getChangedPwd()));

        findUser.setGeniePwd(account.getGeniePwd());
        em.persist(findUser);
    }

    @Override
    public void addDelivery(AddressDTO addressDTO) {

        //DTO --> Entity
        Address address = AddressDTO.convertDTOtoEntity(addressDTO);

        addressRepository.save(address);
    }

    @Override
    public void delDelivery(int addressNum) {
        repository.delDelivery(addressNum);
    }

    @Override
    public List<AddressDTO> getDeliveryList(UserDTO userDTO) {

        //Entity -> DTO
        return AddressDTO.convertEntityToDTO(
                addressRepository.findByGenieId_GenieId(userDTO.getGenieId())
        );
    }

    @Override
    public List<OrderDTO> getOrder(UserDTO userDTO) {

        //Entity -> DTO
        return OrderDTO.convertEntityToDTO(
                orderRepository.findByGenieId_GenieId(userDTO.getGenieId())
        );
    }

    @Override
    public List<ProductDTO> getLikeList(String genie_id) {
        return dao.getLikeList(genie_id);
    }

}
 