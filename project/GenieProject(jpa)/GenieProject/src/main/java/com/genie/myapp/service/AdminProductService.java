package com.genie.myapp.service;

import java.util.List;

import com.genie.myapp.dto.AdminProductDTO;
import com.genie.myapp.dto.ProductDTO;

public interface AdminProductService {

	public List<ProductDTO> adminProduct(AdminProductDTO dto);
}
