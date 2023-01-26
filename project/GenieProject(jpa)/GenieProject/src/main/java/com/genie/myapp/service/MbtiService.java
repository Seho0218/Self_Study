package com.genie.myapp.service;

import java.util.List;

import com.genie.myapp.dto.ProductDTO;
import com.genie.myapp.dto.SellerProductDTO;

public interface MbtiService {
	
	//상품목록 - MBTI 
	public List<SellerProductDTO> getProduct(String mbti);
	//상품목록 - 가격낮은순
	public List<SellerProductDTO> pricelist(String mbti);
	//상품목록 - 가격높은순
	public List<SellerProductDTO> pricelistdesc(String mbti);
	//상품목록 - 최신순
	public List<SellerProductDTO> recentlist(String mbti);
	//상품목록 - 좋아요순
	public List<SellerProductDTO> likelist(String mbti);
	
	//상품목록(카테고리) - 가격낮은순
	public List<ProductDTO> productPriceAsc(ProductDTO productDTO);
	//상품목록(카테고리) - 가격높은순
	public List<ProductDTO> productPriceDesc(ProductDTO productDTO);
	//상품목록(카테고리) - 최신순
	public List<ProductDTO> productRecent(ProductDTO productDTO);
	//상품목록(카테고리) - 좋아요순
	public List<ProductDTO> productLike(ProductDTO productDTO);
}
