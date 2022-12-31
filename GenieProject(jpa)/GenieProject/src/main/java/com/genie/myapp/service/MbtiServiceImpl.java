package com.genie.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genie.myapp.dao.MbtiDAO;
import com.genie.myapp.vo.ProductVO;
import com.genie.myapp.vo.SellerProductVO;

@Service
public class MbtiServiceImpl implements MbtiService {
	
	@Autowired
	MbtiDAO dao;

	@Override
	public List<SellerProductVO> getProduct(String mbti) {
		return dao.getProduct(mbti);
	}

	@Override
	public List<SellerProductVO> pricelist(String mbti) {
		return dao.pricelist(mbti);
	}

	@Override
	public List<SellerProductVO> pricelistdesc(String mbti) {
		return dao.pricelistdesc(mbti);
	}

	@Override
	public List<SellerProductVO> recentlist(String mbti) {
		return dao.recentlist(mbti);
	}

	@Override
	public List<SellerProductVO> likelist(String mbti) {
		return dao.likelist(mbti);
	}

	@Override
	public List<ProductVO> productPriceAsc(ProductVO PVO) {
		return dao.productPriceAsc(PVO);
	}

	@Override
	public List<ProductVO> productPriceDesc(ProductVO PVO) {
		return dao.productPriceDesc(PVO);
	}

	@Override
	public List<ProductVO> productRecent(ProductVO PVO) {
		return dao.productRecent(PVO);
	}

	@Override
	public List<ProductVO> productLike(ProductVO PVO) {
		return dao.productLike(PVO);
	}
}
