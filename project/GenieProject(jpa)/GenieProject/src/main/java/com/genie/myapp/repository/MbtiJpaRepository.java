package com.genie.myapp.repository;

import com.genie.myapp.dto.ProductDTO;

import com.genie.myapp.entity.Product.Product;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.genie.myapp.entity.Account.QSeller.*;
import static com.genie.myapp.entity.Product.QProduct.*;
import static org.springframework.util.StringUtils.hasText;

@Repository
@RequiredArgsConstructor
public class MbtiJpaRepository {

    private final JPAQueryFactory queryFactory;

    //상품목록 - MBTI
    public List<Product> getProduct(String mbti){
        return queryFactory
                .selectFrom(product)
                .join(seller.genie_id).on()
                .where(
                        product.product_mbti.eq(mbti)
                )
                .orderBy(product.product_price.desc())
                .fetch();
    }

    //상품목록MBTI - 가격낮은순
    public List<Product> pricelist(String mbti){
        return queryFactory
                .selectFrom(product)
                .join(seller.genie_id)
                .where(
                        product.product_mbti.eq(mbti)
                )
                .orderBy(product.product_price.asc())
                .fetch();
    }

    //상품목록MBTI - 가격높은순
    public List<Product> pricelistdesc(String mbti){
        return queryFactory
                .selectFrom(product)
                .join(seller.genie_id)
                .where(
                        product.product_mbti.eq(mbti)
                )
                .orderBy(product.product_price.desc())
                .fetch();
    }



    //상품목록MBTI - 최신순
    public List<Product> recentlist(String mbti){
        return queryFactory
                .selectFrom(product)
                .join(seller.genie_id)
                .where(
                        product.product_mbti.eq(mbti)
                )
                .orderBy(product.product_writedate.desc())
                .fetch();
    }


    //상품목록MBTI - 좋아요순
    public List<Product> likelist(String mbti){
        return queryFactory
                .selectFrom(product)
                .join(seller.genie_id)
                .where(
                        product.product_mbti.eq(mbti)
                )
                .orderBy(product.product_hit.desc())
                .fetch();
    }




    //상품목록(카테고리) - 가격낮은순
    public List<Product> productPriceAsc(ProductDTO pdto) {
        return queryFactory
                .selectFrom(product)
                .join(seller.genie_id)
                .where(
                        product_category(pdto.getProduct_category()),
                        product_tag(pdto.getProduct_tag())
                )
                .orderBy(product.product_price.asc())
                .fetch();
    }

    //상품목록(카테고리) - 가격높은순
    public List<Product> productPriceDesc(ProductDTO pdto) {
        return queryFactory
                .selectFrom(product)
                .join(seller.genie_id)
                .where(
                        product_category(pdto.getProduct_category()),
                        product_tag(pdto.getProduct_tag())
                )
                .orderBy(product.product_price.desc())
                .fetch();
    }

    //상품목록(카테고리) - 최신순
    public List<Product> productRecent(ProductDTO pdto) {
        return queryFactory
                .selectFrom(product)
                .join(seller.genie_id)
                .where(
                        product_category(pdto.getProduct_category()),
                        product_tag(pdto.getProduct_tag())
                )
                .orderBy(product.product_writedate.desc())
                .fetch();
    }

    //상품목록(카테고리) - 좋아요순
    public List<Product> productLike(ProductDTO pdto) {
        return queryFactory
                .selectFrom(product)
                .join(seller.genie_id)
                .where(
                        product_category(pdto.getProduct_category()),
                        product_tag(pdto.getProduct_tag())
                )
                .orderBy(product.product_like.like_num.desc(),
                         product.product_hit.desc())
                .fetch();
    }

    private BooleanExpression product_category(String product_category) {
        return hasText(product_category) ? product.product_category.eq(product_category) : null;
    }
    
    private BooleanExpression product_tag(String product_tag) {
        return hasText(product_tag) ? product.product_tag.eq(product_tag) : null;
    }
    
}
