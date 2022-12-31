package com.genie.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genie.myapp.dao.AdminProductDAO;
import com.genie.myapp.vo.AdminProductVO;

@Service
public class AdminProductServiceImpl implements AdminProductService  {
    @Autowired
	AdminProductDAO dao;

	@Override
	public List<AdminProductVO> adminProduct(AdminProductVO VO) {
		return dao.adminProduct(VO);
	}
}
