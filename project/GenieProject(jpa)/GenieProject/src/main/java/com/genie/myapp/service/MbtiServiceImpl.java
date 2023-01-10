package com.genie.myapp.service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genie.myapp.dao.MbtiDAO;
import com.genie.myapp.dto.ProductDTO;
import com.genie.myapp.dto.SellerProductDTO;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MbtiServiceImpl implements MbtiService {
	
	@Autowired MbtiDAO dao;

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
	public List<ProductDTO> productPriceAsc(ProductDTO PVO) {
		return dao.productPriceAsc(PVO);
	}

	@Override
	public List<ProductDTO> productPriceDesc(ProductDTO PVO) {
		return dao.productPriceDesc(PVO);
	}

	@Override
	public List<ProductDTO> productRecent(ProductDTO PVO) {
		return dao.productRecent(PVO);
	}

	@Override
	public List<ProductDTO> productLike(ProductDTO PVO) {
		return dao.productLike(PVO);
	}
}
