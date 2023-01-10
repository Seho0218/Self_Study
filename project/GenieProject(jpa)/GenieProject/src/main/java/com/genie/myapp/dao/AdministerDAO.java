package com.genie.myapp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.genie.myapp.vo.AdministerDTO;

@Mapper
@Repository
public interface AdministerDAO {
    // 로그인
    public AdministerDTO loginOk(AdministerDTO vo);
    //회원 선택: 로그인 한 회원
    public AdministerDTO getAdminister(String genie_id);
    
}
