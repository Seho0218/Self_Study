package com.genie.myapp.controller;

import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.genie.myapp.service.AdminService;
import com.genie.myapp.vo.AdminVO;
import com.genie.myapp.vo.CartVO;
import com.genie.myapp.vo.PagingVO;
import com.genie.myapp.vo.SellerVO;
import com.genie.myapp.vo.UserVO;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
		
	@Autowired
	AdminService service;
	ModelAndView mav = null;
	
		@GetMapping("adminLogin")
		public ModelAndView adminLogin() {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("admin/adminLogin");
			return mav;
		}

		@GetMapping("adminMain")
		public ModelAndView adminMain() {
			ModelAndView mav = new ModelAndView();
			//Test 시작
			//mav.setTotalRecord(service.mainTotalRecord(AdminVO VO));
			//Test 끝
			mav.setViewName("admin/adminMain");
			return mav;
		}

		@GetMapping("adminPro")
		public ModelAndView adminPro() {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("admin/adminPro");
			return mav;
		}
		
		//@GetMapping("adminCategoryTag")
		//public ModelAndView adminCategoryTag() {
		//	ModelAndView mav = new ModelAndView();
		//	mav.setViewName("admin/adminCategoryTag");
		//	return mav;
		//}
		
		//카테고리 
		@GetMapping("adminCategoryTag")
		public ModelAndView adminCategoryTag(AdminVO VO) {
			mav = new ModelAndView();
			System.out.println(VO.toString());
			mav.addObject("list", service.adminCategoryTag(VO));
			mav.addObject("VO", VO);
			mav.setViewName("admin/adminCategoryTag");
			return mav;
		}

		//adminIndex
		@GetMapping("adminIndex")
		public ModelAndView adminIndex() {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("admin/adminIndex");
			return mav;
		}

		//adminDetail
		@GetMapping("adminDetail")
		public ModelAndView adminDetail() {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("admin/adminDetail");
			return mav;
		}

		//adminDetail
		@GetMapping("test")
		public ModelAndView test() {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("admin/test");
			return mav;
		}

		//태그		
		@GetMapping("adminTag")
		public ModelAndView adminTag() {
			mav = new ModelAndView();
			mav.addObject("adminTag", service.tagAllSelect());
			mav.setViewName("admin/adminTag");
			return mav;
		}

		// 선택된 태그 수정 폼
		@GetMapping("adminTagPop")
		public ModelAndView adminTagPop(@RequestParam("product_tag_id") String product_tag_id) {
			ModelAndView mav = new ModelAndView();
			mav.addObject("vo", service.getadminTag(product_tag_id));
			mav.setViewName("admin/adminTagPop");
			return mav;
		}
		
		// 태그 DB 업데이트
		@PostMapping("adminTagPopEdit")
		public ResponseEntity<String> adminTagPopEdit(AdminVO vo){
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(new MediaType("text","html",Charset.forName("UTF-8")));
			headers.add("Content-Type", "text/html; charset-UTF-8");
			String msg = "<script>";
			try {
				service.adminTagPopEdit(vo);
				msg += "alert('수정완료되었습니다. 정보관리 페이지로 이동합니다.');";
				msg += "location.href='/admin/adminTagPop?product_tag_id="+vo.getproduct_tag_id()+"';";
						
			}catch(Exception e){
				e.printStackTrace();
				msg += "alert('수정 실패하였습니다.');";
				msg += "history.go(-1);";
			}
			msg += "</script>";
			
			return new ResponseEntity<String>(msg, headers, HttpStatus.OK);
		}
		
		// 태그 정보 삭제
		@GetMapping("adminTagDel")
		public ModelAndView adminTagDel(String product_tag_id) {
			int cnt = service.adminTagDel(product_tag_id);
			mav = new ModelAndView();
			if(cnt>0) {
				mav.setViewName("redirect:adminTag");
			}else {
				mav.setViewName("redirect:adminTag");
			}
			return mav;
		}

		/////////////카테고리////////////////
		// 카테고리 페이지 이동
		@GetMapping("adminCategory")
		public ModelAndView adcategory() {
			mav = new ModelAndView();
			mav.addObject("adcategory", service.categoryAllSelect());
			mav.setViewName("admin/adminCategory");
			return mav;
		}	
		
		// 선택된 카테고리 정보 수정 폼
		@GetMapping("adminCategoryPop")
		public ModelAndView adcategoryPop(@RequestParam("category_id") String category_id) {
			ModelAndView mav = new ModelAndView();
			mav.addObject("vo", service.getadcategory(category_id));
			mav.setViewName("admin/adminCategoryPop");
			return mav;
		}
		
		// 카테고리 DB 업데이트
		@PostMapping("adminCategoryPopEdit")
		public ResponseEntity<String> adcategoryPopEdit(AdminVO vo){
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(new MediaType("text","html",Charset.forName("UTF-8")));
			headers.add("Content-Type", "text/html; charset-UTF-8");
			String msg = "<script>";
			try {
				service.adcategoryPopEdit(vo);
				msg += "alert('수정완료되었습니다. 정보관리 페이지로 이동합니다.');";
				msg += "location.href='/admin/adminCategoryPop?category_id="+vo.getcategory_id()+"';";
						
			}catch(Exception e){
				e.printStackTrace();
				msg += "alert('수정 실패하였습니다.');";
				msg += "history.go(-1);";
			}
			msg += "</script>";
			
			return new ResponseEntity<String>(msg, headers, HttpStatus.OK);
		}
		
		// 카테고리 정보 삭제
		@GetMapping("adminCategoryDel")
		public ModelAndView adcategoryDel(String category_id) {
			int cnt = service.admemberDel(category_id);
			mav = new ModelAndView();
			if(cnt>0) {
				mav.setViewName("redirect:adminCategory");
			}else {
				mav.setViewName("redirect:adminCategory");
			}
			return mav;
		}
		///////////////카테고리////////////////////
		
		//============== 제품관리 ===============//

		// @GetMapping("adminProductPop")
		// public ModelAndView adminProductPop(@RequestParam("product_id") String product_id) {
		// 	ModelAndView mav = new ModelAndView();
		// 	mav.addObject("vo", service.getadminProduct(product_id));
		// 	mav.setViewName("admin/adminCategoryPop");
		// 	return mav;
		// }
		
		// =======================================
		
		// admember 페이지 이동
		@GetMapping("admember")
		public ModelAndView admember(PagingVO pVO) {
			mav = new ModelAndView();
			
			pVO.setTotalRecord(service.userTotalRecord(pVO));
			mav.addObject("admember", service.userAllSelect(pVO));
			mav.addObject("pVO", pVO);
			
			mav.setViewName("admin/admember");
			return mav;
		}	
		
		// 선택된 유저의 정보 수정 폼
		@GetMapping("admemberPop")
		public ModelAndView admemberPop(@RequestParam("genie_id") String genie_id, PagingVO pVO) {
			ModelAndView mav = new ModelAndView();
			mav.addObject("vo", service.getadmember(genie_id));
			mav.addObject("pVO", pVO);
			mav.setViewName("admin/admemberPop");
			return mav;
		}
		
		// 유저 DB 업데이트
		@PostMapping("admemberPopEdit")
		public ResponseEntity<String> admemberPopEdit(UserVO vo){
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(new MediaType("text","html",Charset.forName("UTF-8")));
			headers.add("Content-Type", "text/html; charset-UTF-8");
			String msg = "<script>";
			try {
				service.admemberPopEdit(vo);
				msg += "alert('수정완료되었습니다. 정보관리 페이지로 이동합니다.');";
				msg += "location.href='/admin/admemberPop?genie_id="+vo.getGenie_id()+"';";
						
			}catch(Exception e){
				e.printStackTrace();
				msg += "alert('수정 실패하였습니다.');";
				msg += "history.go(-1);";
			}
			msg += "</script>";
			
			return new ResponseEntity<String>(msg, headers, HttpStatus.OK);
		}
		
		// 유저 정보 삭제
		@GetMapping("admemberDel")
		public ModelAndView admemberDel(String genie_id) {
			int cnt = service.admemberDel(genie_id);
			mav = new ModelAndView();
			if(cnt>0) {
				mav.setViewName("redirect:admember");
			}else {
				mav.setViewName("redirect:admember");
			}
			return mav;
		}
	
	//결제 뷰화면
	@GetMapping("adminpayment")
	public ModelAndView productForm() {
		mav = new ModelAndView();
		mav.setViewName("admin/adminpayment");
		return mav;
	}	

	//결제 컨트롤러
	@PostMapping("adminpaymentOk")
	public ResponseEntity<String> adminpayment(CartVO vo, HttpServletRequest request){
		vo.setGenie_id((String)request.getSession().getAttribute("logId")); //세션 로그인 아이디
		
		ResponseEntity<String> entity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text","html",Charset.forName("UTF-8")));
		headers.add("Content-Type", "text/html; charset=utf-8");
		
		try {//결제 성공
			int result  = service.paymentWrite(vo);
			
			String msg = "<script>";
			msg += "alert('결제가 되었습니다. 등록되었습니다.');";
			msg += "location.href='/admin/adminMain';";
			msg += "</script>";
			entity = new ResponseEntity<String>(msg,headers,HttpStatus.OK);
			
		}catch(Exception e) {//결제 실패
			
			String msg = "<script>";
			msg += "alert('결제가 실패하였습니다.');";
			msg += "history.back();";
			msg += "</script>";
			entity = new ResponseEntity<String>(msg,headers,HttpStatus.BAD_REQUEST);
			
			e.printStackTrace();
		}
		return entity;
	}
		// adcompany 페이지 이동
		@GetMapping("adcompany")
		public ModelAndView adcompany(PagingVO pVO) {
			mav = new ModelAndView();
			
			pVO.setTotalRecord(service.sellerTotalRecord(pVO));
			pVO.setNotApproved(service.sellerApproval(pVO));
			mav.addObject("adcompany", service.sellerAllSelect(pVO));
			mav.addObject("pVO", pVO);
			
			mav.setViewName("admin/adcompany");
			return mav;
		}	
		
		// 선택된 셀러의 정보 수정 폼
		@GetMapping("adcompanyPop")
		public ModelAndView adcompanyPop(@RequestParam("genie_id") String genie_id, PagingVO pVO) {
			ModelAndView mav = new ModelAndView();
			mav.addObject("vo", service.getadcompany(genie_id));
			mav.addObject("pVO", pVO);
			mav.setViewName("admin/adcompanyPop");
			return mav;
		}
		
		// 셀러 DB 업데이트
		@PostMapping("adcompanyPopEdit")
		public ResponseEntity<String> adcompanyPopEdit(SellerVO vo){
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(new MediaType("text","html",Charset.forName("UTF-8")));
			headers.add("Content-Type", "text/html; charset-UTF-8");
			String msg = "<script>";
			try {
				service.adcompanyPopEdit(vo);
				msg += "alert('수정완료되었습니다. 정보관리 페이지로 이동합니다.');";
				msg += "location.href='/admin/adcompanyPop?genie_id="+vo.getGenie_id()+"';";
						
			}catch(Exception e){
				e.printStackTrace();
				msg += "alert('수정 실패하였습니다.');";
				msg += "history.go(-1);";
			}
			msg += "</script>";
			
			return new ResponseEntity<String>(msg, headers, HttpStatus.OK);
		}
		
		// 셀러 정보 삭제
		@GetMapping("adcompanyDel")
		public ModelAndView adcompanyDel(String genie_id) {
			int cnt = service.adcompanyDel(genie_id);
			mav = new ModelAndView();
			if(cnt>0) {
				mav.setViewName("redirect:adcompany");
			}else {
				mav.setViewName("redirect:adcompany");
			}
			return mav;
		}
}