package com.genie.myapp.service;

import java.util.List;
import java.util.Map;

import com.genie.myapp.dto.InquiryDTO;
import com.genie.myapp.dto.OrderDTO;
import com.genie.myapp.dto.PagingDTO;
import com.genie.myapp.dto.SellerProductDTO;
import com.genie.myapp.dto.SellerDTO;


public interface SellerService {

	//아이디 중복검사
	public int idCheck(String genie_id);

	//seller 회원가입
	public void sellerWrite(SellerDTO seller);

	//seller 상품등록
	public int productWrite(SellerProductDTO sellerProductDTO);
	// 주문목록
	public List<OrderDTO> sellerOrder(OrderDTO orderDTO, String sellerId);
	// 주문목록 배송상태 수정

	public void updateDeliveryStatus(Map deliveryMap);
	//판매자 로그인
	public SellerDTO loginOk(SellerDTO sellerDTO);
	//상품관리 - 상품목록
	public List<SellerProductDTO> productList(PagingDTO pagingDTO);
	//회원 선택: 로그인 한 회원
	public SellerDTO getSeller(String genie_id);
	//상품선택 : 수정, 상품내용보기
	public SellerProductDTO getProduct(int pid);
	//상품삭제
	public int productDel(int pid);
	//상품수정
	public int productEditOk(SellerProductDTO sellerProductDTO);
	//문의목록
	public List<InquiryDTO> inquiryList(InquiryDTO inquiryDTO, String genie_id);
	// 매출관리 (결제금액)
	public int orderSum(String sellerId);
	// 일별 매출관리
	public List<OrderDTO> orderSumByDay(String sellerId);
	// 결제건수
	public int orderCount(String sellerId);
	// 베스트셀러

	public String bestSeller(String sellerId);


	// 배송 대기 중
	public int deliveryPending(String sellerId);
	// 오늘 들어온 주문
	public int todayOrder(String sellerId);
	// 배송 중

    public int deliveringOrder(String sellerId);
	// 아이템별 매출

	public List<OrderDTO> revenueByProduct(String sellerId);
	// 셀러 상태

	public String sellerStatus(String sellerId);
	// 이번달 매출

    public int thisMonthRevenue(String sellerId);
	// 카테고리별 판매건수

	public List<OrderDTO> topCategory(String sellerId);
	//상품 총 레코드 수

	public int productTotalRecord(PagingDTO pagingDTO);
	// 배송완료된 주문목록

	public List<OrderDTO> deliveredOrder(String sellerId);
}
