package com.genie.myapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.genie.myapp.dto.UserDTO;
import lombok.RequiredArgsConstructor;
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

@RestController
@RequestMapping("/cert/*")
@RequiredArgsConstructor
public class CertController {

	public final CertService certService;
	public final PasswordEncoder passwordEncoder;

	ModelAndView mav;
    
    @GetMapping("FindId")
	public ModelAndView FindId() {
		mav = new ModelAndView();
		mav.setViewName("/cert/FindId");

		return mav;
	}

	// 메일로 아이디 보내기
	@PostMapping("sendUserId")
	public ResponseEntity<Object> sendEmail(String userEmail){
		List<String> genieId =certService.FindId(userEmail);
	
		if(genieId.size() != 0) {
			certService.sendUserId(userEmail, genieId);
		}
		return new ResponseEntity<>(HttpStatus.OK);
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
//		valueType = username, nickname
		System.out.println(valueType);
		System.out.println(value);
		int count = certService.overlapCheck(value, valueType);
		
		System.out.println(count);
		return count;
	}
	
	@GetMapping("emailCheck")
	public ResponseEntity<Boolean> emailCheck(String genieId, String userEmail){
		boolean emailCheck = certService.emailCheck(genieId, userEmail);
        System.out.println("emailCheck "+ emailCheck );
		return new ResponseEntity<>(emailCheck, HttpStatus.OK);
	}
	
	
	// 인증번호 보내기 페이지
	@GetMapping("FindPwd_auth")
	public ModelAndView auth(String genieId, HttpSession session) {

		mav = new ModelAndView();

		Map<String, Object> authStatus = (Map<String, Object>) session.getAttribute("authStatus");
    	if(authStatus == null || !genieId.equals(authStatus.get("genieId"))) {

			mav.setViewName("/cert/FindPwd");
			return mav;
   		}
		    mav.setViewName("/cert/FindPwd_auth");
		    return mav;
	}
	
	@PostMapping("FindPwd_auth")
	public ResponseEntity<Object> authenticateUser(String genieId, HttpSession session) {

		Map<String, Object> authStatus = new HashMap<>();
		authStatus.put("genieId", genieId);
		authStatus.put("status", false);
		
		session.setMaxInactiveInterval(300);
		session.setAttribute("authStatus", authStatus);

		return new ResponseEntity<>(genieId, HttpStatus.OK);
	}


	// 인증번호 보내기
	@PostMapping("authNum")
	private ResponseEntity<String> authNum(String userEmail, HttpSession session){
		String authNum = "";
		for(int i=0;i<6;i++) {
			authNum += (int)(Math.random() * 10);
		}
		
		System.out.println("인증번호는 : " + authNum);
		System.out.println("이메일은 : " + userEmail);
		
		if(userEmail != null) {
			//System.out.println("이메일로 인증번호 보내기");
			certService.sendAuthNum(userEmail, authNum);
		}
		
		Map<String, Object> authNumMap = new HashMap<>();
    
		long createTime = System.currentTimeMillis();
		long endTime = createTime + (300 *1000);

		
		authNumMap.put("createTime", createTime);
		authNumMap.put("endTime", endTime);
		authNumMap.put("authNum", authNum);
		
		session.setMaxInactiveInterval(300);
		session.setAttribute("authNum", authNumMap);
		
		return new ResponseEntity<>("인증번호가 전송되었습니다", HttpStatus.OK);
	}

	// 인증번호가 맞는지 확인
	@PostMapping("authNumCheck")
	private ResponseEntity<String> authNumCheck(String authNum, HttpSession session){

		Map<String, Object> sessionAuthNumMap = (Map<String, Object>) session.getAttribute("authNum");
		String msg;
		
		if(sessionAuthNumMap == null) {
			msg = "인증번호를 전송해주세요";
			return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
		}
		
		// 인증번호 만료시간
		long endTime = (long) sessionAuthNumMap.get("endTime");
		
		// 현재시간이 만료시간이 지났다면
		if(System.currentTimeMillis() > endTime) {
			msg = "인증시간이 만료되었습니다";
			session.setAttribute(authNum, null);
			session.setMaxInactiveInterval(0);
			return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
		}
		
		// 인증번호
		String sessionAuthNum = (String) sessionAuthNumMap.get("authNum");
		// System.out.println("check.authNum-"+authNum);
		// System.out.println("check.sessionAuthNum-"+sessionAuthNum);
		if(!authNum.equals(sessionAuthNum)) {
			msg = "인증번호가 일치하지 않습니다";
			return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
		} else {
			// 인증번호가 일치하면
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	// 인증 완료 후

	@PostMapping("authCOM")
	public ResponseEntity<String> authCompletion(HttpSession session) {
		Map<String, Object> authStatus = (Map<String, Object>) session.getAttribute("authStatus");
		if(authStatus == null) {
			return new ResponseEntity<>("인증시간이 만료되었습니다", HttpStatus.BAD_REQUEST);
		}
		authStatus.put("status", true);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// 비밀번호 변경 페이지
	@GetMapping("modify_pwd")
	public ModelAndView modifyPassword(String genieId, HttpSession session) {
		Map<String, Object> authStatus = (Map<String, Object>) session.getAttribute("authStatus");

		mav = new ModelAndView();

		if(authStatus == null || !genieId.equals(authStatus.get("genieId"))) {

			mav.setViewName("/cert/FindPwd");
			return mav;
		}
		
			mav.setViewName("/cert/modify_pwd");
			mav.addObject("genieId",genieId);
			
			return mav;
	}


	// 비밀번호 변경
	@PostMapping("modify_pwd")
	public ResponseEntity<String> modifyPassword(UserDTO userDTO) {

		String enPw=passwordEncoder.encode(userDTO.getGeniePwd());
		userDTO.setGeniePwd(enPw);

		int cnt = certService.PwdEditOk(userDTO);
		System.out.print(cnt);

		return new ResponseEntity<>("비밀번호를 변경했습니다",HttpStatus.OK);
	}


	
}
