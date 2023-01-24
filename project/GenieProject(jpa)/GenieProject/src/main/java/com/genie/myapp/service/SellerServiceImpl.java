package com.genie.myapp.service;

import java.util.List;
import java.util.Map;

import com.genie.myapp.dto.*;
import com.genie.myapp.entity.Account.Seller;
import com.genie.myapp.entity.Account.User;
import com.genie.myapp.repository.SellerServiceRepository;
import com.genie.myapp.repository.jpa.AccountRepository;
import com.genie.myapp.repository.jpa.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genie.myapp.dao.SellerDAO;

import javax.transaction.Transactional;

@Service
@Transactional
public class SellerServiceImpl implements SellerService {
	
	@Autowired SellerDAO dao;

	@Autowired AccountRepository accountRepository;
	@Autowired SellerRepository sellerRepository;
	@Autowired SellerServiceRepository repository;


  	@Override
	public int idCheck(String genie_id) {
		return dao.idCheck(genie_id);
	}

	@Override
	public SellerDTO loginOk(SellerDTO sellerDTO) {

		//DTO -> Entity
		Seller seller = SellerDTO.convertDTOtoEntity(sellerDTO);

		//Entity -> DTO
		return SellerDTO.convertEntityToDTO(repository.loginOk(seller));
	}

	@Override
	public void sellerWrite(SellerDTO sellerDTO) {
		Seller seller = SellerDTO.convertDTOtoEntity(sellerDTO);
		sellerRepository.save(seller);
	}

	@Override
	public int productWrite(SellerProductDTO vo) {
		return dao.productWrite(vo);
	}

	// 주문목록
	@Override
	public List<OrderDTO> sellerOrder(OrderDTO vo, String seller_id) {
		return dao.sellerOrder(vo, seller_id);
	}

	@Override
	public List<SellerProductDTO> productList(PagingDTO pDTO) {
		return dao.productList(pDTO);
	}
	
	@Override
	public SellerDTO getSeller(String genie_id) {
		return dao.getSeller(genie_id);
	}

	@Override
	public SellerProductDTO getProduct(int pid) {
		return dao.getProduct(pid);
	}

	@Override
	public int productEditOk(SellerProductDTO pvo) {
		return dao.productEditOk(pvo);
	}

	@Override
	public int productDel(int pid) {
		return dao.productDel(pid);
	}

	@Override
	public void updateDeliveryStatus(Map deliveryMap) {
		dao.updateDeliveryStatus(deliveryMap);
	}

	@Override
	public List<InquiryDTO> inquiryList(InquiryDTO vo, String Genie_id) {
		return dao.inquiryList(vo, Genie_id);
	}

	@Override
	public int orderSum(String seller_id) {
		return dao.orderSum(seller_id);
	}

	@Override
	public List<OrderDTO> orderSumByDay(String seller_id) {
		return dao.orderSumByDay(seller_id);
	}

	@Override
	public int orderCount(String seller_id) {
		return dao.orderCount(seller_id);
	}

	@Override
	public String bestSeller(String seller_id) {
		return dao.bestSeller(seller_id);
	}

	@Override
	public int deliveryPending(String seller_id) {
		return dao.deliveryPending(seller_id);
	}

	@Override
	public int todayOrder(String seller_id) {
		return dao.todayOrder(seller_id);
	}

	@Override
	public int deliveringOrder(String seller_id) {
		return dao.deliveringOrder(seller_id);
	}

	@Override
	public List<OrderDTO> revenueByProduct(String seller_id) {
		return dao.revenueByProduct(seller_id);
	}

	@Override
	public String sellerStatus(String seller_id) {
		return dao.sellerStatus(seller_id);
	}

	@Override
	public int thisMonthRevenue(String seller_id) {
		return dao.thisMonthRevenue(seller_id);
	}

	@Override
	public List<OrderDTO> topCategory(String seller_id) {
		return dao.topCategory(seller_id);
	}

	@Override
	public int productTotalRecord(PagingDTO pDTO) {
		return dao.productTotalRecord(pDTO);
	}

	@Override
	public List<OrderDTO> deliveredOrder(String seller_id) {
		return dao.deliveredOrder(seller_id);
	}

	

	

}
