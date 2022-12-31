package com.genie.myapp.controller;

import java.nio.charset.Charset;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.genie.myapp.service.AdministerService;
import com.genie.myapp.service.ProductService;
import com.genie.myapp.service.SellerService;
import com.genie.myapp.service.UserService;
import com.genie.myapp.vo.AccountVO;
import com.genie.myapp.vo.AdministerVO;
import com.genie.myapp.vo.CartVO;
import com.genie.myapp.vo.ProductVO;
import com.genie.myapp.vo.SellerVO;
import com.genie.myapp.vo.UserVO;

@RestController
@RequestMapping("/")
public class GenieController{

	@Autowired
	UserService userService;
	
	@Autowired
	SellerService sellerService;

	@Autowired
	AdministerService administerService;

	@Autowired
	ProductService productService;
	
	ModelAndView mav=null;
	
	@Autowired
	PlatformTransactionManager transactionManager;

	@Autowired
	TransactionDefinition definition;

	@Autowired
    PasswordEncoder passwordEncoder;

	
	//회원가입 폼으로 이동
	@GetMapping("Registration")
	public ModelAndView RegistragionForm() {

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

		//DB조회  : 아이디가 존재하는지 확인
		int cnt = userService.idCheck(genie_id);

		mav = new ModelAndView();

		mav.addObject("idCnt",cnt);
		mav.addObject("genie_id",genie_id);
		mav.setViewName("/idCheck");

		return mav;
	}

	//회원 가입하기
	@PostMapping("UserWrite") 
	public ResponseEntity<String> UserWrite(UserVO vo, AccountVO avo) {

		ResponseEntity<String> entity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text","html",Charset.forName("UTF-8")));
		headers.add("Content-Type","text/html; charset=utf-8");
		TransactionStatus status= transactionManager.getTransaction(definition);
		
		System.out.println("avo : " + avo.toString());
		
		try {//회원가입 성공
			String enPw=passwordEncoder.encode(avo.getGenie_pwd());
			avo.setGenie_pwd(enPw);
			userService.AccountWrite(avo);
			userService.UserWrite(vo);

			String msg = "<script>";
			msg += "alert('회원가입을 성공하였습니다.');";
			msg += "location.href='/login';";
			msg += "</script>";
			entity = new ResponseEntity<String>(msg,headers,HttpStatus.OK);

			transactionManager.commit(status);

		}catch(Exception e) {//회원등록 실패

			String msg = "<script>";
			msg += "alert('회원가입이 실패하였습니다.');";
			msg += "history.back()";
			msg += "</script>";
			entity = new ResponseEntity<String>(msg,headers,HttpStatus.BAD_REQUEST);
			
			transactionManager.rollback(status);
			e.printStackTrace();
			
		}

		return entity;
	}

	//seller 회원가입하기
	@PostMapping("sellerWrite")
	public ResponseEntity<String> sellerWrite(SellerVO svo, AccountVO avo){
		
		ResponseEntity<String> entity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text","html",Charset.forName("UTF-8")));
		headers.add("Content-Type", "text/html; charset=utf-8");
		TransactionStatus status= transactionManager.getTransaction(definition);
		
		try {//회원가입성공
			String enPw=passwordEncoder.encode(avo.getGenie_pwd());
			avo.setGenie_pwd(enPw);
			sellerService.AccountWrite(avo);
			sellerService.sellerWrite(svo);
			
			
			String msg = "<script>";
			msg += "alert('회원가입을 성공하였습니다.');";
			msg += "location.href='/login';";
			msg += "</script>";
			entity = new ResponseEntity<String>(msg,headers,HttpStatus.OK);

			transactionManager.commit(status);
			
		}catch(Exception e) {//회원가입실패
			
			String msg = "<script>";
			msg += "alert('회원가입에 실패하였습니다.');";
			msg += "history.back();";
			msg += "</script>";
			entity = new ResponseEntity<String>(msg,headers,HttpStatus.BAD_REQUEST);
			
			transactionManager.rollback(status);
			e.printStackTrace();
			
		}
		return entity;
	}

	//로그인
	@PostMapping("loginOK")
	public ModelAndView loginOk(UserVO vo, SellerVO svo, AdministerVO avo, HttpSession session) {
		
		mav = new ModelAndView();		

		if(vo.getGenie_id() != null) {//일반회원 일때

			UserVO logVO = userService.loginOk(vo);
			if(logVO!=null){
				//System.out.println(vo);
				//System.out.println(logVO);
				boolean pwdMatch = passwordEncoder.matches(vo.getGenie_pwd(), logVO.getGenie_pwd());
				//System.out.println(pwdMatch);
				if(pwdMatch){//로그인 성공
					session.setAttribute("logId", logVO.getGenie_id());		
					session.setAttribute("logName", logVO.getUser_name());
					session.setAttribute("logStatus","Y");
					session.setAttribute("ROLE", "ROLE_USER");
					
					mav.setViewName("redirect:/");
				}else{//로그인 실패
					mav.setViewName("redirect:/login");
				}
					return mav;
			
				}else if(svo.getGenie_id() !=null) {//업체회원일때 

					SellerVO slogVO=sellerService.loginOk(svo);
					if(slogVO!=null){
						//System.out.println(svo);
						//System.out.println(slogVO);
						boolean pwdMatch = passwordEncoder.matches(svo.getGenie_pwd(), slogVO.getGenie_pwd());
						//System.out.println(pwdMatch);
						if(pwdMatch){//로그인 성공

							System.out.println(pwdMatch);
							session.setAttribute("logId", slogVO.getGenie_id());
							session.setAttribute("logName", slogVO.getCompany_name());
							session.setAttribute("logStatus","Y");
							session.setAttribute("ROLE", "ROLE_SELLER");

							mav.setViewName("redirect:/seller/sellerMain");

						}else{//로그인 실패
							mav.setViewName("redirect:/login");
						}
							return mav;
					
					}else if(avo.getGenie_id() != null){

						AdministerVO alogVO = administerService.loginOk(avo);

						if(alogVO!=null){
							session.setAttribute("logId", alogVO.getGenie_id());
							session.setAttribute("logName", alogVO.getAdminister_name());
							session.setAttribute("logStatus","Y");
							session.setAttribute("ROLE", "ROLE_ADMIN");

							mav.setViewName("redirect:/admin/adminMain");

						}else{//로그인 실패
							
							mav.setViewName("redirect:/login");
						}

						mav.setViewName("redirect:/login");

						return mav;

					}else{//로그인 실패

						mav.setViewName("redirect:/login");
							
					}	
				}		
			}
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
	public ModelAndView productList(ProductVO PVO) {

		mav = new ModelAndView();
		mav.addObject("plist", productService.listProduct(PVO));
		mav.addObject("pvo", PVO);
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
	public ModelAndView cart(CartVO cvo, HttpSession session) {

		String genie_id = (String) session.getAttribute("logId");
		List<CartVO> cartList = productService.getCart(genie_id);
		// System.out.print(cartList);

		mav = new ModelAndView();
		mav.addObject("clist", cartList);
		mav.setViewName("/cart");

		return mav;
	}

	@PostMapping("addCart")
	public ResponseEntity<String> addCart(CartVO cvo) {

		ResponseEntity<String> entity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text", "html", Charset.forName("UTF-8")));
		headers.add("Content-Type", "text/html; charset=utf-8");

		try {

			productService.addCart(cvo);
			//System.out.print(addCart);

			String msg = "<script>";
			msg += "alert('장바구니에 추가되었습니다.');";
			msg += "location.href='/cart';";
			msg += "</script>";
			entity = new ResponseEntity<String>(msg, headers, HttpStatus.OK);

		} catch (Exception e) {

			String msg = "<script>";
			msg += "alert('로그인 또는 회원가입을 해주세요');";
			msg += "history.back()";
			msg += "</script>";

			entity = new ResponseEntity<String>(msg, headers, HttpStatus.BAD_REQUEST);

			e.printStackTrace();
		}

		return entity;
	}

	@PostMapping("updateCart")
	public ResponseEntity<String> updateCart(CartVO cvo) {

		ResponseEntity<String> entity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text", "html", Charset.forName("UTF-8")));
		headers.add("Content-Type", "text/html; charset=utf-8");

		try {
			//System.out.println(cvo.toString());
			productService.updateCart(cvo);

			entity = new ResponseEntity<String>(headers, HttpStatus.OK);

		} catch (Exception e) {

			entity = new ResponseEntity<String>(headers, HttpStatus.BAD_REQUEST);

			e.printStackTrace();
		}

		return entity;
	}

	// 장바구니에서 제품 삭제
	@GetMapping("delCart")
	public int delCart(HttpSession session, int cart_num) {
		String genie_id = (String) session.getAttribute("logId");
		return productService.delCart(cart_num, genie_id);

	}

	// 장바구니에서 여러 제품 삭제
	@GetMapping("delMultiCart")
	public ModelAndView delMultiCart(CartVO cvo) {

		mav = new ModelAndView();
		//System.out.println(" 제품 삭제 cvo 정보 " + cvo.toString());
		productService.delMultiCart(cvo);

		//System.out.println("지워진 상품 : " + cnt);
		mav.setViewName("redirect:/cart");
		return mav;
	}

	
}