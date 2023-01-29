package com.genie.myapp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.genie.myapp.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.genie.myapp.service.AdminService;
import com.genie.myapp.service.ProductService;
import com.genie.myapp.service.UserService;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class ProductController {
	
	public final AdminService adminService;
	public final ProductService productService;
	public final UserService userService;

	ModelAndView mav = null;
	Map<String, Object> map = null;

	@GetMapping("/")
	public ModelAndView index(AdminDTO adminDTO, ProductDTO productDTO, PagingDTO pDTO) {

		mav = new ModelAndView();
		mav.addObject("tlist", adminService.adminTag(adminDTO));
		mav.addObject("plist", productService.listProduct(productDTO));
		mav.addObject("pvo", productDTO);
		mav.addObject("comlist", productService.companyName(productDTO));
		// pDTO.setTotalRecord(productService.mainAllSelect(PDTO));
		mav.setViewName("/index");

		return mav;
	}

	// 제품 리스트보기
	@GetMapping("product")
	public ModelAndView product(ProductDTO productDTO) {

		mav = new ModelAndView();
		mav.addObject("plist", productService.listProduct(productDTO));
		mav.addObject("pvo", productDTO);
		mav.setViewName("/product");

		return mav;
	}

	// 제폼 상세페이지
	@GetMapping("product_detail")
	public ModelAndView productDetail(@RequestParam("product_id") int product_id, HttpSession session) {

		mav = new ModelAndView();
		String genie_id = (String) session.getAttribute("logId");
		ProductDTO productDTO = ProductDTO.createProductDTO(product_id);
		productService.hitCount(productDTO);

		mav.addObject("pvo", productService.getProduct(productDTO));
		mav.addObject("svo", productService.getSeller(productDTO));
		mav.addObject("lvo", productService.likeStatus(productDTO));
		mav.addObject("cvo", productService.likeCheck(productDTO, genie_id));
		mav.setViewName("/product_detail");

		return mav;
	}

	// ---------------------------------------------- 지니페이지 상품 정보 검색
	// ----------------------------------------------------------//
	
	@PostMapping("selectProduct")
	public ModelAndView selectProduct(ProductDTO productDTO, TagDTO tagDTO) {

		map = new HashMap<>();
		map.put("p", productDTO);
		map.put("t", tagDTO);

		mav = new ModelAndView();
		mav.addObject("plist", productService.selectProduct(map));
		mav.setViewName("/product");

		return mav;
	}
	
}