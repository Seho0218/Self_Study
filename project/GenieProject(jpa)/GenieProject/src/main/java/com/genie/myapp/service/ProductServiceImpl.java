package com.genie.myapp.service;

import com.genie.myapp.dto.*;
import com.genie.myapp.repository.ProductServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.genie.myapp.dao.ProductDAO;

import javax.transaction.Transactional;


@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired ProductDAO dao;
	@Autowired ProductServiceRepository repository;

	@Override
	public List<ProductDTO> listProduct(ProductDTO pDTO) {
		return dao.listProduct(pDTO);
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
	public SellerDTO getSeller(int product_id) {
		return dao.getSeller(product_id);
	}
	
	@Override
	public void addCart(CartDTO cdto) {
        dao.addCart(cdto);
    }
	
	@Override
	public int delCart(int cart_num, String genie_id) {
		return dao.delCart(cart_num, genie_id);
	}
	
	@Override
	public int delMultiCart(CartDTO cdto) {
		return dao.delMultiCart(cdto);
	}

	@Override
	public void hitCount(int product_id) {
		dao.hitCount(product_id);
	}

	@Override
	public List<ProductDTO> mainAllSelect(PagingDTO pDTO) {
		return dao.mainAllSelect(pDTO);
	}

	@Override
	public ProductDTO likeStatus(int product_id) {
		return dao.likeStatus(product_id);
	}

	@Override
	public LikeDTO likeCheck(int product_id, String genie_id) {
		return dao.likeCheck(product_id, genie_id);
	}

	@Override
	public int updateCart(CartDTO cdto) {
		return dao.updateCart(cdto);
	}

	@Override
	public List<ProductDTO> companyName(ProductDTO pDTO) {
		return dao.companyName(pDTO);
	}

}


