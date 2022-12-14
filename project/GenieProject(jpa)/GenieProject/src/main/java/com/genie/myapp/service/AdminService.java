package com.genie.myapp.service;

import java.util.List;

import com.genie.myapp.dto.AdminDTO;
import com.genie.myapp.dto.CartDTO;
import com.genie.myapp.dto.PagingDTO;
import com.genie.myapp.dto.SellerDTO;
import com.genie.myapp.dto.UserDTO;

public interface AdminService {
	//카테고리리스트
	public List<AdminDTO> adminCategoryTag(AdminDTO dto);
	
	//태그리스트
	public Object adminTag(AdminDTO dto);
	
	// admin 내 태그정보 리스트
	public List<AdminDTO> tagAllSelect();

	// adminTagPop 태그정보 뷰
	public AdminDTO getadminTag(String product_tag_id);
	
	// adminTagPop 태그정보 수정
	public int adminTagPopEdit(AdminDTO dto);
	
	// adminTagPop 태그정보 뷰 삭제
	public int adminTagDel(String product_tag_id);

	///////////카테고리//////////////
	// 카테고리 리스트
	public List<AdminDTO> categoryAllSelect();
	
	// 카테고리 정보
	public AdminDTO getadcategory(String category_id);
	
	// 카테고리 수정
	public int adcategoryPopEdit(AdminDTO dto);
	
	// 카테고리 삭제
	public int adcategoryDel(String category_id);
	///////////카테고리//////////////

	// admember 내 유저정보 리스트
	public List<UserDTO> userAllSelect(PagingDTO pdto);
		
	// admemberPop 내 유저정보 뷰
	public UserDTO getadmember(String user_id);

	// admemberPop 내 유저정보 수정
	public int admemberPopEdit(UserDTO dto);
	
	// admember 내 유저정보 삭제
	public int admemberDel(String genie_id);
	
	// adcompany 내 유저정보 리스트
	public List<SellerDTO> sellerAllSelect(PagingDTO pdto);
		
	// adcompanyPop 내 유저정보 뷰
	public SellerDTO getadcompany(String user_id);
	
	// adcompanyPop 내 유저정보 수정
	public int adcompanyPopEdit(SellerDTO dto);
	
	// adcompany 내 유저정보 삭제
	public int adcompanyDel(String genie_id);
	
	// adcompany 내 승인현황
	public int sellerApproval(PagingDTO pdto);

	// 결제관련
    public int paymentWrite(CartDTO dto);
    
	// 유저 총 레코드 수
	public int userTotalRecord(PagingDTO pdto);
		
	// 셀러 총 레코드 수
	public int sellerTotalRecord(PagingDTO pdto);

	// Test: 유저 총 레코드 수
	public int mainTotalRecord(AdminDTO dto);
	
	// //제품 관리
    // public Object getadminProduct(String product_id);
}
