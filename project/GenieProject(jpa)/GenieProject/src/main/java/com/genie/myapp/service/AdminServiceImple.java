package com.genie.myapp.service;

import java.util.List;

import com.genie.myapp.dto.AdminDTO;
import com.genie.myapp.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genie.myapp.dao.AdminDAO;
import com.genie.myapp.dto.CartDTO;
import com.genie.myapp.dto.PagingDTO;
import com.genie.myapp.dto.SellerDTO;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AdminServiceImple implements AdminService {

	@Autowired AdminDAO dao;

	@Override
	public List<AdminDTO> adminCategoryTag(AdminDTO VO) {
		return dao.adminCategoryTag(VO);
	}

	@Override
	public List<AdminDTO> adminTag(AdminDTO DTO) {
		return dao.adminTag(DTO);
	}

	public List<UserDTO> userAllSelect(PagingDTO pVO) {
		return dao.userAllSelect(pVO);
	}

	@Override
	public UserDTO getadmember(String user_id) {
		return dao.getadmember(user_id);
	}

	@Override
	public int admemberPopEdit(UserDTO vo) {
		return dao.admemberPopEdit(vo);
	}

	@Override
	public int admemberDel(String genie_id) {
		return dao.admemberDel(genie_id);
	}
	
	@Override
	public int userTotalRecord(PagingDTO pVO) {
		return dao.userTotalRecord(pVO);
	}

	@Override
	public List<AdminDTO> tagAllSelect() {
		return dao.tagAllSelect();
	}

	@Override
	public AdminDTO getadminTag(String product_tag_id) {
		return dao.getadminTag(product_tag_id);
	}

	@Override
	public int adminTagPopEdit(AdminDTO vo) {
		return dao.adminTagPopEdit(vo);
	}

	@Override
	public int adminTagDel(String product_tag_id) {
		return dao.admemberDel(product_tag_id);
	}

	///////////////카테고리//////////////////
	@Override
	public List<AdminDTO> categoryAllSelect() {
		return dao.categoryAllSelect();
	}

	@Override
	public AdminDTO getadcategory(String category_id) {
		return dao.getadcategory(category_id);
	}

	@Override
	public int adcategoryPopEdit(AdminDTO vo) {
		return dao.adcategoryPopEdit(vo);
	}

	@Override
	public int adcategoryDel(String category_id) {
		return dao.adcategoryDel(category_id);
	}
	///////////////카테고리//////////////////

	@Override

	public int paymentWrite(CartDTO vo) {
		return dao.paymentWrite(vo);
	}

	public List<SellerDTO> sellerAllSelect(PagingDTO pVO) {
		return dao.sellerAllSelect(pVO);
	}

	@Override
	public SellerDTO getadcompany(String user_id) {
		return dao.getadcompany(user_id);
	}

	@Override
	public int adcompanyPopEdit(SellerDTO vo) {
		return dao.adcompanyPopEdit(vo);
	}

	@Override
	public int adcompanyDel(String genie_id) {
		return dao.adcompanyDel(genie_id);
	}

	@Override
	public int sellerTotalRecord(PagingDTO pVO) {
		return dao.sellerTotalRecord(pVO);
	}

	@Override
	public int sellerApproval(PagingDTO pVO) {
		return dao.sellerApproval(pVO);
	}

	@Override
	public int mainTotalRecord(AdminDTO VO) {
		return dao.mainTotalRecord(VO);
	}

	//=============제품관리=============//

	// @Override
	// public AdminDTO getadminProduct(String product_id) {
	// 	return dao.getadminProduct(product_id);
	// }

	//@Override
	//public int adminProductPopEdit(ProductDTO vo) {
	//	return dao.adminProductPopEdit(vo);
	//}

	//@Override
	//public int adminProductDel(String product_id) {
	//	return dao.adminProductDel(product_id);
	//}
	//=============제품관리 끝 =============//
}
