package com.genie.myapp.dao;

import com.genie.myapp.dto.AdministerDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface AdministerDAO {
    // 로그인
    public AdministerDTO loginOk(AdministerDTO dto);
    //회원 선택: 로그인 한 회원
    public AdministerDTO getAdminister(String genie_id);
    
}
