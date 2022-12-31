package com.genie.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.genie.myapp.vo.ProductVO;
import com.genie.myapp.vo.SellerProductVO;

@Mapper
@Repository
public interface MbtiDAO {
	
	//상품목록 - MBTI 
	public List<SellerProductVO> getProduct(String mbti);
	//상품목록MBTI - 가격낮은순
	public List<SellerProductVO> pricelist(String mbti);
	//상품목록MBTI - 가격높은순
	public List<SellerProductVO> pricelistdesc(String mbti);
	//상품목록MBTI - 최신순
	public List<SellerProductVO> recentlist(String mbti);
	//상품목록MBTI - 좋아요순
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
