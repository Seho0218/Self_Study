package com.genie.myapp.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.genie.myapp.service.MbtiService;
import com.genie.myapp.vo.ProductVO;

@RestController
@RequestMapping("/")
public class MbtiController {
	
	@Inject
	MbtiService service;
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
		
		if(sortType.equals("pricelist")) {//가격낮은순
			mav.addObject("plist", service.pricelist(mbti));
		}else if(sortType.equals("pricelistdesc")) {//가격높은순
			mav.addObject("plist", service.pricelistdesc(mbti));
		}else if(sortType.equals("recentlist")) {//최신순
			mav.addObject("plist", service.recentlist(mbti));
		}else {//좋아요순
			mav.addObject("plist", service.likelist(mbti));
		}
		
		mav.setViewName("mbti/mbtiList");
		
		return mav;
	}
	
	//상품 정렬하기 (카테고리 list)
	@GetMapping("product/{product_category}/{sortType}")
	public ModelAndView productSort(@PathVariable("product_category") String product_category, @PathVariable("sortType") String sortType) {
		mav = new ModelAndView();
		System.out.println(sortType);
		
		ProductVO PVO = new ProductVO();
		PVO.setProduct_category(product_category);
		
		if(sortType.equals("pricelist")) {//가격낮은순
			//List<ProductVO> list= service.productPriceAsc(PVO);
			//System.out.println(list.size());
			mav.addObject("plist", service.productPriceAsc(PVO));
		}else if(sortType.equals("pricelistdesc")) {//가격높은순
			mav.addObject("plist", service.productPriceDesc(PVO));
		}else if(sortType.equals("recentlist")) {//최신순
			mav.addObject("plist", service.productRecent(PVO));
		}else {//좋아요순
			mav.addObject("plist", service.productLike(PVO));
		}
		
		mav.addObject("pvo", PVO);
		mav.setViewName("/product");

		return mav;
	}
	
	//상품 정렬 (전체 리스트)
	@GetMapping("product/{sortType}")
	public ModelAndView totalProductSort(@PathVariable("sortType") String sortType) {
		mav = new ModelAndView();
		System.out.println(sortType);
		
		ProductVO PVO = new ProductVO();
		
		if(sortType.equals("pricelist")) {//가격낮은순
			//List<ProductVO> list= service.productPriceAsc(PVO);
			//System.out.println(list.size());
			mav.addObject("plist", service.productPriceAsc(PVO));
		}else if(sortType.equals("pricelistdesc")) {//가격높은순
			mav.addObject("plist", service.productPriceDesc(PVO));
		}else if(sortType.equals("recentlist")) {//최신순
			mav.addObject("plist", service.productRecent(PVO));
		}else {//좋아요순
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
		System.out.println(sortType);
		
		ProductVO PVO = new ProductVO();
		PVO.setProduct_tag(product_tag);
		
		if(sortType.equals("pricelist")) {//가격낮은순
			//List<ProductVO> list= service.productPriceAsc(PVO);
			//System.out.println(list.size());
			mav.addObject("plist", service.productPriceAsc(PVO));
		}else if(sortType.equals("pricelistdesc")) {//가격높은순
			mav.addObject("plist", service.productPriceDesc(PVO));
		}else if(sortType.equals("recentlist")) {//최신순
			mav.addObject("plist", service.productRecent(PVO));
		}else {//좋아요순
			mav.addObject("plist", service.productLike(PVO));
		}
		
		mav.addObject("pvo", PVO);
		mav.setViewName("/product");

		return mav;
	}
}
