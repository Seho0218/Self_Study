package com.genie.myapp.service;

import com.genie.myapp.dto.AccountDTO;
import com.genie.myapp.dto.AdministerDTO;
import com.genie.myapp.entity.Account.Account;
import com.genie.myapp.repository.AdministerServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.genie.myapp.dao.AdministerDAO;

import javax.transaction.Transactional;

@Service
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
public class AdministerServiceImpl implements AdministerService{

    public final AdministerDAO dao;
    public final AdministerServiceRepository repository;

    @Override
    public AccountDTO loginOk(AccountDTO accountDTO) {
        //DTO -> Entity
        Account account = AccountDTO.convertDTOtoEntity(accountDTO);

        //Entity -> DTO
        return AccountDTO.convertEntityToDTO(repository.loginOk(account));
    }

    @Override
    public AdministerDTO getAdminister(AccountDTO accountDTO) {
        return dao.getAdminister(accountDTO.getGenieId());
    }
    
}
