package com.genie.myapp.service;

import java.util.List;

import com.genie.myapp.dto.ProductDTO;
import com.genie.myapp.repository.AdminProductServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AdminProductServiceImpl implements AdminProductService {

    public final AdminProductServiceRepository repository;

	@Override
	public List<ProductDTO> adminProduct(ProductDTO productDTO) {

		return ProductDTO.convertEntityToDTO(repository.adminProduct());
	}
}
