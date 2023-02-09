package com.genie.myapp.controller;

import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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

import com.genie.myapp.service.AdministerService;
import com.genie.myapp.service.ProductService;
import com.genie.myapp.service.SellerService;
import com.genie.myapp.service.UserService;

import static org.springframework.http.HttpStatus.*;


@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class GenieController {

	ModelAndView mav = null;

	public final UserService userService;
	public final SellerService sellerService;
	public final AdministerService administerService;
	public final ProductService productService;
	public final PasswordEncoder passwordEncoder;

	//회원가입 폼으로 이동
	@GetMapping("Registration")
	public ModelAndView RegistrationForm() {

		mav = new ModelAndView();
		mav.setViewName("/Registration");

		return mav;
	}

	//업체 회원가입 폼 보기
	@GetMapping("sellerForm")
	public ModelAndView sellerForm() {
		mav = new ModelAndView();
		mav.setViewName("/sellerForm");
		return mav;
	}

	//아이디 중복검사
	@GetMapping("idCheck")
	public ModelAndView idCheck(String genie_id) {

		mav = new ModelAndView();

		mav.addObject("idCnt", userService.idCheck(genie_id));// seller user 통합
		mav.addObject("genie_id", genie_id);
		mav.setViewName("/idCheck");

		return mav;
	}

	//아이디 중복검사
	@GetMapping("emailCheck")
	public ModelAndView emailCheck(UserDTO userDTO) {

		mav = new ModelAndView();

		mav.addObject("emailCnt", userService.emailCheck(userDTO));
		mav.addObject("userEmail", userDTO.getUserEmail());
		mav.setViewName("/emailCheck");

		return mav;
	}

	@GetMapping("sellerEmailCheck")
	public ModelAndView sellerEmailCheck(SellerDTO sellerDTO) {

		mav = new ModelAndView();

		mav.addObject("emailCnt", sellerService.emailCheck(sellerDTO));
		mav.addObject("sellerEmail", sellerDTO.getSellerEmail());
		mav.setViewName("sellerEmailCheck");

		return mav;
	}


	//회원 가입하기
	@PostMapping("UserWrite")
	public ResponseEntity<String> UserWrite(UserDTO userDTO) {

		ResponseEntity<String> entity;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text", "html", StandardCharsets.UTF_8));
		headers.add("Content-Type", "text/html; charset=utf-8");

		try {//회원가입 성공

			userService.UserWrite(userDTO);

			String msg = "<script>";
			msg += "alert('회원가입을 성공하였습니다.');";
			msg += "location.href='/login';";
			msg += "</script>";
			entity = new ResponseEntity<>(msg, headers, OK);

		} catch (Exception e) {//회원등록 실패

			String msg = "<script>";
			msg += "alert('회원가입이 실패하였습니다.');";
			msg += "history.back()";
			msg += "</script>";
			entity = new ResponseEntity<>(msg, headers, BAD_REQUEST);

			e.printStackTrace();
		}

		return entity;
	}

	//seller 회원가입하기
	@PostMapping("sellerWrite")
	public ResponseEntity<String> sellerWrite(SellerDTO sellerDTO) {

		ResponseEntity<String> entity;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text", "html", StandardCharsets.UTF_8));
		headers.add("Content-Type", "text/html; charset=utf-8");

		try {//회원가입성공

			sellerService.sellerWrite(sellerDTO);

			String msg = "<script>";
			msg += "alert('회원가입을 성공하였습니다.');";
			msg += "location.href='/login';";
			msg += "</script>";
			entity = new ResponseEntity<>(msg, headers, OK);


		} catch (Exception e) {//회원가입실패

			String msg = "<script>";
			msg += "alert('회원가입에 실패하였습니다.');";
			msg += "history.back();";
			msg += "</script>";
			entity = new ResponseEntity<>(msg, headers, BAD_REQUEST);

			e.printStackTrace();

		}
		return entity;
	}

	//로그인
	@PostMapping("loginOK")
	public ModelAndView loginOk(@Valid AccountDTO accountDTO, HttpSession session) {

		mav = new ModelAndView();

			AccountDTO account = userService.loginOk(accountDTO);

			//비밀번호 검증
			boolean pwdMatch = passwordEncoder.matches(accountDTO.getGeniePwd(), account.getGeniePwd());

			if (pwdMatch) {

				if (account.getROLE().equals("USER")) {//일반회원 일때

					UserDTO logDTO = userService.getUser(accountDTO);
					session.setAttribute("logId", logDTO.getGenieId());
					session.setAttribute("logName", logDTO.getUserName());
					session.setAttribute("logStatus", "Y");
					session.setAttribute("ROLE", "ROLE_USER");

					mav.setViewName("redirect:/");

					return mav;
				}//일반 회원일때 끝

				if (account.getROLE().equals("SELLER")) {//업체회원일때

					SellerDTO slogDTO = sellerService.getSeller(accountDTO);
					session.setAttribute("logId", slogDTO.getGenieId());
					session.setAttribute("logName", slogDTO.getCompanyName());
					session.setAttribute("logStatus", "Y");
					session.setAttribute("ROLE", "ROLE_SELLER");

					mav.setViewName("redirect:/seller/sellerMain");

					return mav;
				}// 업체회원일때 끝

				if (account.getROLE().equals("ADMIN")) {//관리자 회원일때

					AdministerDTO alogDTO = administerService.getAdminister(accountDTO);
					session.setAttribute("logId", alogDTO.getGenieId());
					session.setAttribute("logName", alogDTO.getAdministerName());
					session.setAttribute("logStatus", "Y");
					session.setAttribute("ROLE", "ROLE_ADMIN");

					mav.setViewName("redirect:/admin/adminMain");

					return mav;
				}//관리자일때 끝

			}

			mav.setViewName("redirect:/login");
			return mav;
	}

	@GetMapping("logout")
	public ModelAndView logout(HttpSession session) {

		mav = new ModelAndView();
		session.invalidate();
		mav.setViewName("redirect:/");
		
		return mav;
	}

	// ----------------------------- 제품 리스트 보이기 index
	// -----------------------------------//

	@GetMapping("index")
	public ModelAndView productList(ProductDTO productDTO) {

		mav = new ModelAndView();
		mav.addObject("plist", productService.listProduct(productDTO));
		mav.addObject("pvo", productDTO);
		mav.setViewName("/");

		return mav;
	}

	@GetMapping("genie")
	public ModelAndView genie() {
		mav = new ModelAndView();
		mav.setViewName("/genie");
		return mav;
	}

	@GetMapping("login")
	public ModelAndView adminLogin() {
		mav = new ModelAndView();
		mav.setViewName("/login");
		return mav;
	}

	// -----------------------------------------------------------장바구니---------------------------------------------------------------//
	
	@GetMapping("cart")
	public ModelAndView cart(HttpSession session) {

		String genieId = (String) session.getAttribute("logId");
		UserDTO userDTO = UserDTO.createUserDTO(genieId);
		List<CartDTO> cartList = productService.getCart(userDTO);
		// System.out.print(cartList);

		mav = new ModelAndView();
		mav.addObject("clist", cartList);
		mav.setViewName("/cart");

		return mav;
	}

	@PostMapping("addCart")
	public ResponseEntity<String> addCart(CartDTO cartDTO) {

		ResponseEntity<String> entity;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text", "html", StandardCharsets.UTF_8));
		headers.add("Content-Type", "text/html; charset=utf-8");

		try {

			productService.addCart(cartDTO);

			String msg = "<script>";
			msg += "alert('장바구니에 추가되었습니다.');";
			msg += "location.href='/cart';";
			msg += "</script>";
			entity = new ResponseEntity<>(msg, headers, OK);

		} catch (Exception e) {

			String msg = "<script>";
			msg += "alert('로그인 또는 회원가입을 해주세요');";
			msg += "history.back()";
			msg += "</script>";

			entity = new ResponseEntity<>(msg, headers, BAD_REQUEST);

			e.printStackTrace();
		}

		return entity;
	}

	@PostMapping("updateCart")
	public ResponseEntity<String> updateCart(CartDTO cvo) {

		ResponseEntity<String> entity;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text", "html", StandardCharsets.UTF_8));
		headers.add("Content-Type", "text/html; charset=utf-8");

		try {
			productService.updateCart(cvo);
			entity = new ResponseEntity<>(headers, OK);

		} catch (Exception e) {

			entity = new ResponseEntity<>(headers, BAD_REQUEST);
			e.printStackTrace();
		}
		return entity;
	}

	// 장바구니에서 제품 삭제
	@GetMapping("delCart")
	public void delCart(CartDTO cartDTO) {
		productService.delCart(cartDTO);

	}

	// 장바구니에서 여러 제품 삭제
	@GetMapping("delMultiCart")
	public ModelAndView delMultiCart(CartDTO cartDTO) {

		mav = new ModelAndView();
		productService.delMultiCart(cartDTO);
		mav.setViewName("redirect:/cart");
		return mav;
	}

	
}