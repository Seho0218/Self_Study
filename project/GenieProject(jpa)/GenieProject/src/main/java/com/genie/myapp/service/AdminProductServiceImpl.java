package com.genie.myapp.service;

import java.util.List;

import com.genie.myapp.dto.ProductDTO;
import com.genie.myapp.repository.AdminProductJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genie.myapp.dto.AdminProductDTO;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AdminProductServiceImpl implements AdminProductService  {

    @Autowired
	AdminProductJpaRepository repository;

	@Override
	public List<ProductDTO> adminProduct(AdminProductDTO adto) {
		return repository.adminProduct(adto);
	}
}
