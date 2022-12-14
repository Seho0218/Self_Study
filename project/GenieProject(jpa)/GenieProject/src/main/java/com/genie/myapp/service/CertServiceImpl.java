package com.genie.myapp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import com.genie.myapp.repository.CertJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.genie.myapp.dto.UserDTO;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CertServiceImpl implements CertService {
    
    @Autowired private JavaMailSender mailSender;
	
	@Inject CertJpaRepository repository;

	@Override
	public List<String> FindId(String user_email) {
		return repository.FindId(user_email);
	}
	
	@Override
	public void sendUserId(String user_email, List<String> genie_id) {
		SimpleMailMessage simpleMailMessage = new  SimpleMailMessage();
		simpleMailMessage.setTo(user_email);
		simpleMailMessage.setSubject("아이디 찾기");
		
		StringBuffer sb = new StringBuffer();
		sb.append("가입하신 아이디는");
		sb.append(System.lineSeparator());
		
		for(int i=0;i<genie_id.size()-1;i++) {
			sb.append(genie_id.get(i));
			sb.append(System.lineSeparator());
		}
		sb.append(genie_id.get(genie_id.size()-1)).append("입니다");
		
		simpleMailMessage.setText(sb.toString());
		
		
		new Thread(() -> mailSender.send(simpleMailMessage)).start();
	}



//////////////////////////////////////////////////////////////////////

	@Override
	public int overlapCheck(String value, String valueType) {

		Map<String, String> map = new HashMap<>();
		map.put("value", value);
		map.put("valueType", valueType);
		
		return repository.overlapCheck(value, valueType);
	}

	@Override
    public boolean emailCheck(String genie_id, String user_email) {

        Map<String, Object> map = new HashMap<>();
        map.put("genie_id", genie_id);
        map.put("user_email", user_email);
        String result = repository.emailCheck(map);
		return "1".equals(result);
	}

	@Override
	public void sendAuthNum(String user_email, String authNum) {
		
		SimpleMailMessage simpleMailMessage = new  SimpleMailMessage();
		simpleMailMessage.setTo(user_email);
		simpleMailMessage.setSubject("비밀번호 찾기 인증번호");
		
		String text = "인증번호는 " + authNum + "입니다";
		
		simpleMailMessage.setText(text);
		new Thread(new Runnable() {
			public void run() {
				mailSender.send(simpleMailMessage);
			}
		}).start();	
	}

	@Override
	public long PwdEditOk(UserDTO dto) {
		return repository.PwdEditOk(dto);
	}




}
