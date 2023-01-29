package com.genie.myapp.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.genie.myapp.service.SellerService;

import com.genie.myapp.dto.SellerProductDTO;
import com.genie.myapp.dto.OrderDTO;
import com.genie.myapp.dto.PagingDTO;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import static java.nio.charset.StandardCharsets.*;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/seller/*")
public class SellerController {

	public final SellerService service;

	ModelAndView mav = null;
	
	// Seller(UI 참고용)
	@GetMapping("sellerHome")
	public ModelAndView sellerHome() {
		mav = new ModelAndView();
		mav.setViewName("seller/sellerHome");
		return mav;
	}

	// Seller 메인페이지
	@GetMapping("sellerMain")
	public ModelAndView sellerMain(HttpServletRequest request) {
		String seller_id = ((String)request.getSession().getAttribute("logId")); //세션 셀러 아이디
		mav = new ModelAndView();

		int torder = service.todayOrder(seller_id); // 오늘 들어온 주문 
		int devp = service.deliveryPending(seller_id); 
		String bs = service.bestSeller(seller_id); // 이달의 상품
		int osum = service.orderSum(seller_id); //총매출(이번달)
	
		List<OrderDTO> rlist = service.revenueByProduct(seller_id); // 아이템별 매출
		String ss = service.sellerStatus(seller_id); // 셀러상태 

		// 일별매출
		// 쿼리로 받은 '범주(month_day)':'값(total_sales)' 형태의 리스트 데이터 추출
		List<OrderDTO> orderlist = service.orderSumByDay(seller_id);
		// 리스트를 Json 객체로 옮겨담기
		// java 에서 json 객체를 다루기 쉽도록 gson 라이브러리 이용
		Gson gson = new Gson(); // json 으로 가공하기 위해 빈 gson 객체생성
		JsonArray jArray = new JsonArray(); // json 형태로 여러개의 데이터를 담기위해 JsonArray 객체 생성

		// 반복자 얻기
		for (OrderDTO orderDTO : orderlist) { // 하나하나의 DTO 에서 데이터 추출, json 형태로 가공
			JsonObject object = new JsonObject();
			String date = orderDTO.getMonthDay();
			int sales = orderDTO.getTotalSales();

			object.addProperty("date", date);
			object.addProperty("sales", sales);

			jArray.add(object); // json 배열 객체 생성
		}
		String json = gson.toJson(jArray); // 사용가능한 json 데이터 형태로 변환

		// 카테고리별 판매건수
		List<OrderDTO> categorylist = service.topCategory(seller_id);

		JsonArray jArray2 = new JsonArray();
		for (OrderDTO ovo2 : categorylist) {
			JsonObject object2 = new JsonObject();
			String category = ovo2.getProductCategory();
			int sold_counts = ovo2.getSoldCounts();

			object2.addProperty("category", category);
			object2.addProperty("sold_counts", sold_counts);

			jArray2.add(object2);
		}
		String json2 = gson.toJson(jArray2);


		if(ss.equals("Y")) {
			mav.addObject("json", json); // 일별매출

			mav.addObject("todayOrder", torder); // 오늘 들어온 주문
			mav.addObject("deliveryPending", devp);
			mav.addObject("bestSeller", bs); // 이달의 상품
			
			mav.addObject("revenueByProduct", rlist); // 아이템별 매출
			
			mav.addObject("json2", json2); // 카테고리별 판매건수

			mav.addObject("orderSum", osum); // 총매출(이번달)

			mav.setViewName("seller/sellerMain");
			
		}else if(ss.equals("N")){

			mav.setViewName("seller/sellerMain2");
		}
		return mav;
	}

	

	
	// Seller 주문관리 
	@GetMapping("sellerOrder")
	public ModelAndView sellerOrder(OrderDTO vo, HttpServletRequest request) {
		String seller_id = ((String)request.getSession().getAttribute("logId")); //세션 셀러 아이디
		
		// 배송대기 중 
		int devp = service.deliveryPending(seller_id); 
		// 오늘 들어온 주문 
		int torder = service.todayOrder(seller_id);
		// 배송 중
		int deo= service.deliveringOrder(seller_id);
	
		mav = new ModelAndView();
		mav.addObject("list", service.sellerOrder(vo, seller_id));

		//mav.addObject("dList", service.deliveredOrder(vo, seller_id));

		mav.addObject("deliveryPending", devp); // 배송대기 중
		mav.addObject("todayOrder", torder); // 오늘 들어온 주문
		mav.addObject("deliveringOrder", deo); // 배송 중 

	

		mav.setViewName("seller/sellerOrder");
	
		return mav;
	}

	//Seller 배송완료
	
	@PostMapping("sellerOrder1")
	public List<OrderDTO> sellerOrder1(HttpServletRequest request) {
		String seller_id = ((String)request.getSession().getAttribute("logId")); //세션 셀러 아이디
		

		return service.deliveredOrder(seller_id);

	
	}
	

	// 주문목록 배송상태 수정
	@PostMapping("updateDeliveryStatus") // @RequestParam 을 이용해 Map에 전송된 매개변수 이름을 key, 값을 value 로 저장
	public ResponseEntity<String> updateDeliveryStatus(@RequestParam Map<String, String> deliveryMap // Ajax로 전달받은 배송상태를 Map에 저장
												){
		service.updateDeliveryStatus(deliveryMap); // 배송상태를 변경 
		String msg;
		ResponseEntity<String> resEntity;
		HttpHeaders responseHeaders = new HttpHeaders();
		msg = "mod_success";
		resEntity = new ResponseEntity<>(msg, responseHeaders, OK);
		return resEntity;
	}
	
	// Seller 매출관리 페이지
	@GetMapping("sellerSales")
	public ModelAndView sellerSales(HttpServletRequest request) {
		String seller_id = (String)request.getSession().getAttribute("logId"); // 세션 셀러 아이디
		
		mav = new ModelAndView();
		
		int osum = service.orderSum(seller_id); 
		int ocnt = service.orderCount(seller_id); 
		String bs = service.bestSeller(seller_id);
		
		// 쿼리로 받은 '범주(month_day)':'값(total_sales)' 형태의 리스트 데이터 추출
		List<OrderDTO> orderlist = service.orderSumByDay(seller_id);
		
		// 리스트를 Json 객체로 옮겨담기
		// java 에서 json 객체를 다루기 쉽도록 gson 라이브러리 이용
		Gson gson = new Gson(); // json 으로 가공하기 위해 빈 gson 객체생성
		JsonArray jArray = new JsonArray(); // json 형태로 여러개의 데이터를 담기위해 JsonArray 객체 생성

		// 반복자 얻기
		for (OrderDTO ovo : orderlist) { // 하나하나의 DTO 에서 데이터 추출, json 형태로 가공
			JsonObject object = new JsonObject();
			String date = ovo.getMonthDay();
			int sales = ovo.getTotalSales();


			object.addProperty("date", date);
			object.addProperty("sales", sales);

			jArray.add(object); // json 배열 객체 생성
		}
		
		String json = gson.toJson(jArray); // 사용가능한 json 데이터 형태로 변환
		mav.addObject("json", json); // 일별매출
		
		mav.addObject("orderSum", osum); // 총매출(이번달)
		mav.addObject("orderCount", ocnt); // 총결제건수
		mav.addObject("bestSeller", bs); // 이달의 상품
		mav.setViewName("seller/sellerSales");
		return mav;
	}
	
	//업체 상품등록 폼 보기
	@GetMapping("productForm")
	public ModelAndView productForm() {
		mav = new ModelAndView();
		mav.setViewName("seller/sellerProductForm");
		return mav;
	}
	
	//seller 상품관리 페이지
	@GetMapping("sellerProduct")
	public ModelAndView sellerProduct(PagingDTO pDTO, HttpServletRequest request) {
		
		pDTO.setGenie_id((String)request.getSession().getAttribute("logId"));
		pDTO.setTotalRecord(service.productTotalRecord(pDTO));
		pDTO.setOnePageRecord(10);
		
		mav = new ModelAndView();
		mav.addObject("plist", service.productList(pDTO));
		mav.addObject("pDTO", pDTO);
		
		mav.setViewName("seller/sellerProduct");
		return mav;
	}
	
	//seller 상품등록
	@PostMapping("productWrite")
	public ResponseEntity<String> productWrite(SellerProductDTO sellerProductDTO, HttpServletRequest request){
		sellerProductDTO.setGenieId((String)request.getSession().getAttribute("logId")); //세션 로그인 아이디
		 
		ResponseEntity<String> entity;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text","html", UTF_8));
		headers.add("Content-Type", "text/html; charset=utf-8");
		
		try {//상품등록 성공
			service.productWrite(sellerProductDTO);
			
			String msg = "<script>";
			msg += "alert('상품이 등록되었습니다.');";
			msg += "location.href='/seller/sellerProduct';";
			msg += "</script>";
			entity = new ResponseEntity<>(msg,headers, OK);
			
		}catch(Exception e) {//상품등록 실패
			
			String msg = "<script>";
			msg += "alert('상품등록이 실패하였습니다.');";
			msg += "history.back();";
			msg += "</script>";
			entity = new ResponseEntity<>(msg,headers, BAD_REQUEST);
			
			e.printStackTrace();
		}
		return entity;
	}
	
	//seller 상품수정 페이지로 이동
	@GetMapping("sellerProductEdit/{productId}")
	public ModelAndView sellerProductEdit(@PathVariable("productId") int pid) {
		mav = new ModelAndView();
		
		mav.addObject("pvo", service.getProduct(pid));
		mav.setViewName("seller/sellerProductEdit");
		
		return mav;
	}
	
	//seller 상품수정 : DB 업데이트
	@PostMapping("productEditOk")
	public ResponseEntity<String> productEditOk(SellerProductDTO sellerProductDTO, HttpSession session){

		sellerProductDTO.setGenieId((String)session.getAttribute("logId"));
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text","html", UTF_8));
		headers.add("Content-Type", "text/html; charset=UTF-8");
		String msg = "<script>";
		
		try {//수정성공 - 상품관리로 이동
			service.productEditOk(sellerProductDTO);
			
			msg += "alert('상품이 수정되었습니다. 상품관리 페이지로 이동합니다. ');";
			msg += "location.href='/seller/sellerProduct';";
			
		}catch(Exception e){//수정실패 - 수정폼으로 이동
			e.printStackTrace();
			
			msg += "alert('상품수정이 실패하였습니다.');";
			msg += "history.go(-1);";
		}
		msg += "</script>";

		return new ResponseEntity<>(msg, headers, OK);
	}
	
	//seller 상품삭제 : DB
	@GetMapping("productDel/{productId}")
	public ModelAndView productDel(@PathVariable("productId") int pid) {
		//System.out.println(pid);
		int result = service.productDel(pid);
		
		mav = new ModelAndView();
		if(result>0) {//삭제
			mav.setViewName("redirect:/seller/sellerProduct");
		}else {//삭제실패
			mav.setViewName("redirect:/seller/sellerProduct");
		}
		return mav;
	}
	
}
