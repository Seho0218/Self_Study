package com.genie.myapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.genie.myapp.service.CertService;
import com.genie.myapp.vo.UserVO;

@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/cert/*")
public class CertController {

	@Autowired
	CertService CertService;

	@Autowired
    PasswordEncoder passwordEncoder;

	ModelAndView mav;
    
    @GetMapping("FindId")
	public ModelAndView FindId() {
		mav = new ModelAndView();
		mav.setViewName("/cert/FindId");

		return mav;
	}

	// 메일로 아이디 보내기
	@PostMapping("sendUserId")
	public ResponseEntity<Object> sendEmail(String user_email){
		List<String> genie_id =CertService.FindId(user_email);
	
		if(genie_id.size() != 0) {
			CertService.sendUserId(user_email, genie_id);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	///////////////////////////////////////////////////////

	@GetMapping("FindPwd")
	public ModelAndView FindPwd() {
		mav = new ModelAndView();
		mav.setViewName("/cert/FindPwd");
		
		return mav;
	}
	
	@GetMapping("overlapCheck")
	public int overlapCheck(String value, String valueType) {
//		value = 중복체크할 값
//		valeuType = username, nickname
		System.out.println(valueType);
		System.out.println(value);
		int count = CertService.overlapCheck(value, valueType);
		
		System.out.println(count);
		return count;
	}
	
	@GetMapping("emailCheck")
	public ResponseEntity<Boolean> emailCheck(String genie_id, String user_email){
		boolean emailCheck = CertService.emailCheck(genie_id, user_email);
        System.out.println("emailCheck "+ emailCheck );
		return new ResponseEntity<Boolean>(emailCheck, HttpStatus.OK);
	}
	
	
	// 인증번호 보내기 페이지
	@GetMapping("FindPwd_auth")
	public ModelAndView auth(String genie_id, HttpSession session) {

		mav = new ModelAndView();

		Map<String, Object> authStatus = (Map<String, Object>) session.getAttribute("authStatus");
    	if(authStatus == null || !genie_id.equals(authStatus.get("genie_id"))) {

			mav.setViewName("/cert/FindPwd");
			return mav;
   		}
		    mav.setViewName("/cert/FindPwd_auth");
		    return mav;
	}
	
	@PostMapping("FindPwd_auth")
	public ResponseEntity<Object> authenticateUser(String genie_id, HttpSession session) {

		Map<String, Object> authStatus = new HashMap<>();
		authStatus.put("genie_id", genie_id);
		authStatus.put("status", false);
		
		session.setMaxInactiveInterval(300);
		session.setAttribute("authStatus", authStatus);

		return new ResponseEntity<Object>(genie_id, HttpStatus.OK);
	}
	

	// 인증번호 보내기
	@PostMapping("authNum")
	private ResponseEntity<String> authNum(String user_email, HttpSession session){
		String authNum = "";
		for(int i=0;i<6;i++) {
			authNum += (int)(Math.random() * 10);
		}
		
		System.out.println("인증번호는 : " + authNum);
		System.out.println("이메일은 : " + user_email);
		
		if(user_email != null) {
			//System.out.println("이메일로 인증번호 보내기");
			CertService.sendAuthNum(user_email, authNum);
		}
		
		Map<String, Object> authNumMap = new HashMap<>();
    
		long createTime = System.currentTimeMillis();
		long endTime = createTime + (300 *1000);

		
		authNumMap.put("createTime", createTime);
		authNumMap.put("endTime", endTime);
		authNumMap.put("authNum", authNum);
		
		session.setMaxInactiveInterval(300);
		session.setAttribute("authNum", authNumMap);
		
		return new ResponseEntity<String>("인증번호가 전송되었습니다", HttpStatus.OK);
	}

	// 인증번호가 맞는지 확인
	@PostMapping("authNumCheck")
	private ResponseEntity<String> authNumCheck(String authNum, HttpSession session){

		Map<String, Object> sessionAuthNumMap = (Map<String, Object>) session.getAttribute("authNum");
		String msg = "";
		
		if(sessionAuthNumMap == null) {
			msg = "인증번호를 전송해주세요";
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
		
		// 인증번호 만료시간
		long endTime = (long) sessionAuthNumMap.get("endTime");
		
		// 현재시간이 만료시간이 지났다면
		if(System.currentTimeMillis() > endTime) {
			msg = "인증시간이 만료되었습니다";
			session.setAttribute(authNum, null);
			session.setMaxInactiveInterval(0);
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
		
		// 인증번호
		String sessionAuthNum = (String) sessionAuthNumMap.get("authNum");
		// System.out.println("chekc.authNum-"+authNum);
		// System.out.println("chekc.sessionAuthNum-"+sessionAuthNum);
		if(!authNum.equals(sessionAuthNum)) {
			msg = "인증번호가 일치하지 않습니다";
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		} else {
			// 인증번호가 일치하면
			return new ResponseEntity<String>(HttpStatus.OK);
		}
	}

	// 인증 완료 후

	@PostMapping("authCOM")
	public ResponseEntity<String> authCompletion(HttpSession session) {
		Map<String, Object> authStatus = (Map<String, Object>) session.getAttribute("authStatus");
		if(authStatus == null) {
			return new ResponseEntity<String>("인증시간이 만료되었습니다", HttpStatus.BAD_REQUEST);
		}
		authStatus.put("status", true);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	// 비밀번호 변경 페이지
	@GetMapping("modify_pwd")
	public ModelAndView modifyPassword(String genie_id, HttpSession session) {
		Map<String, Object> authStatus = (Map<String, Object>) session.getAttribute("authStatus");

		mav = new ModelAndView();

		if(authStatus == null || !genie_id.equals(authStatus.get("genie_id"))) {

			mav.setViewName("/cert/FindPwd");
			return mav;
		}
		
			mav.setViewName("/cert/modify_pwd");
			mav.addObject("genie_id",genie_id);
			
			return mav;
	}


	// 비밀번호 변경
	@PostMapping("modify_pwd")
	public ResponseEntity<String> modifyPassword(UserVO vo, HttpSession session) {

		String enPw=passwordEncoder.encode(vo.getGenie_pwd());
		vo.setGenie_pwd(enPw);

		int cnt = CertService.PwdEditOk(vo);
		System.out.print(cnt);

		return new ResponseEntity<String>("비밀번호를 변경했습니다",HttpStatus.OK);
	}


	
}
