package com.genie.myapp.service;

import java.util.List;

import com.genie.myapp.dto.*;


public interface AdminService {
	//카테고리리스트
	List<AdminDTO> adminCategoryTag(AdminDTO DTO);
	
	//태그리스트
	Object adminTag(AdminDTO adminDTO);
	
	// admin 내 태그정보 리스트
	List<AdminDTO> tagAllSelect();

	// adminTagPop 태그정보 뷰
	AdminDTO getadminTag(String productTagId);
	
	// adminTagPop 태그정보 수정
	void adminTagPopEdit(AdminDTO adminDTO);
	
	// adminTagPop 태그정보 뷰 삭제
	int adminTagDel(String productTagId);

	///////////카테고리//////////////
	// 카테고리 리스트
	List<AdminDTO> categoryAllSelect();
	
	// 카테고리 정보
	AdminDTO getadcategory(String categoryId);
	
	// 카테고리 수정
	void adcategoryPopEdit(AdminDTO adminDTO);
	
	// 카테고리 삭제
	int adcategoryDel(String categoryId);
	///////////카테고리//////////////

	// admember 내 유저정보 리스트
	List<UserDTO> userAllSelect(PagingDTO pagingDTO);
		
	// admemberPop 내 유저정보 뷰
	UserDTO getadmember(String user_id);

	// admemberPop 내 유저정보 수정
	void admemberPopEdit(UserDTO userDTO);
	
	// admember 내 유저정보 삭제
	int admemberDel(String genie_id);
	
	// adcompany 내 유저정보 리스트
	List<SellerDTO> sellerAllSelect(PagingDTO pagingDTO);
		
	// adcompanyPop 내 유저정보 뷰
	SellerDTO getadcompany(String userId);
	
	// adcompanyPop 내 유저정보 수정
	void adcompanyPopEdit(SellerDTO sellerDTO);
	
	// adcompany 내 유저정보 삭제
	int adcompanyDel(String genie_id);
	
	// adcompany 내 승인현황
	int sellerApproval(PagingDTO pagingDTO);

	// 결제관련
    void paymentWrite(CartDTO cartDTO);
    
	// 유저 총 레코드 수
	int userTotalRecord(PagingDTO pagingDTO);
		
	// 셀러 총 레코드 수
	int sellerTotalRecord(PagingDTO pagingDTO);

	// Test: 유저 총 레코드 수
	int mainTotalRecord(AdminDTO adminDTO);
	
	// //제품 관리
    // public Object getadminProduct(String product_id);
}
