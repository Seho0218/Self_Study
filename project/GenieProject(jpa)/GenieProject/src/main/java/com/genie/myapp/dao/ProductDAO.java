package com.genie.myapp.dao;

import java.util.List;
import java.util.Map;

import com.genie.myapp.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ProductDAO {

    // 상품정보리스트에서 상품정보 가져오기
    public List<ProductDTO> listProduct(ProductDTO pDTO);

    // 제품 상세정보(구매페이지)
    public ProductDTO getProduct(int no);

    // 메인페이지 페이징
    public List<ProductDTO> mainAllSelect(PagingDTO pDTO);

    // 상세페이지 좋아요 수 가져오기
    public ProductDTO likeStatus(int product_id);

    // 조회수 증가
    public void hitCount(int product_id);

    // 지니페이지 제품 선택
    public List<ProductDTO> selectProduct(Map<String, Object> map);

    // 상세페이지 관리자정보 가져오기
    public SellerDTO getSeller(int product_id);

    // 장바구니 가져오기(상품포함)
    public List<CartDTO> getCart(String userDTO);

    // 장바구니 상품 넣기
    public int addCart(CartDTO cvo);

    // 장바구니 제품 삭제
    public int delCart(int cart_num, String genie_id);

    // 여러 제품 삭제
    public int delMultiCart(CartDTO cvo);

    // 장바구니 정보 업데이트
    public int updateCart(CartDTO cvo);

    // 상세페이지 logid 좋아요 확인
    public LikeDTO likeCheck(int product_id, String genie_id);
    
    // index 페이지 상품+회사명 리스트
    public List<ProductDTO> companyName(ProductDTO pDTO);

}