package com.genie.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genie.myapp.dao.AdminDAO;
import com.genie.myapp.vo.AdminVO;
import com.genie.myapp.vo.CartVO;
import com.genie.myapp.vo.PagingVO;
import com.genie.myapp.vo.ProductVO;
import com.genie.myapp.vo.SellerVO;
import com.genie.myapp.vo.UserVO;

@Service
public class AdminServiceImple implements AdminService {
	@Autowired
	AdminDAO dao;

	@Override
	public List<AdminVO> adminCategoryTag(AdminVO VO) {
		return dao.adminCategoryTag(VO);
	}

	@Override
	public List<AdminVO> adminTag(AdminVO VO) {
		return dao.adminTag(VO);
	}

	public List<UserVO> userAllSelect(PagingVO pVO) {
		return dao.userAllSelect(pVO);
	}

	@Override
	public UserVO getadmember(String user_id) {
		return dao.getadmember(user_id);
	}

	@Override
	public int admemberPopEdit(UserVO vo) {
		return dao.admemberPopEdit(vo);
	}

	@Override
	public int admemberDel(String genie_id) {
		return dao.admemberDel(genie_id);
	}
	
	@Override
	public int userTotalRecord(PagingVO pVO) {
		return dao.userTotalRecord(pVO);
	}

	@Override
	public List<AdminVO> tagAllSelect() {
		return dao.tagAllSelect();
	}

	@Override
	public AdminVO getadminTag(String product_tag_id) {
		return dao.getadminTag(product_tag_id);
	}

	@Override
	public int adminTagPopEdit(AdminVO vo) {
		return dao.adminTagPopEdit(vo);
	}

	@Override
	public int adminTagDel(String product_tag_id) {
		return dao.admemberDel(product_tag_id);
	}

	///////////////카테고리//////////////////
	@Override
	public List<AdminVO> categoryAllSelect() {
		return dao.categoryAllSelect();
	}

	@Override
	public AdminVO getadcategory(String category_id) {
		return dao.getadcategory(category_id);
	}

	@Override
	public int adcategoryPopEdit(AdminVO vo) {
		return dao.adcategoryPopEdit(vo);
	}

	@Override
	public int adcategoryDel(String category_id) {
		return dao.adcategoryDel(category_id);
	}
	///////////////카테고리//////////////////

	@Override

	public int paymentWrite(CartVO vo) {
		return dao.paymentWrite(vo);
	}

	public List<SellerVO> sellerAllSelect(PagingVO pVO) {
		return dao.sellerAllSelect(pVO);
	}

	@Override
	public SellerVO getadcompany(String user_id) {
		return dao.getadcompany(user_id);
	}

	@Override
	public int adcompanyPopEdit(SellerVO vo) {
		return dao.adcompanyPopEdit(vo);
	}

	@Override
	public int adcompanyDel(String genie_id) {
		return dao.adcompanyDel(genie_id);
	}

	@Override
	public int sellerTotalRecord(PagingVO pVO) {
		return dao.sellerTotalRecord(pVO);
	}

	@Override
	public int sellerApproval(PagingVO pVO) {
		return dao.sellerApproval(pVO);
	}

	@Override
	public int mainTotalRecord(AdminVO VO) {
		return dao.mainTotalRecord(VO);
	}

	//=============제품관리=============//

	// @Override
	// public AdminVO getadminProduct(String product_id) {
	// 	return dao.getadminProduct(product_id);
	// }

	//@Override
	//public int adminProductPopEdit(ProductVO vo) {
	//	return dao.adminProductPopEdit(vo);
	//}

	//@Override
	//public int adminProductDel(String product_id) {
	//	return dao.adminProductDel(product_id);
	//}
	//=============제품관리 끝 =============//
}
