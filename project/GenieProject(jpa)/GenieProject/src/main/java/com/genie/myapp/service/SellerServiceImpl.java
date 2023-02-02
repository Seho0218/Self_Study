package com.genie.myapp.service;

import java.util.List;
import java.util.Map;

import com.genie.myapp.dto.*;
import com.genie.myapp.entity.Account.Seller;
import com.genie.myapp.repository.SellerServiceRepository;
import com.genie.myapp.repository.jpa.AccountRepository;
import com.genie.myapp.repository.jpa.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.genie.myapp.dao.SellerDAO;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SellerServiceImpl implements SellerService {
	
	public final SellerDAO dao;

	public final AccountRepository accountRepository;
	public final SellerRepository sellerRepository;
	public final SellerServiceRepository repository;

	public final PasswordEncoder passwordEncoder;


  	@Override
	public int idCheck(String genie_id) {
		return dao.idCheck(genie_id);
	}

	@Override
	public long emailCheck(SellerDTO sellerDTO) {
		return repository.emailCheck(sellerDTO);
	}

	@Override
	public void sellerWrite(SellerDTO sellerDTO) {

		sellerDTO.setGeniePwd(passwordEncoder.encode(sellerDTO.getGeniePwd()));
		Seller seller = SellerDTO.convertDTOtoEntity(sellerDTO);
		sellerRepository.save(seller);
	}

	@Override
	public void productWrite(SellerProductDTO sellerProductDTO) {
        dao.productWrite(sellerProductDTO);
    }

	// 주문목록
	@Override
	public List<OrderDTO> sellerOrder(OrderDTO orderDTO, String sellerId) {
		return dao.sellerOrder(orderDTO, sellerId);
	}

	@Override
	public List<SellerProductDTO> productList(PagingDTO pDTO) {
		return dao.productList(pDTO);
	}
	
	@Override
	public SellerDTO getSeller(AccountDTO accountDTO) {
		return dao.getSeller(accountDTO.getGenieId());
	}

	@Override
	public SellerProductDTO getProduct(int pid) {
		return dao.getProduct(pid);
	}

	@Override
	public void productEditOk(SellerProductDTO pvo) {
		dao.productEditOk(pvo);
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
	public int orderSum(String sellerId) {
		return dao.orderSum(sellerId);
	}

	@Override
	public List<OrderDTO> orderSumByDay(String sellerId) {
		return dao.orderSumByDay(sellerId);
	}

	@Override
	public int orderCount(String sellerId) {
		return dao.orderCount(sellerId);
	}

	@Override
	public String bestSeller(String sellerId) {
		return dao.bestSeller(sellerId);
	}

	@Override
	public int deliveryPending(String sellerId) {
		return dao.deliveryPending(sellerId);
	}

	@Override
	public int todayOrder(String sellerId) {
		return dao.todayOrder(sellerId);
	}

	@Override
	public int deliveringOrder(String sellerId) {
		return dao.deliveringOrder(sellerId);
	}

	@Override
	public List<OrderDTO> revenueByProduct(String sellerId) {
		return dao.revenueByProduct(sellerId);
	}

	@Override
	public String sellerStatus(String sellerId) {
		return dao.sellerStatus(sellerId);
	}

	@Override
	public int thisMonthRevenue(String sellerId) {
		return dao.thisMonthRevenue(sellerId);
	}

	@Override
	public List<OrderDTO> topCategory(String sellerId) {
		return dao.topCategory(sellerId);
	}

	@Override
	public int productTotalRecord(PagingDTO pDTO) {
		return dao.productTotalRecord(pDTO);
	}

	@Override
	public List<OrderDTO> deliveredOrder(String sellerId) {
		return dao.deliveredOrder(sellerId);
	}

	

	

}
