package com.genie.myapp.controller;

import java.nio.charset.Charset;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.genie.myapp.service.OrderService;
import com.genie.myapp.service.ProductService;
import com.genie.myapp.service.UserService;
import com.genie.myapp.dto.CartDTO;
import com.genie.myapp.dto.OrderDTO;

@RestController
@RequestMapping("/order/*")
public class OrderController {

	@Autowired
	UserService userService;

	@Autowired
	ProductService productService;

	@Autowired
	OrderService orderService;

    @Autowired
	PlatformTransactionManager transactionManager;
	
	@Autowired
	TransactionDefinition definition;
	
	TransactionStatus status;
	
	ModelAndView mav = null;

    // --------------------------------------------상품
	// 결제페이지-----------------------------------------------------
	// 바로 주문
	@PostMapping("BuyNow")
	public ModelAndView BuyNow(HttpSession session, CartDTO cdto) {
		
		String genie_id=(String)session.getAttribute("logId");
		//System.out.println("BuyNow로 받아온 cdto : "+cdto.toString());

		mav=new ModelAndView();
		mav.addObject("bdto",cdto);
		mav.addObject("udto", userService.getUser(genie_id));
		mav.setViewName("/order/payment");

		return mav;
	}
	// 장바구니에서 주문
	@PostMapping("payment")
	public ModelAndView payment(HttpSession session, CartDTO cdto) {

		String genie_id = (String) session.getAttribute("logId");
		//System.out.println("주문정보 받아온 것 cdto : " + cdto.toString());

		List<CartDTO> lcdto = orderService.readyToPay(cdto);
		//System.out.println("카트정보 가져오기 : " + cdto.toString());

		mav = new ModelAndView();
		mav.addObject("plist", lcdto);
		mav.addObject("udto", userService.getUser(genie_id));
		mav.setViewName("/order/payment");

		return mav;
	}

	@GetMapping("orderCompletion")
	public ResponseEntity<String> orderCompletion(HttpSession session, OrderDTO odto) {
		
		ResponseEntity<String> entity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text","html",Charset.forName("UTF-8")));
		headers.add("Content-Type","text/html; charset=utf-8");
		TransactionStatus status= transactionManager.getTransaction(definition);

		String genie_id = (String) session.getAttribute("logId");

		System.out.println("주문 정보 : "+odto.toString());
		
		if(odto.getCartList() != null){

			try{
				//제품 정보 가져오기
				List<OrderDTO> cList = orderService.getFromCart(odto);
				//System.out.println("odto 제품정보 : "+odto.toString());
				System.out.println("제품정보 : "+cList.size()); /// gfdgfgdg
				for(OrderDTO dto : cList){
					dto.setOrder_num(odto.getOrder_num());
					dto.setGenie_id(genie_id);

					dto.setRecipient_name(odto.getRecipient_name());
					dto.setRecipient_phone(odto.getRecipient_phone());
					dto.setRecipient_address(odto.getRecipient_address());
					dto.setRecipient_request(odto.getRecipient_request());

					dto.setOrder_price(dto.getCart_price());
					dto.setOrder_qty(dto.getCart_qty());
					dto.setPayment_method(odto.getPayment_method());

					System.out.println(dto.toString());

					orderService.afterPayment(dto);

				}
				//오더테이블에 저장
				////장바구니에서 구매한 상품 지우기
				orderService.afterOrderCart(odto);// 장바구니 삭제

				transactionManager.commit(status);
				entity = new ResponseEntity<String>(HttpStatus.OK);

			}catch(Exception e){
				entity = new ResponseEntity<String>(headers,HttpStatus.BAD_REQUEST);
				
				transactionManager.rollback(status);
				e.printStackTrace();

			}
		}else{
			try{
				odto.setGenie_id(genie_id);
				orderService.afterPayment(odto);
				
				transactionManager.commit(status);
				entity = new ResponseEntity<String>(HttpStatus.OK);

			}catch(Exception e){
				entity = new ResponseEntity<String>(headers,HttpStatus.BAD_REQUEST);
				
				transactionManager.rollback(status);
				e.printStackTrace();
			}
		}

		return entity;
	}

	@GetMapping("completion")
	public ModelAndView completion(HttpSession session) {

		String genie_id = (String) session.getAttribute("logId");
		List<OrderDTO> odto = orderService.getOrderList(genie_id);

		mav = new ModelAndView();
		mav.addObject("olist", odto);
		mav.setViewName("/order/completion");

		return mav;
	}
    
}
