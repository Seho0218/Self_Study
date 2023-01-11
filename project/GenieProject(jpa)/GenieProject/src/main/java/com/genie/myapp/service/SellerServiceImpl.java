package com.genie.myapp.service;

import java.util.List;
import java.util.Map;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.genie.myapp.dao.SellerDAO;

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
	
	@Autowired SellerDAO dao;

	@Autowired PasswordEncoder passwordEncoder;
  
// 주문목록
  @Override
	public List<OrderDTO> sellerOrder(OrderDTO dto, String seller_id) {
		return dao.sellerOrder(dto, seller_id);
	}

  @Override
	public int idCheck(String genie_id) {
		return dao.idCheck(genie_id);
	}

	@Override
	public int sellerWrite(SellerDTO dto) {
		String enPw=passwordEncoder.encode(dto.getGenie_pwd());
        dto.setGenie_pwd(enPw);
        return dao.sellerWrite(dto);
	}

	@Override
	public int productWrite(SellerProductDTO dto) {
		return dao.productWrite(dto);
	}

	@Override
	public int AccountWrite(AccountDTO adto) {
		return dao.AccountWrite(adto);
	}

	@Override
	public SellerDTO loginOk(SellerDTO sdto) {
		return dao.loginOk(sdto);
	}

	@Override
	public List<SellerProductDTO> productList(PagingDTO pdto) {
		return dao.productList(pdto);
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
	public int productEditOk(SellerProductDTO pdto) {
		return dao.productEditOk(pdto);
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
	public List<InquiryDTO> inquiryList(InquiryDTO dto, String Genie_id) {
		return dao.inquiryList(dto, Genie_id);
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
	public int productTotalRecord(PagingDTO pdto) {
		return dao.productTotalRecord(pdto);
	}

	@Override
	public List<OrderDTO> deliveredOrder(String seller_id) {
		return dao.deliveredOrder(seller_id);
	}

	

	

}
