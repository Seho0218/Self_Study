package com.genie.myapp.service;

import com.genie.myapp.dto.*;

import java.util.List;
import java.util.Map;



public interface ProductService {

  // 상품정보리스트에서 상품정보 가져오기
  List<ProductDTO> listProduct(ProductDTO productDTO);

  // 제품 상세정보(구매페이지)
  ProductDTO getProduct(ProductDTO productDTO);

  // 메인페이지 페이징
  List<ProductDTO> mainAllSelect(PagingDTO productDTO);

  // 상세페이지 좋아요 수 가져오기
  ProductDTO likeStatus(ProductDTO productDTO);

  // 조회수 증가
  void hitCount(ProductDTO productDTO);

  // 지니페이지 제품 선택
  List<ProductDTO> selectProduct(Map<String, Object> map);

  // 상세페이지 관리자정보 가져오기
  SellerDTO getSeller(ProductDTO productDTO);



  // 장바구니 가져오기(상품포함)
  List<CartDTO> getCart(UserDTO userDTO);

  // 장바구니 상품 넣기
  void addCart(CartDTO cartDTO);

  // 장바구니 제품 삭제
  void delCart(CartDTO cartDTO);

  // 여러 제품 삭제
  void delMultiCart(CartDTO cartDTO);

  // 장바구니 정보 업데이트
  void updateCart(CartDTO cartDTO);



  // 상세페이지 logid 좋아요 확인
  LikeDTO likeCheck(ProductDTO productDTO, String genie_id);

  // index 페이지 상품+회사명 리스트
  List<ProductDTO> companyName(ProductDTO productDTO);

}