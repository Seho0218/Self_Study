package com.genie.myapp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.genie.myapp.vo.AdministerVO;

@Mapper
@Repository
public interface AdministerDAO {
    // 로그인
    public AdministerVO loginOk(AdministerVO vo);
    //회원 선택: 로그인 한 회원
    public AdministerVO getAdminister(String genie_id);
    
}
