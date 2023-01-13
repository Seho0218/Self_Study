package com.genie.myapp.service;

import java.util.List;

import com.genie.myapp.entity.Product.Product;
import com.genie.myapp.repository.MbtiJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.genie.myapp.dto.ProductDTO;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MbtiServiceImpl implements MbtiService {
	
	@Autowired MbtiJpaRepository repository;

	@Override
	public List<Product> getProduct(String mbti) {
		return repository.getProduct(mbti);
	}

	@Override
	public List<Product> pricelist(String mbti) {
		return repository.pricelist(mbti);
	}

	@Override
	public List<Product> pricelistdesc(String mbti) {
		return repository.pricelistdesc(mbti);
	}

	@Override
	public List<Product> recentlist(String mbti) {
		return repository.recentlist(mbti);
	}

	@Override
	public List<Product> likelist(String mbti) {
		return repository.likelist(mbti);
	}

	@Override
	public List<Product> productPriceAsc(ProductDTO PVO) {
		return repository.productPriceAsc(PVO);
	}

	@Override
	public List<ProductDTO> productPriceDesc(ProductDTO PVO) {
		return repository.productPriceDesc(PVO);
	}

	@Override
	public List<Product> productRecent(ProductDTO PVO) {
		return repository.productRecent(PVO);
	}

	@Override
	public List<Product> productLike(ProductDTO PVO) {
		return repository.productLike(PVO);
	}
}
