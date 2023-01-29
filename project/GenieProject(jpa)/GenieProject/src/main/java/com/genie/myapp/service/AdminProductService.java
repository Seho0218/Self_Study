package com.genie.myapp.service;

import com.genie.myapp.dto.ProductDTO;

import java.util.List;

public interface AdminProductService {

	List<ProductDTO> adminProduct(ProductDTO productDTO);
}
