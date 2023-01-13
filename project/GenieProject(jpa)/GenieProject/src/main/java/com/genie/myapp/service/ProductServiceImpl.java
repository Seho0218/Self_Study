package com.genie.myapp.service;

import com.genie.myapp.dto.*;
import com.genie.myapp.repository.ProductJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
	ProductJpaRepository repository;

	@Override
	public List<ProductDTO> listProduct(ProductDTO pVO) {
		return repository.listProduct(pVO);
	}
	
	@Override
	public ProductDTO getProduct(int no) {
		return repository.getProduct(no);
	}

	@Override
	public List<ProductDTO> selectProduct(Map<String, Object> map) {
		return repository.selectProduct(map);
	}

	@Override
	public List<CartDTO> getCart(String genie_id) {
		return repository.getCart(genie_id);
	}
	
	@Override
	public SellerDTO getSeller(int product_id) {
		return repository.getSeller(product_id);
	}
	
	@Override
	public int addCart(CartDTO cvo) {
		return repository.addCart(cvo);
	}
	
	@Override
	public int delCart(int cart_num, String genie_id) {
		return repository.delCart(cart_num, genie_id);
	}
	
	@Override
	public int delMultiCart(CartDTO cvo) {
		return repository.delMultiCart(cvo);
	}

	@Override
	public void hitCount(int product_id) {
		repository.hitCount(product_id);
	}

	@Override
	public List<ProductDTO> mainAllSelect(PagingDTO pVO) {
		return repository.mainAllSelect(pVO);
	}

	@Override
	public ProductDTO likeStatus(int product_id) {
		return repository.likeStatus(product_id);
	}

	@Override
	public LikeDTO likeCheck(int product_id, String genie_id) {
		return repository.likeCheck(product_id, genie_id);
	}

	@Override
	public int updateCart(CartDTO cvo) {
		return repository.updateCart(cvo);
	}

	@Override
	public List<ProductDTO> companyName(ProductDTO pVO) {
		return repository.companyName(pVO);
	}

}


