package com.genie.myapp.service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.genie.myapp.dao.AdminProductDAO;
import com.genie.myapp.dto.AdminProductDTO;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AdminProductServiceImpl implements AdminProductService  {

    public final AdminProductDAO dao;

	@Override
	public List<AdminProductDTO> adminProduct(AdminProductDTO adto) {
		return dao.adminProduct(adto);
	}
}
