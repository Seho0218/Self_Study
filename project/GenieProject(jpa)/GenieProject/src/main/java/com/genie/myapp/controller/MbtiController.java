package com.genie.myapp.controller;


import com.genie.myapp.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.genie.myapp.service.MbtiService;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class MbtiController {
	
	public final MbtiService service;
	ModelAndView mav;
	
	//mbti 메인페이지
	@GetMapping("mbti/mbtiMain")
	public ModelAndView genieMbti() {
		mav = new ModelAndView();
		mav.setViewName("mbti/mbtiMain");
		return mav;
	}
	
	//mbti 상품 리스트
	@GetMapping("mbti/{mbti}")
	public ModelAndView mbtiList(@PathVariable("mbti") String mbti) {
		mav = new ModelAndView();
		//System.out.println(mbti);
		
		mav.addObject("plist", service.getProduct(mbti));
		//mav.addObject("pvo", pvo);
		mav.setViewName("mbti/mbtiList");
		
		return mav;
	}
	
	//상품 정렬(mbti 리스트)
	@GetMapping("mbti/{mbti}/{sortType}")
	public ModelAndView mbtiList(@PathVariable("mbti") String mbti, @PathVariable("sortType") String sortType) {
		mav = new ModelAndView();

		switch (sortType) {
			case "pricelist" -> //가격낮은순
					mav.addObject("plist", service.pricelist(mbti));
			case "pricelistdesc" -> //가격높은순
					mav.addObject("plist", service.pricelistdesc(mbti));
			case "recentlist" -> //최신순
					mav.addObject("plist", service.recentlist(mbti));
			default -> //좋아요순
					mav.addObject("plist", service.likelist(mbti));
		}
		
		mav.setViewName("mbti/mbtiList");
		
		return mav;
	}
	
	//상품 정렬하기 (카테고리 list)
	@GetMapping("product/{productCategory}/{sortType}")
	public ModelAndView productSort(@PathVariable("productCategory") String productCategory, @PathVariable("sortType") String sortType) {

		mav = new ModelAndView();

		System.out.println("productCategory = " + productCategory);

		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductCategory(productCategory);

		switch (sortType) {
			case "pricelist" -> //가격낮은순
				//List<ProductVO> list= service.productPriceAsc(PVO);
				//System.out.println(list.size());
					mav.addObject("plist", service.productPriceAsc(productDTO));
			case "pricelistdesc" -> //가격높은순
					mav.addObject("plist", service.productPriceDesc(productDTO));
			case "recentlist" -> //최신순
					mav.addObject("plist", service.productRecent(productDTO));
			default -> //좋아요순
					mav.addObject("plist", service.productLike(productDTO));
		}
		
		mav.addObject("pvo", productDTO);
		mav.setViewName("/product");

		return mav;
	}
	
	//상품 정렬 (전체 리스트)
	@GetMapping("product/{sortType}")
	public ModelAndView totalProductSort(@PathVariable("sortType") String sortType) {

		mav = new ModelAndView();
		ProductDTO PVO = new ProductDTO();

		switch (sortType) {
			case "pricelist" -> //가격낮은순
				//List<ProductVO> list= service.productPriceAsc(PVO);
				//System.out.println(list.size());
					mav.addObject("plist", service.productPriceAsc(PVO));
			case "pricelistdesc" -> //가격높은순
					mav.addObject("plist", service.productPriceDesc(PVO));
			case "recentlist" -> //최신순
					mav.addObject("plist", service.productRecent(PVO));
			default -> //좋아요순
					mav.addObject("plist", service.productLike(PVO));
		}
		
		mav.addObject("pvo", PVO);
		mav.setViewName("/product");

		return mav;
	}
	
	//상품 정렬 (태그 리스트)
	@GetMapping("product_tag/{product_tag}/{sortType}")
	public ModelAndView productTagSort(@PathVariable("product_tag") String product_tag, @PathVariable("sortType") String sortType) {

		mav = new ModelAndView();

		ProductDTO dto = new ProductDTO();
		dto.setProductTag(product_tag);

		switch (sortType) {
			case "pricelist" -> //가격낮은순
				//List<ProductVO> list= service.productPriceAsc(PVO);
				//System.out.println(list.size());
					mav.addObject("plist", service.productPriceAsc(dto));
			case "pricelistdesc" -> //가격높은순
					mav.addObject("plist", service.productPriceDesc(dto));
			case "recentlist" -> //최신순
					mav.addObject("plist", service.productRecent(dto));
			default -> //좋아요순
					mav.addObject("plist", service.productLike(dto));
		}
		
		mav.addObject("pvo", dto);
		mav.setViewName("/product");

		return mav;
	}
}
