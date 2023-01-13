package com.genie.myapp.dao;

import java.util.List;

import com.genie.myapp.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.genie.myapp.dto.SellerProductDTO;

@Mapper
@Repository
public interface MbtiDAO {
	
	//상품목록 - MBTI 
	public List<SellerProductDTO> getProduct(String mbti);
	//상품목록MBTI - 가격낮은순
	public List<SellerProductDTO> pricelist(String mbti);
	//상품목록MBTI - 가격높은순
	public List<SellerProductDTO> pricelistdesc(String mbti);
	//상품목록MBTI - 최신순
	public List<SellerProductDTO> recentlist(String mbti);
	//상품목록MBTI - 좋아요순
	public List<SellerProductDTO> likelist(String mbti);
	
	//상품목록(카테고리) - 가격낮은순
	public List<ProductDTO> productPriceAsc(ProductDTO PDTO);
	//상품목록(카테고리) - 가격높은순
	public List<ProductDTO> productPriceDesc(ProductDTO PDTO);
	//상품목록(카테고리) - 최신순
	public List<ProductDTO> productRecent(ProductDTO PDTO);
	//상품목록(카테고리) - 좋아요순
	public List<ProductDTO> productLike(ProductDTO PDTO);
}
