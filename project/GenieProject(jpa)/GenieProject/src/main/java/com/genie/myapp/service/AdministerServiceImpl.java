package com.genie.myapp.service;

import com.genie.myapp.dto.AdministerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genie.myapp.dao.AdministerDAO;

@Service
public class AdministerServiceImpl implements AdministerService{

    @Autowired
    AdministerDAO dao;

    @Override
    public AdministerDTO loginOk(AdministerDTO dto) {
        return dao.loginOk(dto);
    }

    @Override
    public AdministerDTO getAdminister(String genie_id) {
        return dao.getAdminister(genie_id);
    }
    
}
