package com.genie.myapp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.genie.myapp.dto.AccountDTO;
import com.genie.myapp.dto.CartDTO;
import com.genie.myapp.dto.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.genie.myapp.service.OrderService;
import com.genie.myapp.service.ProductService;
import com.genie.myapp.service.UserService;

import static java.nio.charset.StandardCharsets.*;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/order/*")
@RequiredArgsConstructor
public class OrderController {

	final UserService userService;
	final ProductService productService;
	final OrderService orderService;

	ModelAndView mav = null;

    // --------------------------------------------상품
	// 결제페이지-----------------------------------------------------
	// 바로 주문
	@PostMapping("BuyNow")
	public ModelAndView BuyNow(HttpSession session, CartDTO cartDTO) {
		
		String genie_id=(String)session.getAttribute("logId");
		AccountDTO accountDTO = AccountDTO.createAccountDTO(genie_id);

		mav = new ModelAndView();
		mav.addObject("bvo",cartDTO);
		mav.addObject("uvo", userService.getUser(accountDTO));
		mav.setViewName("/order/payment");

		return mav;
	}
	// 장바구니에서 주문
	@PostMapping("payment")
	public ModelAndView payment(HttpSession session, CartDTO cartDTO) {

		String genie_id = (String) session.getAttribute("logId");

		/*
		  장바구니에서 주문할 경우
		  장바구니의 제품정보를 주문 정보페이지에 옮기는 메서드
		 */
		List<CartDTO> lcvo = orderService.readyToPay(cartDTO);

		AccountDTO accountDTO = AccountDTO.createAccountDTO(genie_id);


		mav = new ModelAndView();
		mav.addObject("plist", lcvo);
		mav.addObject("uvo", userService.getUser(accountDTO));
		mav.setViewName("/order/payment");

		return mav;
	}

	@GetMapping("orderCompletion")
	public ResponseEntity<String> orderCompletion(OrderDTO orderDTO) {

		ResponseEntity<String> entity;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text","html", UTF_8));
		headers.add("Content-Type","text/html; charset=utf-8");

		if(orderDTO.getCartList() != null){

			try{
				/*
					주문 정보(orderDTO)에 담긴 제품 리스트의 정보를 가져오는 메서드
				 */
				List<OrderDTO> cList = orderService.getFromCart(orderDTO);

				/*
				orderDTO에 담긴 주문 정보에 cList를 통해 가져온 메서드를 이용해
				카트 정보를 주문 정보로 넣는 로직
				 */
				for(OrderDTO orderDTOs : cList){

					orderDTOs.setOrderNum(orderDTO.getOrderNum());
					orderDTOs.setGenieId(orderDTO.getGenieId());

					orderDTOs.setRecipientName(orderDTO.getRecipientName());
					orderDTOs.setRecipientPhone(orderDTO.getRecipientPhone());
					orderDTOs.setRecipientAddress(orderDTO.getRecipientAddress());
					orderDTOs.setRecipientRequest(orderDTO.getRecipientRequest());

					orderDTOs.setProductName(orderDTOs.getProductName());
					orderDTOs.setOrderPrice(orderDTOs.getCartPrice());
					orderDTOs.setOrderQty(orderDTOs.getCartQty());
					orderDTOs.setPaymentMethod(orderDTO.getPaymentMethod());

					orderService.afterPayment(orderDTOs);

				}
				//오더테이블에 저장
				////장바구니에서 구매한 상품 지우기
				orderService.afterOrderCart(orderDTO);// 장바구니 삭제

				entity = new ResponseEntity<>(OK);

			}catch(Exception e){
				entity = new ResponseEntity<>(headers, BAD_REQUEST);
				
				e.printStackTrace();

			}
		}else{
			try{
				orderDTO.setGenieId(orderDTO.getGenieId());
				orderService.afterPayment(orderDTO);
				
				entity = new ResponseEntity<>(OK);

			}catch(Exception e){
				entity = new ResponseEntity<>(headers, BAD_REQUEST);
				
				e.printStackTrace();
			}
		}

		return entity;
	}

	@GetMapping("completion")
	public ModelAndView completion(HttpSession session) {

		String genie_id = (String) session.getAttribute("logId");
		List<OrderDTO> orderDTO = orderService.getOrderList(genie_id);

		mav = new ModelAndView();
		mav.addObject("olist", orderDTO);
		mav.setViewName("/order/completion");

		return mav;
	}
    
}
