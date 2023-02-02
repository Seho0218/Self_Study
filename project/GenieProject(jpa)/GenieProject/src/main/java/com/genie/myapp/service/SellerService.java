package com.genie.myapp.service;
import java.util.List;
import java.util.Map;

import com.genie.myapp.dto.*;


public interface SellerService {

	//아이디 중복검사
	int idCheck(String genie_id);

	//seller 회원가입
	void sellerWrite(SellerDTO sellerDTO);

	//이메일 중복검사
	long emailCheck(SellerDTO sellerDTO);

	//seller 상품등록
	void productWrite(SellerProductDTO sellerProductDTO);

	// 주문목록
	List<OrderDTO> sellerOrder(OrderDTO orderDTO, String sellerId);
	// 주문목록 배송상태 수정

	void updateDeliveryStatus(Map<String, String> deliveryMap);

	//상품관리 - 상품목록
	List<SellerProductDTO> productList(PagingDTO pagingDTO);

	//회원 선택: 로그인 한 회원
	SellerDTO getSeller(AccountDTO accountDTO);

	//상품선택 : 수정, 상품내용보기
	SellerProductDTO getProduct(int pid);

	//상품삭제
	int productDel(int pid);

	//상품수정
	void productEditOk(SellerProductDTO sellerProductDTO);

	//문의목록
	List<InquiryDTO> inquiryList(InquiryDTO inquiryDTO, String genie_id);

	// 매출관리 (결제금액)
	int orderSum(String sellerId);

	// 일별 매출관리
	List<OrderDTO> orderSumByDay(String sellerId);

	// 결제건수
	int orderCount(String sellerId);
	// 베스트셀러

	String bestSeller(String sellerId);


	// 배송 대기 중
	int deliveryPending(String sellerId);

	// 오늘 들어온 주문
	int todayOrder(String sellerId);
	// 배송 중

	int deliveringOrder(String sellerId);
	// 아이템별 매출

	List<OrderDTO> revenueByProduct(String sellerId);
	// 셀러 상태

	String sellerStatus(String sellerId);
	// 이번달 매출

	int thisMonthRevenue(String sellerId);
	// 카테고리별 판매건수

	List<OrderDTO> topCategory(String sellerId);
	//상품 총 레코드 수

	int productTotalRecord(PagingDTO pagingDTO);
	// 배송완료된 주문목록

	List<OrderDTO> deliveredOrder(String sellerId);
}