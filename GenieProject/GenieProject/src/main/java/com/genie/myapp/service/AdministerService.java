package com.genie.myapp.service;

import com.genie.myapp.vo.AdministerVO;

public interface AdministerService {
	// 로그인
    public AdministerVO loginOk(AdministerVO vo);
    //회원 선택: 로그인 한 회원
	public AdministerVO getAdminister(String genie_id);
    

    
}
