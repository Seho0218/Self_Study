package com.genie.myapp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import com.genie.myapp.dto.UserDTO;
import com.genie.myapp.repository.CertServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.genie.myapp.dao.CertDAO;

@Service
@Transactional
@RequiredArgsConstructor
public class CertServiceImpl implements CertService {
    
    public final JavaMailSender mailSender;
	public final CertDAO cdao;
	public final CertServiceRepository repository;


	@Override
	public List<String> FindId(String user_email) {
		return repository.FindId(user_email);
	}

	@Override
	public int PwdEditOk(UserDTO userDTO) {
		return repository.PwdEditOk(userDTO);
	}

	@Override
	public void sendUserId(String user_email, List<String> genieId) {
		SimpleMailMessage simpleMailMessage = new  SimpleMailMessage();
		simpleMailMessage.setTo(user_email);
		simpleMailMessage.setSubject("아이디 찾기");

		StringBuffer sb = new StringBuffer();
		sb.append("가입하신 아이디는");
		sb.append(System.lineSeparator());
		sb.append(genieId).append("입니다");//genieId.get(0)

		simpleMailMessage.setText(sb.toString());

		new Thread(() -> mailSender.send(simpleMailMessage)).start();
	}

//////////////////////////////////////////////////////////////////////

	@Override
	public int overlapCheck(String value, String valueType) {

		Map<String, String> map = new HashMap<>();
		map.put("value", value);
		map.put("valueType", valueType);
		
		return cdao.overlapCheck(value, valueType);
	}

	@Override
    public boolean emailCheck(String genieId, String user_email) {
        Map<String, Object> map = new HashMap<>();
        map.put("genieId", genieId);
        map.put("user_email", user_email);
        String result = cdao.emailCheck(map);
		return "1".equals(result);
	}

	@Override
	public void sendAuthNum(String user_email, String authNum) {
		SimpleMailMessage simpleMailMessage = new  SimpleMailMessage();
		simpleMailMessage.setTo(user_email);
		simpleMailMessage.setSubject("비밀번호 찾기 인증번호");
		
		String text = "인증번호는 " + authNum + "입니다";
		
		simpleMailMessage.setText(text);
		new Thread(() -> mailSender.send(simpleMailMessage)).start();
	}

}
