package com.genie.myapp.service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.genie.myapp.dao.MbtiDAO;
import com.genie.myapp.dto.ProductDTO;
import com.genie.myapp.dto.SellerProductDTO;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MbtiServiceImpl implements MbtiService {
	
	public final MbtiDAO dao;

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
	public List<ProductDTO> productPriceAsc(ProductDTO productDTO) {
		return dao.productPriceAsc(productDTO);
	}

	@Override
	public List<ProductDTO> productPriceDesc(ProductDTO productDTO) {
		return dao.productPriceDesc(productDTO);
	}

	@Override
	public List<ProductDTO> productRecent(ProductDTO productDTO) {
		return dao.productRecent(productDTO);
	}

	@Override
	public List<ProductDTO> productLike(ProductDTO productDTO) {
		return dao.productLike(productDTO);
	}
}
