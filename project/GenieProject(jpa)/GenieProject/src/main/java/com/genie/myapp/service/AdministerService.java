package com.genie.myapp.service;

import com.genie.myapp.dto.AdministerDTO;

import java.util.Optional;

public interface AdministerService {
	// 로그인
    public Optional<AdministerDTO> loginOk(AdministerDTO dto);
    //회원 선택: 로그인 한 회원
	public AdministerDTO getAdminister(String genie_id);
    

    
}
