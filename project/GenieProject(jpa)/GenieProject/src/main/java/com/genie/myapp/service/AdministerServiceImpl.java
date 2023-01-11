package com.genie.myapp.service;

import com.genie.myapp.repository.AdministerJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.genie.myapp.dto.AdministerDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AdministerServiceImpl implements AdministerService{

    //@Autowired AdministerDAO dao;
    private final AdministerJpaRepository ajr;

    @Override
    public Optional<AdministerDTO> loginOk(AdministerDTO adto) {
        return ajr.loginOk(adto);
    }

    @Override
    public AdministerDTO getAdminister(String genie_id) {
        return ajr.getAdminister(genie_id);
    }
    
}
