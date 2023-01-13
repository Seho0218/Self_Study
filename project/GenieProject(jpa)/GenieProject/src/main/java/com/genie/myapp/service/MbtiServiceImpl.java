package com.genie.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genie.myapp.dao.MbtiDAO;
import com.genie.myapp.dto.ProductDTO;
import com.genie.myapp.dto.SellerProductDTO;

@Service
public class MbtiServiceImpl implements MbtiService {
	
	@Autowired
	MbtiDAO dao;

	@Override
	public List<SellerProductDTO> getProduct(String mbti) {
		return dao.getProduct(mbti);
	}

	@Override
	public List<SellerProductDTO> pricelist(String mbti) {
		return dao.pricelist(mbti);
	}

	@Override
	public List<SellerProductDTO> pricelistdesc(String mbti) {
		return dao.pricelistdesc(mbti);
	}

	@Override
	public List<SellerProductDTO> recentlist(String mbti) {
		return dao.recentlist(mbti);
	}

	@Override
	public List<SellerProductDTO> likelist(String mbti) {
		return dao.likelist(mbti);
	}

	@Override
	public List<ProductDTO> productPriceAsc(ProductDTO PDTO) {
		return dao.productPriceAsc(PDTO);
	}

	@Override
	public List<ProductDTO> productPriceDesc(ProductDTO PDTO) {
		return dao.productPriceDesc(PDTO);
	}

	@Override
	public List<ProductDTO> productRecent(ProductDTO PDTO) {
		return dao.productRecent(PDTO);
	}

	@Override
	public List<ProductDTO> productLike(ProductDTO PDTO) {
		return dao.productLike(PDTO);
	}
}
