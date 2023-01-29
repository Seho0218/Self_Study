package com.genie.myapp.service;


import com.genie.myapp.dto.AccountDTO;
import com.genie.myapp.dto.AdministerDTO;

public interface AdministerService {
	// 로그인
    AccountDTO loginOk(AccountDTO accountDTO);
    //회원 선택: 로그인 한 회원
	AdministerDTO getAdminister(AccountDTO accountDTO);
    

    
}
