package com.genie.myapp.dao;

import java.util.List;
import java.util.Map;

import com.genie.myapp.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface CertDAO {

    //아이디 찾기
	public List<String> FindId(String user_email);

    /// 비밀번호 찾기 ////

    // 중복확인
	public int overlapCheck(String value, String valueType);

    //입력한 이메일이 맞는지 확인
	public boolean emailCheck(String genie_id, String user_email);

	//입력한 메일 가져오기
    public String emailCheck(Map<String, Object> map);

    //비밀번호 변경
  	public int PwdEditOk(UserDTO vo);

 
    
}
