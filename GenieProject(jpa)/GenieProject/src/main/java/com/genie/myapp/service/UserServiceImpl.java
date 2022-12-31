package com.genie.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.genie.myapp.dao.UserDAO;
import com.genie.myapp.vo.AccountVO;
import com.genie.myapp.vo.DeliveryVO;
import com.genie.myapp.vo.OrderVO;
import com.genie.myapp.vo.ProductVO;
import com.genie.myapp.vo.UserVO;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDAO dao;
    
    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public int idCheck(String genie_id) {
        return dao.idCheck(genie_id);
    }

    @Override
    public int UserWrite(UserVO vo) {
        return dao.UserWrite(vo);
    }

    @Override
    public UserVO loginOk(UserVO vo) {
        return dao.loginOk(vo);
    }

    @Override
    public UserVO getUser(String genie_id) {
        return dao.getUser(genie_id);
    }

    @Override
    public int UserEditOk(UserVO vo) {
        return dao.UserEditOk(vo);
    }

    @Override
    public int PwdEditOk(UserVO vo) {
        return dao.PwdEditOk(vo);
    }

    @Override
    public int addDelivery(UserVO vo) {
        return dao.addDelivery(vo);
    }
    
    @Override
    public int Delivery(UserVO vo) {
        return dao.Delivery(vo);
    } 
    @Override
    public int AccountWrite(AccountVO avo) {
       return dao.AccountWrite(avo);
    }

    @Override
    public List<DeliveryVO> getDeliveryList(String genie_id) {
        return dao.getDeliveryList(genie_id);
    }

    @Override
    public int delDelivery(int address_num, String genie_id) {
        return dao.delDelivery(address_num, genie_id);
    }

    @Override
    public List<OrderVO> getOrder(String genie_id) {
        return dao.getOrder(genie_id);
    }

    @Override
    public List<ProductVO> getLikeList(String genie_id) {
        return dao.getLikeList(genie_id);
    }

       
}
 