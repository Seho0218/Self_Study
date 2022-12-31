package com.genie.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.genie.myapp.vo.AdminVO;
import com.genie.myapp.vo.CartVO;
import com.genie.myapp.vo.PagingVO;
import com.genie.myapp.vo.SellerVO;
import com.genie.myapp.vo.UserVO;
//추상클래스 
@Mapper
@Repository
public interface AdminDAO {
	//카테고리리스트
	public List<AdminVO> adminCategoryTag(AdminVO VO);
	
	//태그리스트
	public List<AdminVO> adminTag(AdminVO VO);
	
	// adminTag 내 태그정보 리스트
	public List<AdminVO> tagAllSelect();

	// adminTagPop 태그정보 뷰
	public AdminVO getadminTag(String product_tag_id);
	
	// adminTagPop 태그정보 수정
	public int adminTagPopEdit(AdminVO vo);
	
	// adminTagPop 태그정보 뷰 삭제
	public int adminTagDel(String product_tag_id);

	///////////카테고리//////////////
	// 카테고리 리스트
	public List<AdminVO> categoryAllSelect();
	
	// 카테고리 정보
	public AdminVO getadcategory(String category_id);
	
	// 카테고리 수정
	public int adcategoryPopEdit(AdminVO vo);
	
	// 카테고리 삭제
	public int adcategoryDel(String category_id);
	///////////카테고리//////////////

	// admember 내 유저정보 리스트
	public List<UserVO> userAllSelect(PagingVO pVO);
	
	// admemberPop 내 유저정보 뷰
	public UserVO getadmember(String user_id);
	
	// admemberPop 내 유저정보 수정
	public int admemberPopEdit(UserVO vo);
	
	// admember 내 유저정보 삭제
	public int admemberDel(String genie_id);

	// 결제 관련 
    public int paymentWrite(CartVO vo);

	// adcompany 내 유저정보 리스트
	public List<SellerVO> sellerAllSelect(PagingVO pVO);
		
	// adcompanyPop 내 유저정보 뷰
	public SellerVO getadcompany(String user_id);
	
	// adcompanyPop 내 유저정보 수정
	public int adcompanyPopEdit(SellerVO vo);
	
	// adcompany 내 유저정보 삭제
	public int adcompanyDel(String genie_id);
	
	// adcompany 내 승인현황
	public int sellerApproval(PagingVO pVO);
	
	// 유저 총 레코드 수
	public int userTotalRecord(PagingVO pVO);
	
	// 셀러 총 레코드 수
	public int sellerTotalRecord(PagingVO pVO);

	// Test: 유저 총 수
	public int mainTotalRecord(AdminVO VO);

	//제품 관리
    public Object getadminProduct(String product_id);
}
