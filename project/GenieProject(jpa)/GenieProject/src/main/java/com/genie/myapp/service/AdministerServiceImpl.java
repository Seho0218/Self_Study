package com.genie.myapp.service;

import com.genie.myapp.dto.AdministerDTO;
import com.genie.myapp.entity.Account.Administer;
import com.genie.myapp.repository.AdministerServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genie.myapp.dao.AdministerDAO;

import javax.transaction.Transactional;

@Service
@Transactional(rollbackOn = Exception.class)
public class AdministerServiceImpl implements AdministerService{

    @Autowired AdministerDAO dao;
    @Autowired AdministerServiceRepository repository;

    @Override
    public Administer loginOk(Administer dto) {
        return repository.loginOk(dto);
    }

    @Override
    public AdministerDTO getAdminister(String genie_id) {
        return dao.getAdminister(genie_id);
    }
    
}
