package com.genie.myapp.service;

import java.util.List;

import com.genie.myapp.vo.ProductVO;
import com.genie.myapp.vo.SellerProductVO;

public interface MbtiService {
	
	//상품목록 - MBTI 
	public List<SellerProductVO> getProduct(String mbti);
	//상품목록 - 가격낮은순
	public List<SellerProductVO> pricelist(String mbti);
	//상품목록 - 가격높은순
	public List<SellerProductVO> pricelistdesc(String mbti);
	//상품목록 - 최신순
	public List<SellerProductVO> recentlist(String mbti);
	//상품목록 - 좋아요순
	public List<SellerProductVO> likelist(String mbti);
	
	//상품목록(카테고리) - 가격낮은순
	public List<ProductVO> productPriceAsc(ProductVO PVO);
	//상품목록(카테고리) - 가격높은순
	public List<ProductVO> productPriceDesc(ProductVO PVO);
	//상품목록(카테고리) - 최신순
	public List<ProductVO> productRecent(ProductVO PVO);
	//상품목록(카테고리) - 좋아요순
	public List<ProductVO> productLike(ProductVO PVO);
}
