package com.genie.myapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;

import com.genie.myapp.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.genie.myapp.service.SellerService;
import com.genie.myapp.service.UserService;

import static java.nio.charset.StandardCharsets.*;
import static org.springframework.http.HttpStatus.*;


@RestController
@RequestMapping("/user/*")
@RequiredArgsConstructor
public class UserController {

	public final UserService userService;
	public final SellerService sellerService;
	public final PasswordEncoder passwordEncoder;

	ModelAndView mav=null;

//////////////////////////////////////////////////////////

	//마이페이지
	@GetMapping("MyPage")
	public ModelAndView MyPage(HttpSession session) {

		String genieId = (String)session.getAttribute("logId");
		AccountDTO accountDTO = AccountDTO.createAccountDTO(genieId);
		mav = new ModelAndView();

		mav.addObject("svo",sellerService.getSeller(accountDTO));
		mav.addObject("vo", userService.getUser(accountDTO));
		mav.setViewName("/user/MyPage");
	
		return mav;
	}
  
	//회원정보 수정 DB
	@PostMapping("UserEditOk")
	public ResponseEntity<String> UserEditOk(HttpSession session, UserDTO userDTO) {

		ResponseEntity<String> entity;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text","html", UTF_8));
		headers.add("Content-Type","text/html; charset=UTF-8");



		String genieId = (String)session.getAttribute("logId");
		userDTO.setGenieId(genieId);

		String msg = "<script>";

		try{//수정됨

			userService.UserEditOk(userDTO);

			msg+="alert('회원정보가 수정되었습니다.');";
			msg+="location.href='/user/MyPage';</script>";
			msg += "</script>";

			entity = new ResponseEntity<>(msg,headers, OK);

		}catch (Exception e){//수정못함

			msg+="alert('회원 정보 수정이 실패하였습니다.');";
			msg+="location.href='/user/MyPage';</script>";
			msg += "</script>";

			entity = new ResponseEntity<>(msg,headers, OK);

		}
		return entity;
	}

	//주문목록/배송조회
	@GetMapping("")
	public ModelAndView MyOrderList(HttpSession session) {

		String genie_id = (String)session.getAttribute("logId");
		AccountDTO accountDTO = AccountDTO.createAccountDTO(genie_id);
		UserDTO userDTO = UserDTO.createUserDTO(genie_id);

		List<OrderDTO> orderList =userService.getOrder(userDTO);
		
		mav = new ModelAndView();
		mav.addObject("list",orderList);
		mav.addObject("vo", userService.getUser(accountDTO));
		mav.setViewName("/user/MyOrderList");
	
		return mav;
	}

	//배송지 관리
	@GetMapping("MyDeliveryList") 
	public ModelAndView MyDeliveryLIst(HttpSession session) {
		
		String genieId = (String)session.getAttribute("logId");
		UserDTO userDTO = UserDTO.createUserDTO(genieId);
		AccountDTO accountDTO = AccountDTO.createAccountDTO(genieId);

		List<AddressDTO> dlist = userService.getDeliveryList(userDTO);

		mav = new ModelAndView();
		mav.addObject("vo", userService.getUser(accountDTO));
		mav.addObject("dlist", dlist);
		mav.setViewName("/user/MyDeliveryList");
	
		return mav;
	}

	//배송지 
	@PostMapping("addDelivery")
	public ResponseEntity<String> addDelivery(HttpSession session, AddressDTO addressDTO) {

		ResponseEntity<String> entity;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text","html", UTF_8));
		headers.add("Content-Type","text/html; charset=UTF-8");
		Map<String, String> errors = new HashMap<>();


		String msg = "<script>";
		try{

			String genieId=(String)session.getAttribute("logId");
			addressDTO.setGenieId(genieId);
			userService.addDelivery(addressDTO);

			msg+="alert('배송지가 등록되었습니다.');";
			msg+="location.href='/user/MyDeliveryList';</script>";
			entity = new ResponseEntity<>(msg,headers, OK);

		} catch(Exception e) {//등록 실패

			msg+="alert('배송지 등록에 실패하였습니다.');";
			msg+="location.href='/user/MyDeliveryList';</script>";
			entity = new ResponseEntity<>(msg,headers, BAD_REQUEST);
			e.printStackTrace();
		}

		return entity;
	}

	//주문 결제 페이지의 주소 추가창
	@PostMapping("addAddressbook")
	public ResponseEntity<String> addAddressBook(AddressDTO addressDTO) {
		
		ResponseEntity<String> entity;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text","html", UTF_8));
		headers.add("Content-Type","text/html; charset=UTF-8");

		String msg = "<script>";

		try{//등록 성공

			userService.addDelivery(addressDTO);
			msg+="alert('배송지가 등록되었습니다.');";
			msg+="location.href='/user/addressbook';</script>";
			entity = new ResponseEntity<>(msg,headers, OK);

		}catch (Exception e){//등록 실패

			msg+="alert('배송지 등록에 실패하였습니다.');";
			msg+="location.href='/user/addressbook';</script>";
			entity = new ResponseEntity<>(msg,headers, BAD_REQUEST);
			e.printStackTrace();
		}

		return entity;
	}

	@GetMapping("addressbook")
	public ModelAndView AddressBook(HttpSession session){

		String genieId=(String)session.getAttribute("logId");
		UserDTO userDTO = UserDTO.createUserDTO(genieId);
		List<AddressDTO> dlist=userService.getDeliveryList(userDTO);

		mav=new ModelAndView();
		mav.addObject("dlist", dlist);
		mav.setViewName("/user/addressbook");
		return mav;
	}

	@GetMapping("Addaddressbook")
	public ModelAndView addAddressBook(HttpSession session){

		String genie_id=(String)session.getAttribute("logId");

		UserDTO userDTO = UserDTO.createUserDTO(genie_id);
		AccountDTO accountDTO = AccountDTO.createAccountDTO(genie_id);

		List<AddressDTO> dlist=userService.getDeliveryList(userDTO);

		mav=new ModelAndView();
		mav.addObject("vo", userService.getUser(accountDTO));
		mav.addObject("dlist", dlist);
		mav.setViewName("/user/Addaddressbook");
		return mav;
	}

	@GetMapping("delDelivery")
	public void delDelivery(int addressNum){
		userService.delDelivery(addressNum);
	}

	//나의 문의사항 
	@GetMapping("MyInquiryList") 
	public ModelAndView MyInquiryList(HttpSession session) {
		
		String genie_id = (String)session.getAttribute("logId");
		AccountDTO accountDTO = AccountDTO.createAccountDTO(genie_id);

		mav = new ModelAndView();
		mav.addObject("vo", userService.getUser(accountDTO));
		mav.setViewName("/user/MyInquiryList");
	
		return mav;
	}
	
	//찜한 상품 리스트
	@GetMapping("MyLikeList")
	public ModelAndView MyLikeList(HttpSession session){

		String genie_id = (String)session.getAttribute("logId");
		AccountDTO accountDTO = AccountDTO.createAccountDTO(genie_id);


		mav = new ModelAndView();
		mav.addObject("list",userService.getLikeList(accountDTO));
		mav.addObject("vo", userService.getUser(accountDTO));
		mav.setViewName("/user/MyLikeList");
	
		return mav;

	}

	////////////////////////////////////////////////////////////////////

	@GetMapping("PwdEdit")
	public ModelAndView PwdChange(HttpSession session) {
		
		String genie_id = (String)session.getAttribute("logId");

		AccountDTO accountDTO = AccountDTO.createAccountDTO(genie_id);


		mav = new ModelAndView();
		mav.addObject("vo", userService.getUser(accountDTO));
		mav.setViewName("/user/PwdEdit");
		
		return mav;
	}

	@PostMapping("PwdEditOk")
	public ResponseEntity<String> PwdEditOk(AccountDTO accountDTO) {
		
		ResponseEntity<String> entity;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text","html", UTF_8));
		headers.add("Content-Type","text/html; charset=UTF-8");

		AccountDTO logDTO = userService.loginOk(accountDTO);

		//기존 비밀번호 확인
		boolean pwdMatch = passwordEncoder.matches(accountDTO.getGeniePwd(), logDTO.getGeniePwd());

		String msg = "<script>";

		if(pwdMatch){

			try{//수정함

				userService.PwdEditOk(accountDTO);

				msg+="alert('비밀번호가 수정되었습니다.');";
				msg+="window.close();</script>";
				entity = new ResponseEntity<>(msg,headers, OK);

			}catch (Exception e){//수정못함

				msg+="alert('비밀번호 수정이 실패하였습니다.');";
				msg+="window.close();</script>";
				entity = new ResponseEntity<>(msg,headers, BAD_REQUEST);

				e.printStackTrace();
			}

		}else{

			msg+="alert('비밀번호 수정이 실패하였습니다.');";
			msg+="window.close();</script>";
			entity = new ResponseEntity<>(msg,headers, OK);

		}

		return entity;
	}
}