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
		System.out.println(mbti);
		System.out.println(sortType);

		switch (sortType) {
			case "pricelist": //가격낮은순
				mav.addObject("plist", service.pricelist(mbti));
				break;
			case "pricelistdesc": //가격높은순
				mav.addObject("plist", service.pricelistdesc(mbti));
				break;
			case "recentlist": //최신순
				mav.addObject("plist", service.recentlist(mbti));
				break;
			default: //좋아요순
				mav.addObject("plist", service.likelist(mbti));
				break;
		}
		
		mav.setViewName("mbti/mbtiList");
		
		return mav;
	}
	
	//상품 정렬하기 (카테고리 list)
	@GetMapping("product/{product_category}/{sortType}")
	public ModelAndView productSort(@PathVariable("product_category") String product_category, @PathVariable("sortType") String sortType) {

		mav = new ModelAndView();

		System.out.println("productCategory = " + product_category);

		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductCategory(product_category);

		switch (sortType) {
			case "pricelist": //가격낮은순
				//List<ProductVO> list= service.productPriceAsc(PVO);
				//System.out.println(list.size());
				mav.addObject("plist", service.productPriceAsc(productDTO));
				break;
			case "pricelistdesc": //가격높은순
				mav.addObject("plist", service.productPriceDesc(productDTO));
				break;
			case "recentlist": //최신순
				mav.addObject("plist", service.productRecent(productDTO));
				break;
			default: //좋아요순
				mav.addObject("plist", service.productLike(productDTO));
				break;
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
			case "pricelist": //가격낮은순
				//List<ProductVO> list= service.productPriceAsc(PVO);
				//System.out.println(list.size());
				mav.addObject("plist", service.productPriceAsc(PVO));
				break;
			case "pricelistdesc": //가격높은순
				mav.addObject("plist", service.productPriceDesc(PVO));
				break;
			case "recentlist": //최신순
				mav.addObject("plist", service.productRecent(PVO));
				break;
			default: //좋아요순
				mav.addObject("plist", service.productLike(PVO));
				break;
		}
		
		mav.addObject("pvo", PVO);
		mav.setViewName("/product");

		return mav;
	}
	
	//상품 정렬 (태그 리스트)
	@GetMapping("product_tag/{product_tag}/{sortType}")
	public ModelAndView productTagSort(@PathVariable("product_tag") String product_tag, @PathVariable("sortType") String sortType) {

		mav = new ModelAndView();
		System.out.println("productTag = " + product_tag);

		ProductDTO dto = new ProductDTO();
		dto.setProductTag(product_tag);

		switch (sortType) {
			case "pricelist": //가격낮은순
				//List<ProductVO> list= service.productPriceAsc(PVO);
				//System.out.println(list.size());
				mav.addObject("plist", service.productPriceAsc(dto));
				break;
			case "pricelistdesc": //가격높은순
				mav.addObject("plist", service.productPriceDesc(dto));
				break;
			case "recentlist": //최신순
				mav.addObject("plist", service.productRecent(dto));
				break;
			default: //좋아요순
				mav.addObject("plist", service.productLike(dto));
				break;
		}
		
		mav.addObject("pvo", dto);
		mav.setViewName("/product");

		return mav;
	}
}
