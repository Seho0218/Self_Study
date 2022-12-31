package com.genie.myapp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.genie.myapp.service.AdminService;
import com.genie.myapp.service.ProductService;
import com.genie.myapp.service.UserService;
import com.genie.myapp.vo.AdminVO;
import com.genie.myapp.vo.PagingVO;
import com.genie.myapp.vo.ProductVO;
import com.genie.myapp.vo.TagVO;

@RestController
@RequestMapping("/")
public class ProductController {
	
	@Autowired
	AdminService adminService;

	@Autowired
	ProductService productService;

	@Autowired
	UserService userService;

	ModelAndView mav = null;
	Map<String, Object> map = null;

	@GetMapping("/")
	public ModelAndView index(AdminVO vo, ProductVO PVO, PagingVO pVO) {

		mav = new ModelAndView();
		mav.addObject("tlist", adminService.adminTag(vo));
		mav.addObject("plist", productService.listProduct(PVO));
		mav.addObject("pvo", PVO);
		mav.addObject("comlist", productService.companyName(PVO));
		// pVO.setTotalRecord(productService.mainAllSelect(PVO));
		mav.setViewName("/index");

		return mav;
	}

	// 제품 리스트보기
	@GetMapping("product")
	public ModelAndView product(ProductVO PVO) {

		mav = new ModelAndView();
		mav.addObject("plist", productService.listProduct(PVO));
		mav.addObject("pvo", PVO);
		mav.setViewName("/product");

		return mav;
	}

	// 제폼 상세페이지
	@GetMapping("product_detail")
	public ModelAndView product_detail(@RequestParam("product_id") int product_id, HttpSession session) {
		mav = new ModelAndView();
		String genie_id = (String) session.getAttribute("logId");

		productService.hitCount(product_id);
		mav.addObject("pvo", productService.getProduct(product_id));
		mav.addObject("svo", productService.getSeller(product_id));
		mav.addObject("lvo", productService.likeStatus(product_id));
		mav.addObject("cvo", productService.likeCheck(product_id, genie_id));
		mav.setViewName("/product_detail");

		return mav;
	}

	// ---------------------------------------------- 지니페이지 상품 정보 검색
	// ----------------------------------------------------------//
	
	@PostMapping("selectProduct")
	public ModelAndView selectProduct(ProductVO pvo, TagVO tvo) {

		map = new HashMap<String, Object>();
		map.put("p", pvo);
		map.put("t", tvo);

		mav = new ModelAndView();
		mav.addObject("plist", productService.selectProduct(map));
		mav.setViewName("/product");

		return mav;
	}
	
}