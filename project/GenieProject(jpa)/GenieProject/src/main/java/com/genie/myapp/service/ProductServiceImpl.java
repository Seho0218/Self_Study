package com.genie.myapp.service;

import com.genie.myapp.dto.*;
import com.genie.myapp.repository.ProductServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.genie.myapp.dao.ProductDAO;

import javax.transaction.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    public final ProductDAO dao;
	public final ProductServiceRepository repository;

	@Override
	public List<ProductDTO> listProduct(ProductDTO productDTO) {
		return dao.listProduct(productDTO);
	}
	
	@Override
	public ProductDTO getProduct(int no) {
		return dao.getProduct(no);
	}

	@Override
	public List<ProductDTO> selectProduct(Map<String, Object> map) {
		return dao.selectProduct(map);
	}

	@Override
	public List<CartDTO> getCart(String genie_id) {
		return dao.getCart(genie_id);
	}
	
	@Override
	public SellerDTO getSeller(int productId) {
		return dao.getSeller(productId);
	}
	
	@Override
	public void addCart(CartDTO cartDTO) {
        dao.addCart(cartDTO);
    }
	
	@Override
	public int delCart(int cart_num, String genie_id) {
		return dao.delCart(cart_num, genie_id);
	}
	
	@Override
	public int delMultiCart(CartDTO cartDTO) {
		return dao.delMultiCart(cartDTO);
	}

	@Override
	public void hitCount(int productId) {
		dao.hitCount(productId);
	}

	@Override
	public List<ProductDTO> mainAllSelect(PagingDTO pagingDTO) {
		return dao.mainAllSelect(pagingDTO);
	}

	@Override
	public ProductDTO likeStatus(int productId) {
		return dao.likeStatus(productId);
	}

	@Override
	public LikeDTO likeCheck(int productId, String genie_id) {
		return dao.likeCheck(productId, genie_id);
	}

	@Override
	public int updateCart(CartDTO cartDTO) {
		return dao.updateCart(cartDTO);
	}

	@Override
	public List<ProductDTO> companyName(ProductDTO productDTO) {
		return dao.companyName(productDTO);
	}

}


