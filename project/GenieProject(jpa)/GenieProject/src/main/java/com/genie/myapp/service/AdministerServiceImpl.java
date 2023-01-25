package com.genie.myapp.service;

import com.genie.myapp.dto.AdministerDTO;
import com.genie.myapp.entity.Account.Administer;
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
    public AdministerDTO loginOk(AdministerDTO administerDTO) {
        //DTO -> Entity
        Administer administer = AdministerDTO.convertDTOtoEntity(administerDTO);

        //Entity -> DTO
        return AdministerDTO.convertEntityToDTO(repository.loginOk(administer));
    }

    @Override
    public AdministerDTO getAdminister(String genie_id) {
        return dao.getAdminister(genie_id);
    }
    
}
