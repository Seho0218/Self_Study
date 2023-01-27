package com.genie.myapp.dao;

import java.util.List;

import com.genie.myapp.dto.AdminDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.genie.myapp.dto.CartDTO;
import com.genie.myapp.dto.PagingDTO;
import com.genie.myapp.dto.SellerDTO;
import com.genie.myapp.dto.UserDTO;
//추상클래스
@Mapper
@Repository
public interface AdminDAO {
	//카테고리리스트
	public List<AdminDTO> adminCategoryTag(AdminDTO DTO);

	//태그리스트
	public List<AdminDTO> adminTag(AdminDTO DTO);

	// adminTag 내 태그정보 리스트
	public List<AdminDTO> tagAllSelect();

	// adminTagPop 태그정보 뷰
	public AdminDTO getadminTag(String productTagId);

	// adminTagPop 태그정보 수정
	public int adminTagPopEdit(AdminDTO vo);

	// adminTagPop 태그정보 뷰 삭제
	public int adminTagDel(String productTagId);

	///////////카테고리//////////////
	// 카테고리 리스트
	public List<AdminDTO> categoryAllSelect();

	// 카테고리 정보
	public AdminDTO getadcategory(String category_id);

	// 카테고리 수정
	public int adcategoryPopEdit(AdminDTO vo);

	// 카테고리 삭제
	public int adcategoryDel(String category_id);
	///////////카테고리//////////////

	// admember 내 유저정보 리스트
	public List<UserDTO> userAllSelect(PagingDTO pDTO);

	// admemberPop 내 유저정보 뷰
	public UserDTO getadmember(String user_id);

	// admemberPop 내 유저정보 수정
	public int admemberPopEdit(UserDTO vo);

	// admember 내 유저정보 삭제
	public int admemberDel(String genie_id);

	// 결제 관련
    public int paymentWrite(CartDTO vo);

	// adcompany 내 유저정보 리스트
	public List<SellerDTO> sellerAllSelect(PagingDTO pDTO);

	// adcompanyPop 내 유저정보 뷰
	public SellerDTO getadcompany(String user_id);

	// adcompanyPop 내 유저정보 수정
	public int adcompanyPopEdit(SellerDTO vo);

	// adcompany 내 유저정보 삭제
	public int adcompanyDel(String genie_id);

	// adcompany 내 승인현황
	public int sellerApproval(PagingDTO pDTO);

	// 유저 총 레코드 수
	public int userTotalRecord(PagingDTO pDTO);

	// 셀러 총 레코드 수
	public int sellerTotalRecord(PagingDTO pDTO);

	// Test: 유저 총 수
	public int mainTotalRecord(AdminDTO DTO);

	//제품 관리
    public Object getadminProduct(String productId);
}
