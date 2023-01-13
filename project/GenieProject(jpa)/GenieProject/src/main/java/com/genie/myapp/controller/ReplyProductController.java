package com.genie.myapp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.genie.myapp.dto.LikeDTO;
import com.genie.myapp.dto.ProductDTO;
import com.genie.myapp.dto.ReplyProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.genie.myapp.service.ReplyProductService;


@RestController
@RequestMapping("/reply/*")
public class ReplyProductController{

    @Autowired
    ReplyProductService service;

    @GetMapping("replyProductList")
    public List<ReplyProductDTO> replyProductList(int no){
        return service.replyProductList(no);
    }
    
    @PostMapping("replyProductWrite")
	public int replyWrite(ReplyProductDTO dto, HttpSession session) {
		dto.setGenie_id((String)session.getAttribute("logId")); // 작성자	
		return service.replyProductWrite(dto);
	}

 	@PostMapping("replyProductEdit")
 	public int replyEdit (ReplyProductDTO dto, HttpSession session) {
 		dto.setGenie_id((String)session.getAttribute("logId"));
 		return service.replyProductEdit(dto);
 	}
 	
 	@GetMapping("replyProductDel")
 	public int replyDel(int reply_no, HttpSession session) {
 		String genie_id = (String)session.getAttribute("logId");
 		return service.replyProductDelete(reply_no, genie_id);
 	}

	@PostMapping("likeInsert")
	public int likeInsert(LikeDTO dto, HttpSession session){
		dto.setGenie_id((String)session.getAttribute("logId"));
        System.out.println(dto.toString());

		return service.likeInsert(dto);
	}

	@GetMapping("likeStatus")
 	public int likeStatus(LikeDTO dto, HttpSession session) {
 		dto.setGenie_id((String)session.getAttribute("logId"));
 		int cnt = service.likeStatus(dto);
 		int result = 0;
 		if (cnt>0) {
 			service.likeDelete(dto);
 			service.likeHitMinus(dto);
 			result = 100;
 		} else {
 			service.likeInsert(dto);
 			service.likeHitPlus(dto);
 			result = 200;
 		}
		return result;
 	}
	
	@GetMapping("likeDel/{product_id}")
	public ModelAndView likeDel(@PathVariable("product_id") int pid, HttpSession session) {
		
		LikeDTO dto = new LikeDTO();
		dto.setGenie_id((String)session.getAttribute("logId"));
		dto.setProduct_id(pid);
		
		ProductDTO pdto = new ProductDTO();
		pdto.setProduct_id(pid);
		
		int result = service.likeDelete(dto);
		int result2 = service.likeHitMinus(dto);
		
		ModelAndView mav = new ModelAndView();
		if(result>0 && result2>0) {
			mav.setViewName("redirect:/user/MyLikeList");
		}else {
			mav.setViewName("redirect:/user/MyLikeList");
		}
		return mav;
	}
}