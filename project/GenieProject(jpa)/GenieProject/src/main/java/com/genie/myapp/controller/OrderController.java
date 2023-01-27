package com.genie.myapp.controller;

import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.genie.myapp.dto.CartDTO;
import com.genie.myapp.dto.OrderDTO;
import com.genie.myapp.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
		//System.out.println("BuyNow로 받아온 cvo : "+cvo.toString());

		UserDTO userDTO = UserDTO.createUserDTO(genie_id);

		mav = new ModelAndView();
		mav.addObject("bvo",cartDTO);
		mav.addObject("uvo", userService.getUser(userDTO));
		mav.setViewName("/order/payment");

		return mav;
	}
	// 장바구니에서 주문
	@PostMapping("payment")
	public ModelAndView payment(HttpSession session, CartDTO cartDTO) {

		String genie_id = (String) session.getAttribute("logId");
		//System.out.println("주문정보 받아온 것 cartDTO : " + cartDTO.toString());

		List<CartDTO> lcvo = orderService.readyToPay(cartDTO);
		//System.out.println("카트정보 가져오기 : " + cartDTO.toString());

		UserDTO userDTO = UserDTO.createUserDTO(genie_id);

		mav = new ModelAndView();
		mav.addObject("plist", lcvo);
		mav.addObject("uvo", userService.getUser(userDTO));
		mav.setViewName("/order/payment");

		return mav;
	}

	@GetMapping("orderCompletion")
	public ResponseEntity<String> orderCompletion(HttpSession session, OrderDTO orderDTO) {
		
		ResponseEntity<String> entity;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text","html", StandardCharsets.UTF_8));
		headers.add("Content-Type","text/html; charset=utf-8");

		String genie_id = (String) session.getAttribute("logId");

		System.out.println("주문 정보 : "+orderDTO.toString());
		
		if(orderDTO.getCartList() != null){

			try{
				//제품 정보 가져오기
				List<OrderDTO> cList = orderService.getFromCart(orderDTO);
				//System.out.println("orderDTO 제품정보 : "+orderDTO.toString());
				System.out.println("제품정보 : "+cList.size()); ///
				for(OrderDTO orderDTOs : cList){
					orderDTOs.setOrderNum(orderDTO.getOrderNum());
					orderDTOs.setGenieId(genie_id);

					orderDTOs.setRecipientName(orderDTO.getRecipientName());
					orderDTOs.setRecipientPhone(orderDTO.getRecipientPhone());
					orderDTOs.setRecipientAddress(orderDTO.getRecipientAddress());
					orderDTOs.setRecipientRequest(orderDTO.getRecipientRequest());

					orderDTOs.setOrderPrice(orderDTOs.getCartPrice());
					orderDTOs.setOrderQty(orderDTOs.getCartQty());
					orderDTOs.setPaymentMethod(orderDTO.getPaymentMethod());

//					System.out.println(orderDTOs.toString());

					orderService.afterPayment(orderDTOs);

				}
				//오더테이블에 저장
				////장바구니에서 구매한 상품 지우기
				orderService.afterOrderCart(orderDTO);// 장바구니 삭제

				entity = new ResponseEntity<>(HttpStatus.OK);

			}catch(Exception e){
				entity = new ResponseEntity<>(headers,HttpStatus.BAD_REQUEST);
				
				e.printStackTrace();

			}
		}else{
			try{
				orderDTO.setGenieId(genie_id);
				orderService.afterPayment(orderDTO);
				
				entity = new ResponseEntity<>(HttpStatus.OK);

			}catch(Exception e){
				entity = new ResponseEntity<>(headers,HttpStatus.BAD_REQUEST);
				
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
