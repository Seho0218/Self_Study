package com.genie.myapp.service;


import com.genie.myapp.dto.AdministerDTO;
import com.genie.myapp.entity.Account.Administer;

public interface AdministerService {
	// 로그인
    public Administer loginOk(Administer vo);
    //회원 선택: 로그인 한 회원
	public AdministerDTO getAdminister(String genie_id);
    

    
}
