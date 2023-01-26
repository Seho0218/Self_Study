package com.genie.myapp.service;

import java.util.List;

import com.genie.myapp.dto.*;


public interface AdminService {
	//카테고리리스트
	public List<AdminDTO> adminCategoryTag(AdminDTO DTO);
	
	//태그리스트
	public Object adminTag(AdminDTO adminDTO);
	
	// admin 내 태그정보 리스트
	public List<AdminDTO> tagAllSelect();

	// adminTagPop 태그정보 뷰
	public AdminDTO getadminTag(String productTagId);
	
	// adminTagPop 태그정보 수정
	public int adminTagPopEdit(AdminDTO adminDTO);
	
	// adminTagPop 태그정보 뷰 삭제
	public int adminTagDel(String productTagId);

	///////////카테고리//////////////
	// 카테고리 리스트
	public List<AdminDTO> categoryAllSelect();
	
	// 카테고리 정보
	public AdminDTO getadcategory(String categoryId);
	
	// 카테고리 수정
	public int adcategoryPopEdit(AdminDTO adminDTO);
	
	// 카테고리 삭제
	public int adcategoryDel(String categoryId);
	///////////카테고리//////////////

	// admember 내 유저정보 리스트
	public List<UserDTO> userAllSelect(PagingDTO pagingDTO);
		
	// admemberPop 내 유저정보 뷰
	public UserDTO getadmember(String user_id);

	// admemberPop 내 유저정보 수정
	public int admemberPopEdit(UserDTO userDTO);
	
	// admember 내 유저정보 삭제
	public int admemberDel(String genieId);
	
	// adcompany 내 유저정보 리스트
	public List<SellerDTO> sellerAllSelect(PagingDTO pagingDTO);
		
	// adcompanyPop 내 유저정보 뷰
	public SellerDTO getadcompany(String userId);
	
	// adcompanyPop 내 유저정보 수정
	public int adcompanyPopEdit(SellerDTO sellerDTO);
	
	// adcompany 내 유저정보 삭제
	public int adcompanyDel(String genieId);
	
	// adcompany 내 승인현황
	public int sellerApproval(PagingDTO pagingDTO);

	// 결제관련
    public int paymentWrite(CartDTO cartDTO);
    
	// 유저 총 레코드 수
	public int userTotalRecord(PagingDTO pagingDTO);
		
	// 셀러 총 레코드 수
	public int sellerTotalRecord(PagingDTO pagingDTO);

	// Test: 유저 총 레코드 수
	public int mainTotalRecord(AdminDTO adminDTO);
	
	// //제품 관리
    // public Object getadminProduct(String product_id);
}
