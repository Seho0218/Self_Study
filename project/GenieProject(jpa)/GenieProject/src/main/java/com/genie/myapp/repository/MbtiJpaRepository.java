package com.genie.myapp.repository;

import com.genie.myapp.dto.ProductDTO;
import com.genie.myapp.dto.SellerProductDTO;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MbtiJpaRepository {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

//    //상품목록 - MBTI
//    public List<SellerProductDTO> getProduct(String mbti);
//    //상품목록MBTI - 가격낮은순
//    public List<SellerProductDTO> pricelist(String mbti);
//    //상품목록MBTI - 가격높은순
//    public List<SellerProductDTO> pricelistdesc(String mbti);
//    //상품목록MBTI - 최신순
//    public List<SellerProductDTO> recentlist(String mbti);
//    //상품목록MBTI - 좋아요순
//    public List<SellerProductDTO> likelist(String mbti);
//
//    //상품목록(카테고리) - 가격낮은순
//    public List<ProductDTO> productPriceAsc(ProductDTO PVO);
//    //상품목록(카테고리) - 가격높은순
//    public List<ProductDTO> productPriceDesc(ProductDTO PVO);
//    //상품목록(카테고리) - 최신순
//    public List<ProductDTO> productRecent(ProductDTO PVO);
//    //상품목록(카테고리) - 좋아요순
//    public List<ProductDTO> productLike(ProductDTO PVO);
}
