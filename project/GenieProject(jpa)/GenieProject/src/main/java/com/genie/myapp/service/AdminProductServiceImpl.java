package com.genie.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genie.myapp.dao.AdminProductDAO;
import com.genie.myapp.dto.AdminProductDTO;

import javax.transaction.Transactional;

@Service
@Transactional
public class AdminProductServiceImpl implements AdminProductService  {

    @Autowired AdminProductDAO dao;
	@Autowired AdminProductService repository;

	@Override
	public List<AdminProductDTO> adminProduct(AdminProductDTO adto) {
		return dao.adminProduct(adto);
	}
}
