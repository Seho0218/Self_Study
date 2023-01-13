package com.genie.myapp.dao;

import java.util.List;

import com.genie.myapp.dto.AdminProductDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

//추상클래스
@Mapper
@Repository
public interface AdminProductDAO {

	public List<AdminProductDTO> adminProduct(AdminProductDTO DTO);
}
