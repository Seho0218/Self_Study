package com.genie.myapp.service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genie.myapp.dao.AdminProductDAO;
import com.genie.myapp.vo.AdminProductDTO;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AdminProductServiceImpl implements AdminProductService  {

    @Autowired
	AdminProductDAO dao;

	@Override
	public List<AdminProductDTO> adminProduct(AdminProductDTO VO) {
		return dao.adminProduct(VO);
	}
}
