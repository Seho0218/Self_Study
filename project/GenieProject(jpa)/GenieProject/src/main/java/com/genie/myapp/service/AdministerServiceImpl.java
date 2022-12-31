package com.genie.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genie.myapp.dao.AdministerDAO;
import com.genie.myapp.vo.AdministerVO;

@Service
public class AdministerServiceImpl implements AdministerService{

    @Autowired
    AdministerDAO dao;

    @Override
    public AdministerVO loginOk(AdministerVO avo) {
        return dao.loginOk(avo);
    }

    @Override
    public AdministerVO getAdminister(String genie_id) {
        return dao.getAdminister(genie_id);
    }
    
}
