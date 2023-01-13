package com.genie.myapp.service;

import java.util.List;

import com.genie.myapp.dto.ProductDTO;
import com.genie.myapp.entity.Product.Product;

public interface MbtiService {
	
	//상품목록 - MBTI 
	public List<Product> getProduct(String mbti);
	//상품목록 - 가격낮은순
	public List<Product> pricelist(String mbti);
	//상품목록 - 가격높은순
	public List<Product> pricelistdesc(String mbti);
	//상품목록 - 최신순
	public List<Product> recentlist(String mbti);
	//상품목록 - 좋아요순
	public List<Product> likelist(String mbti);
	
	//상품목록(카테고리) - 가격낮은순
	public List<Product> productPriceAsc(ProductDTO PVO);
	//상품목록(카테고리) - 가격높은순
	public List<ProductDTO> productPriceDesc(ProductDTO PVO);
	//상품목록(카테고리) - 최신순
	public List<Product> productRecent(ProductDTO PVO);
	//상품목록(카테고리) - 좋아요순
	public List<Product> productLike(ProductDTO PVO);
}
