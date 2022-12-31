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
import com.genie.myapp.vo.CartVO;
import com.genie.myapp.vo.OrderVO;

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
	public ModelAndView BuyNow(HttpSession session, CartVO cvo) {
		
		String genie_id=(String)session.getAttribute("logId");
		//System.out.println("BuyNow로 받아온 cvo : "+cvo.toString());

		mav=new ModelAndView();
		mav.addObject("bvo",cvo);
		mav.addObject("uvo", userService.getUser(genie_id));
		mav.setViewName("/order/payment");

		return mav;
	}
	// 장바구니에서 주문
	@PostMapping("payment")
	public ModelAndView payment(HttpSession session, CartVO cvo) {

		String genie_id = (String) session.getAttribute("logId");
		//System.out.println("주문정보 받아온 것 cvo : " + cvo.toString());

		List<CartVO> lcvo = orderService.readyToPay(cvo);
		//System.out.println("카트정보 가져오기 : " + cvo.toString());

		mav = new ModelAndView();
		mav.addObject("plist", lcvo);
		mav.addObject("uvo", userService.getUser(genie_id));
		mav.setViewName("/order/payment");

		return mav;
	}

	@GetMapping("orderCompletion")
	public ResponseEntity<String> orderCompletion(HttpSession session, OrderVO ovo) {
		
		ResponseEntity<String> entity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text","html",Charset.forName("UTF-8")));
		headers.add("Content-Type","text/html; charset=utf-8");
		TransactionStatus status= transactionManager.getTransaction(definition);

		String genie_id = (String) session.getAttribute("logId");

		System.out.println("주문 정보 : "+ovo.toString());
		
		if(ovo.getCartList() != null){

			try{
				//제품 정보 가져오기
				List<OrderVO> cList = orderService.getFromCart(ovo);
				//System.out.println("ovo 제품정보 : "+ovo.toString());
				System.out.println("제품정보 : "+cList.size()); /// gfdgfgdg
				for(OrderVO vo : cList){
					vo.setOrder_num(ovo.getOrder_num());
					vo.setGenie_id(genie_id);

					vo.setRecipient_name(ovo.getRecipient_name());
					vo.setRecipient_phone(ovo.getRecipient_phone());
					vo.setRecipient_address(ovo.getRecipient_address());
					vo.setRecipient_request(ovo.getRecipient_request());

					vo.setOrder_price(vo.getCart_price());
					vo.setOrder_qty(vo.getCart_qty());
					vo.setPayment_method(ovo.getPayment_method());

					System.out.println(vo.toString());

					orderService.afterPayment(vo);

				}
				//오더테이블에 저장
				////장바구니에서 구매한 상품 지우기
				orderService.afterOrderCart(ovo);// 장바구니 삭제

				transactionManager.commit(status);
				entity = new ResponseEntity<String>(HttpStatus.OK);

			}catch(Exception e){
				entity = new ResponseEntity<String>(headers,HttpStatus.BAD_REQUEST);
				
				transactionManager.rollback(status);
				e.printStackTrace();

			}
		}else{
			try{
				ovo.setGenie_id(genie_id);
				orderService.afterPayment(ovo);
				
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
		List<OrderVO> ovo = orderService.getOrderList(genie_id);

		mav = new ModelAndView();
		mav.addObject("olist", ovo);
		mav.setViewName("/order/completion");

		return mav;
	}
    
}
