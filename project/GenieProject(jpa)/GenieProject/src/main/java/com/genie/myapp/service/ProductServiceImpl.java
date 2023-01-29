package com.genie.myapp.service;

import com.genie.myapp.dto.*;
import com.genie.myapp.repository.ProductServiceRepository;
import com.genie.myapp.repository.jpa.CartRepository;
import com.genie.myapp.repository.jpa.ProductRepository;
import com.genie.myapp.repository.jpa.SellerRepository;
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

	public final SellerRepository sellerRepository;
	public final ProductRepository productRepository; //데이터 JPA
	public final CartRepository cartRepository; //데이터 JPA

	@Override
	public List<ProductDTO> listProduct(ProductDTO productDTO) {

		//return ProductDTO.convertEntityToDTO(repository.listProduct(productDTO));
		return dao.listProduct(productDTO);
	}
	
	@Override
	public ProductDTO getProduct(ProductDTO productDTO) {
		return ProductDTO.convertEntityToDTO(
				productRepository.findProductByProductId(productDTO.getProductId()));
	}

	@Override
	public List<ProductDTO> selectProduct(Map<String, Object> map) {
		return dao.selectProduct(map);
	}

	@Override
	public List<CartDTO> getCart(UserDTO userDTO) {
		return dao.getCart(userDTO.getGenieId());
	}
	
	@Override
	public SellerDTO getSeller(ProductDTO productDTO) {

		return dao.getSeller(productDTO.getProductId());
	}
	
	@Override
	public void addCart(CartDTO cartDTO) {
        dao.addCart(cartDTO);
    }
	
	@Override
	public void delCart(CartDTO cartDTO) {
		cartRepository.deleteById(cartDTO.getCartNum());
	}
	
	@Override
	public void delMultiCart(CartDTO cartDTO) {
		cartRepository.deleteCartsByCartNumIn(cartDTO.getCartList());
	}

	@Override
	public void hitCount(ProductDTO productDTO) {
		dao.hitCount(productDTO.getProductId());
	}

	@Override
	public List<ProductDTO> mainAllSelect(PagingDTO pagingDTO) {
		return dao.mainAllSelect(pagingDTO);
	}

	@Override
	public ProductDTO likeStatus(ProductDTO productDTO) {
		return dao.likeStatus(productDTO.getProductId());
	}

	@Override
	public LikeDTO likeCheck(ProductDTO productDTO, String genie_id) {
		return dao.likeCheck(productDTO.getProductId(), genie_id);
	}

	@Override
	public void updateCart(CartDTO cartDTO) {
		dao.updateCart(cartDTO);
	}

	@Override
	public List<ProductDTO> companyName(ProductDTO productDTO) {
		return dao.companyName(productDTO);
	}

}


