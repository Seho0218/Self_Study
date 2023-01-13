package com.genie.myapp.service;

import java.util.List;

import com.genie.myapp.dto.AdminDTO;
import com.genie.myapp.dto.UserDTO;
import com.genie.myapp.repository.AdminJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genie.myapp.dto.CartDTO;
import com.genie.myapp.dto.PagingDTO;
import com.genie.myapp.dto.SellerDTO;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AdminServiceImple implements AdminService {

	@Autowired AdminJpaRepository repository;

	@Override
	public List<AdminDTO> adminCategoryTag(AdminDTO dto) {
		return repository.adminCategoryTag(dto);
	}

	@Override
	public List<AdminDTO> adminTag(AdminDTO DTO) {
		return repository.adminTag(DTO);
	}

	public List<UserDTO> userAllSelect(PagingDTO pdto) {
		return repository.userAllSelect(pdto);
	}

	@Override
	public UserDTO getadmember(String user_id) {
		return repository.getadmember(user_id);
	}

	@Override
	public int admemberPopEdit(UserDTO dto) {
		return repository.admemberPopEdit(dto);
	}

	@Override
	public int admemberDel(String genie_id) {
		return repository.admemberDel(genie_id);
	}
	
	@Override
	public int userTotalRecord(PagingDTO pdto) {
		return repository.userTotalRecord(pdto);
	}

	@Override
	public List<AdminDTO> tagAllSelect() {
		return repository.tagAllSelect();
	}

	@Override
	public AdminDTO getadminTag(String product_tag_id) {
		return repository.getadminTag(product_tag_id);
	}

	@Override
	public int adminTagPopEdit(AdminDTO dto) {
		return repository.adminTagPopEdit(dto);
	}

	@Override
	public int adminTagDel(String product_tag_id) {
		return repository.admemberDel(product_tag_id);
	}

	///////////////카테고리//////////////////
	@Override
	public List<AdminDTO> categoryAllSelect() {
		return repository.categoryAllSelect();
	}

	@Override
	public AdminDTO getadcategory(String category_id) {
		return repository.getadcategory(category_id);
	}

	@Override
	public int adcategoryPopEdit(AdminDTO dto) {
		return repository.adcategoryPopEdit(dto);
	}

	@Override
	public int adcategoryDel(String category_id) {
		return repository.adcategoryDel(category_id);
	}
	///////////////카테고리//////////////////

	@Override

	public int paymentWrite(CartDTO dto) {
		return repository.paymentWrite(dto);
	}

	public List<SellerDTO> sellerAllSelect(PagingDTO pdto) {
		return repository.sellerAllSelect(pdto);
	}

	@Override
	public SellerDTO getadcompany(String user_id) {
		return repository.getadcompany(user_id);
	}

	@Override
	public int adcompanyPopEdit(SellerDTO dto) {
		return repository.adcompanyPopEdit(dto);
	}

	@Override
	public int adcompanyDel(String genie_id) {
		return repository.adcompanyDel(genie_id);
	}

	@Override
	public int sellerTotalRecord(PagingDTO pdto) {
		return repository.sellerTotalRecord(pdto);
	}

	@Override
	public int sellerApproval(PagingDTO pdto) {
		return repository.sellerApproval(pdto);
	}

	@Override
	public int mainTotalRecord(AdminDTO dto) {
		return repository.mainTotalRecord(dto);
	}

	//=============제품관리=============//

	// @Override
	// public AdminDTO getadminProduct(String product_id) {
	// 	return dao.getadminProduct(product_id);
	// }

	//@Override
	//public int adminProductPopEdit(ProductDTO dto) {
	//	return dao.adminProductPopEdit(dto);
	//}

	//@Override
	//public int adminProductDel(String product_id) {
	//	return dao.adminProductDel(product_id);
	//}
	//=============제품관리 끝 =============//
}
