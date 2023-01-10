package com.genie.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.genie.myapp.vo.AdminDTO;
import com.genie.myapp.vo.CartDTO;
import com.genie.myapp.vo.PagingDTO;
import com.genie.myapp.vo.SellerDTO;
import com.genie.myapp.vo.UserDTO;
//추상클래스 
@Mapper
@Repository
public interface AdminDAO {
	//카테고리리스트
	public List<AdminDTO> adminCategoryTag(AdminDTO VO);
	
	//태그리스트
	public List<AdminDTO> adminTag(AdminDTO VO);
	
	// adminTag 내 태그정보 리스트
	public List<AdminDTO> tagAllSelect();

	// adminTagPop 태그정보 뷰
	public AdminDTO getadminTag(String product_tag_id);
	
	// adminTagPop 태그정보 수정
	public int adminTagPopEdit(AdminDTO vo);
	
	// adminTagPop 태그정보 뷰 삭제
	public int adminTagDel(String product_tag_id);

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
	public List<UserDTO> userAllSelect(PagingDTO pVO);
	
	// admemberPop 내 유저정보 뷰
	public UserDTO getadmember(String user_id);
	
	// admemberPop 내 유저정보 수정
	public int admemberPopEdit(UserDTO vo);
	
	// admember 내 유저정보 삭제
	public int admemberDel(String genie_id);

	// 결제 관련 
    public int paymentWrite(CartDTO vo);

	// adcompany 내 유저정보 리스트
	public List<SellerDTO> sellerAllSelect(PagingDTO pVO);
		
	// adcompanyPop 내 유저정보 뷰
	public SellerDTO getadcompany(String user_id);
	
	// adcompanyPop 내 유저정보 수정
	public int adcompanyPopEdit(SellerDTO vo);
	
	// adcompany 내 유저정보 삭제
	public int adcompanyDel(String genie_id);
	
	// adcompany 내 승인현황
	public int sellerApproval(PagingDTO pVO);
	
	// 유저 총 레코드 수
	public int userTotalRecord(PagingDTO pVO);
	
	// 셀러 총 레코드 수
	public int sellerTotalRecord(PagingDTO pVO);

	// Test: 유저 총 수
	public int mainTotalRecord(AdminDTO VO);

	//제품 관리
    public Object getadminProduct(String product_id);
}
