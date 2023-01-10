package com.genie.myapp.service;

import com.genie.myapp.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.genie.myapp.vo.AdministerDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AdministerServiceImpl implements AdministerService{

    //@Autowired AdministerDAO dao;
    private final MemberRepository memberRepository;

    @Override
    public Optional<AdministerDTO> loginOk(AdministerDTO avo) {
        return memberRepository.loginOk(avo);
    }

    @Override
    public AdministerDTO getAdminister(String genie_id) {
        return memberRepository.getAdminister(genie_id);
    }
    
}
