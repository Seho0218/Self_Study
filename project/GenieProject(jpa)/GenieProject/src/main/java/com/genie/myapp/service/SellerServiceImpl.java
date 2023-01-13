package com.genie.myapp.service;

import java.util.List;
import java.util.Map;

import com.genie.myapp.repository.SellerJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.genie.myapp.dto.SellerProductDTO;
import com.genie.myapp.dto.AccountDTO;
import com.genie.myapp.dto.InquiryDTO;
import com.genie.myapp.dto.OrderDTO;
import com.genie.myapp.dto.PagingDTO;
import com.genie.myapp.dto.SellerDTO;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class SellerServiceImpl implements SellerService {
	
	@Autowired
	SellerJpaRepository repository;

	@Autowired PasswordEncoder passwordEncoder;
  
// 주문목록
  @Override
	public List<OrderDTO> sellerOrder(OrderDTO dto, String seller_id) {
		return repository.sellerOrder(dto, seller_id);
	}

  @Override
	public int idCheck(String genie_id) {
		return repository.idCheck(genie_id);
	}

	@Override
	public int sellerWrite(SellerDTO dto) {
		String enPw=passwordEncoder.encode(dto.getGenie_pwd());
        dto.setGenie_pwd(enPw);
        return repository.sellerWrite(dto);
	}

	@Override
	public int productWrite(SellerProductDTO dto) {
		return repository.productWrite(dto);
	}

	@Override
	public int AccountWrite(AccountDTO adto) {
		return repository.AccountWrite(adto);
	}

	@Override
	public SellerDTO loginOk(SellerDTO sdto) {
		return repository.loginOk(sdto);
	}

	@Override
	public List<SellerProductDTO> productList(PagingDTO pdto) {
		return repository.productList(pdto);
	}
	
	@Override
	public SellerDTO getSeller(String genie_id) {
		return repository.getSeller(genie_id);
	}

	@Override
	public SellerProductDTO getProduct(int pid) {
		return repository.getProduct(pid);
	}

	@Override
	public int productEditOk(SellerProductDTO pdto) {
		return repository.productEditOk(pdto);
	}

	@Override
	public int productDel(int pid) {
		return repository.productDel(pid);
	}

	@Override
	public void updateDeliveryStatus(Map deliveryMap) {
		repository.updateDeliveryStatus(deliveryMap);
	}

	@Override
	public List<InquiryDTO> inquiryList(InquiryDTO dto, String Genie_id) {
		return repository.inquiryList(dto, Genie_id);
	}

	@Override
	public int orderSum(String seller_id) {
		return repository.orderSum(seller_id);
	}

	@Override
	public List<OrderDTO> orderSumByDay(String seller_id) {
		return repository.orderSumByDay(seller_id);
	}

	@Override
	public int orderCount(String seller_id) {
		return repository.orderCount(seller_id);
	}

	@Override
	public String bestSeller(String seller_id) {
		return repository.bestSeller(seller_id);
	}

	@Override
	public int deliveryPending(String seller_id) {
		return repository.deliveryPending(seller_id);
	}

	@Override
	public int todayOrder(String seller_id) {
		return repository.todayOrder(seller_id);
	}

	@Override
	public int deliveringOrder(String seller_id) {
		return repository.deliveringOrder(seller_id);
	}

	@Override
	public List<OrderDTO> revenueByProduct(String seller_id) {
		return repository.revenueByProduct(seller_id);
	}

	@Override
	public String sellerStatus(String seller_id) {
		return repository.sellerStatus(seller_id);
	}

	@Override
	public int thisMonthRevenue(String seller_id) {
		return repository.thisMonthRevenue(seller_id);
	}

	@Override
	public List<OrderDTO> topCategory(String seller_id) {
		return repository.topCategory(seller_id);
	}

	@Override
	public int productTotalRecord(PagingDTO pdto) {
		return repository.productTotalRecord(pdto);
	}

	@Override
	public List<OrderDTO> deliveredOrder(String seller_id) {
		return repository.deliveredOrder(seller_id);
	}

	

	

}
