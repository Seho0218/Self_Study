package com.genie.myapp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.genie.myapp.dto.TagDTO;
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
import com.genie.myapp.dto.AdminDTO;
import com.genie.myapp.dto.PagingDTO;
import com.genie.myapp.dto.ProductDTO;

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
	public ModelAndView index(AdminDTO dto, ProductDTO Pdto, PagingDTO pdto) {

		mav = new ModelAndView();
		mav.addObject("tlist", adminService.adminTag(dto));
		mav.addObject("plist", productService.listProduct(Pdto));
		mav.addObject("pdto", pdto);
		mav.addObject("comlist", productService.companyName(Pdto));
		// pdto.setTotalRecord(productService.mainAllSelect(Pdto));
		mav.setViewName("/index");

		return mav;
	}

	// 제품 리스트보기
	@GetMapping("product")
	public ModelAndView product(ProductDTO pdto) {

		mav = new ModelAndView();
		mav.addObject("plist", productService.listProduct(pdto));
		mav.addObject("pdto", pdto);
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
		mav.addObject("sdto", productService.getSeller(product_id));
		mav.addObject("lvo", productService.likeStatus(product_id));
		mav.addObject("cvo", productService.likeCheck(product_id, genie_id));
		mav.setViewName("/product_detail");

		return mav;
	}

	// ---------------------------------------------- 지니페이지 상품 정보 검색
	// ----------------------------------------------------------//
	
	@PostMapping("selectProduct")
	public ModelAndView selectProduct(ProductDTO pvo, TagDTO tvo) {

		map = new HashMap<String, Object>();
		map.put("p", pvo);
		map.put("t", tvo);

		mav = new ModelAndView();
		mav.addObject("plist", productService.selectProduct(map));
		mav.setViewName("/product");

		return mav;
	}
	
}