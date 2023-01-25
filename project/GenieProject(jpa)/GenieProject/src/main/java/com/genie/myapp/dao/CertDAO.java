package com.genie.myapp.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface CertDAO {

    // 중복확인
	public int overlapCheck(String value, String valueType);

	//입력한 메일 가져오기
    public String emailCheck(Map<String, Object> map);

    
}
