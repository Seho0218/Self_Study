package com.genie.myapp.service;

import java.util.List;

import com.genie.myapp.dto.AdminDTO;
import com.genie.myapp.repository.AdminServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genie.myapp.dao.AdminDAO;
import com.genie.myapp.dto.CartDTO;
import com.genie.myapp.dto.PagingDTO;
import com.genie.myapp.dto.SellerDTO;
import com.genie.myapp.dto.UserDTO;

import javax.transaction.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired AdminDAO dao;
	@Autowired AdminServiceRepository repository;

	@Override
	public List<AdminDTO> adminCategoryTag(AdminDTO DTO) {
		return dao.adminCategoryTag(DTO);
	}

	@Override
	public List<AdminDTO> adminTag(AdminDTO dto) {
		return dao.adminTag(dto);
	}

	@Override
	public List<UserDTO> userAllSelect(PagingDTO pDTO) {
		return dao.userAllSelect(pDTO);
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
	public int userTotalRecord(PagingDTO pDTO) {
		return dao.userTotalRecord(pDTO);
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

	@Override
	public List<SellerDTO> sellerAllSelect(PagingDTO pDTO) {
		return dao.sellerAllSelect(pDTO);
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
	public int sellerTotalRecord(PagingDTO pDTO) {
		return dao.sellerTotalRecord(pDTO);
	}

	@Override
	public int sellerApproval(PagingDTO pDTO) {
		return dao.sellerApproval(pDTO);
	}

	@Override
	public int mainTotalRecord(AdminDTO DTO) {
		return dao.mainTotalRecord(DTO);
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
