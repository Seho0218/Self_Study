package com.genie.myapp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.genie.myapp.service.ReplyProductService;
import com.genie.myapp.vo.LikeVO;
import com.genie.myapp.vo.ProductVO;
import com.genie.myapp.vo.ReplyProductVO;

@RestController
@RequestMapping("/reply/*")
public class ReplyProductController{

    @Autowired
    ReplyProductService service;

    @GetMapping("replyProductList")
    public List<ReplyProductVO> replyProductList(int no){
        return service.replyProductList(no);
    }
    
    @PostMapping("replyProductWrite")
	public int replyWrite(ReplyProductVO vo, HttpSession session) {
		vo.setGenie_id((String)session.getAttribute("logId")); // 작성자	
		return service.replyProductWrite(vo);
	}

 	@PostMapping("replyProductEdit")
 	public int replyEdit (ReplyProductVO vo, HttpSession session) {
 		vo.setGenie_id((String)session.getAttribute("logId"));
 		return service.replyProductEdit(vo);
 	}
 	
 	@GetMapping("replyProductDel")
 	public int replyDel(int reply_no, HttpSession session) {
 		String genie_id = (String)session.getAttribute("logId");
 		return service.replyProductDelete(reply_no, genie_id);
 	}

	@PostMapping("likeInsert")
	public int likeInsert(LikeVO vo, HttpSession session){
		vo.setGenie_id((String)session.getAttribute("logId"));
        System.out.println(vo.toString());

		return service.likeInsert(vo);
	}

	@GetMapping("likeStatus")
 	public int likeStatus(LikeVO vo, HttpSession session) {
 		vo.setGenie_id((String)session.getAttribute("logId"));
 		int cnt = service.likeStatus(vo);
 		int result = 0;
 		if (cnt>0) {
 			service.likeDelete(vo);
 			service.likeHitMinus(vo);
 			result = 100;
 		} else {
 			service.likeInsert(vo);
 			service.likeHitPlus(vo);
 			result = 200;
 		}
		return result;
 	}
	
	@GetMapping("likeDel/{product_id}")
	public ModelAndView likeDel(@PathVariable("product_id") int pid, HttpSession session) {
		
		LikeVO vo = new LikeVO();
		vo.setGenie_id((String)session.getAttribute("logId"));
		vo.setProduct_id(pid);
		
		ProductVO pvo = new ProductVO();
		pvo.setProduct_id(pid);
		
		int result = service.likeDelete(vo);
		int result2 = service.likeHitMinus(vo);
		
		ModelAndView mav = new ModelAndView();
		if(result>0 && result2>0) {
			mav.setViewName("redirect:/user/MyLikeList");
		}else {
			mav.setViewName("redirect:/user/MyLikeList");
		}
		return mav;
	}
}