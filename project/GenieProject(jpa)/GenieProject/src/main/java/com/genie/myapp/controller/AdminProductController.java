package com.genie.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.genie.myapp.service.AdminProductService;
import com.genie.myapp.vo.AdminProductVO;

@RestController
@RequestMapping("/admin/*")
public class AdminProductController {
	
	@Autowired
	AdminProductService service;
	ModelAndView mav = null;
	
	@GetMapping("adminProduct")
	public ModelAndView adminProduct(AdminProductVO VO) {
		mav = new ModelAndView();
		System.out.println(VO.toString());
		mav.addObject("list", service.adminProduct(VO));
		mav.addObject("VO", VO);
		mav.setViewName("admin/adminProduct");
		return mav;
	}
		
}
