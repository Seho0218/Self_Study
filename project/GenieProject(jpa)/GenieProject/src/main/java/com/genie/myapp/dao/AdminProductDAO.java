package com.genie.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.genie.myapp.vo.AdminProductVO;
//추상클래스 
@Mapper
@Repository
public interface AdminProductDAO {

	public List<AdminProductVO> adminProduct(AdminProductVO VO);
}
