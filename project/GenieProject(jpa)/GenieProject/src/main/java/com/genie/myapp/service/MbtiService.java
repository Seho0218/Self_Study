package com.genie.myapp.service;

import java.util.List;

import com.genie.myapp.dto.ProductDTO;
import com.genie.myapp.dto.SellerProductDTO;

public interface MbtiService {
	
	//상품목록 - MBTI 
	List<SellerProductDTO> getProduct(String mbti);
	//상품목록 - 가격낮은순
	List<SellerProductDTO> pricelist(String mbti);
	//상품목록 - 가격높은순
	List<SellerProductDTO> pricelistdesc(String mbti);
	//상품목록 - 최신순
	List<SellerProductDTO> recentlist(String mbti);
	//상품목록 - 좋아요순
	List<SellerProductDTO> likelist(String mbti);
	
	//상품목록(카테고리) - 가격낮은순
	List<ProductDTO> productPriceAsc(ProductDTO productDTO);
	//상품목록(카테고리) - 가격높은순
	List<ProductDTO> productPriceDesc(ProductDTO productDTO);
	//상품목록(카테고리) - 최신순
	List<ProductDTO> productRecent(ProductDTO productDTO);
	//상품목록(카테고리) - 좋아요순
	List<ProductDTO> productLike(ProductDTO productDTO);
}
