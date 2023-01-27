package com.genie.myapp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.genie.myapp.dto.LikeDTO;
import com.genie.myapp.dto.ProductDTO;
import com.genie.myapp.dto.ReplyProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.genie.myapp.service.ReplyProductService;


@RestController
@RequestMapping("/reply/*")
@RequiredArgsConstructor
public class ReplyProductController{

    public final ReplyProductService service;

    @GetMapping("replyProductList")
    public List<ReplyProductDTO> replyProductList(int no){
        return service.replyProductList(no);
    }
    
    @PostMapping("replyProductWrite")
	public int replyWrite(ReplyProductDTO replyProductDTO, HttpSession session) {
		replyProductDTO.setGenieId((String)session.getAttribute("logId")); // 작성자
		return service.replyProductWrite(replyProductDTO);
	}

 	@PostMapping("replyProductEdit")
 	public int replyEdit (ReplyProductDTO replyProductDTO, HttpSession session) {
		replyProductDTO.setGenieId((String)session.getAttribute("logId"));
 		return service.replyProductEdit(replyProductDTO);
 	}
 	
 	@GetMapping("replyProductDel")
 	public int replyDel(int reply_no, HttpSession session) {
 		String genie_id = (String)session.getAttribute("logId");
 		return service.replyProductDelete(reply_no, genie_id);
 	}

	@PostMapping("likeInsert")
	public int likeInsert(LikeDTO likeDTO, HttpSession session){
		likeDTO.setGenieId((String)session.getAttribute("logId"));

		return service.likeInsert(likeDTO);
	}

	@GetMapping("likeStatus")
 	public int likeStatus(LikeDTO likeDTO, HttpSession session) {
		likeDTO.setGenieId((String)session.getAttribute("logId"));
 		int cnt = service.likeStatus(likeDTO);
 		int result;
 		if (cnt>0) {
 			service.likeDelete(likeDTO);
 			service.likeHitMinus(likeDTO);
 			result = 100;
 		} else {
 			service.likeInsert(likeDTO);
 			service.likeHitPlus(likeDTO);
 			result = 200;
 		}
		return result;
 	}
	
	@GetMapping("likeDel/{productId}")
	public ModelAndView likeDel(@PathVariable("productId") int pid, HttpSession session) {
		
		LikeDTO likeDTO = new LikeDTO();
		likeDTO.setGenieId((String)session.getAttribute("logId"));
		likeDTO.setProductId(pid);
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductId(pid);
		
		int result = service.likeDelete(likeDTO);
		int result2 = service.likeHitMinus(likeDTO);
		
		ModelAndView mav = new ModelAndView();
		if(result>0 && result2>0) {
			mav.setViewName("redirect:/user/MyLikeList");
		}else {
			mav.setViewName("redirect:/user/MyLikeList");
		}
		return mav;
	}
}