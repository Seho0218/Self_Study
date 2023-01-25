package com.genie.myapp.controller;

import com.genie.myapp.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.genie.myapp.service.AdminProductService;

@RestController
@RequestMapping("/admin/*")
@RequiredArgsConstructor
public class AdminProductController {

	public final AdminProductService service;

	ModelAndView mav = null;
	
	@GetMapping("adminProduct")
	public ModelAndView adminProduct(ProductDTO productDTO) {
		mav = new ModelAndView();
		mav.addObject("list", service.adminProduct(productDTO));
		mav.addObject("VO", productDTO);
		mav.setViewName("admin/adminProduct");
		return mav;
	}
		
}
