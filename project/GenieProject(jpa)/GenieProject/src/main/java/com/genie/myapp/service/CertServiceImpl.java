package com.genie.myapp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import com.genie.myapp.dto.AccountDTO;
import com.genie.myapp.repository.CertServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.genie.myapp.dao.CertDAO;

@Service
@Transactional
@RequiredArgsConstructor
public class CertServiceImpl implements CertService {

	public final JavaMailSender mailSender;
	public final CertDAO cdao;
	public final CertServiceRepository repository;

	public final PasswordEncoder passwordEncoder;


	@Override
	public List<String> FindId(String userEmail) {
		return repository.FindId(userEmail);
	}

	@Override
	public void PwdEditOk(AccountDTO accountDTO) {

		String enPw=passwordEncoder.encode(accountDTO.getChangedPwd());
		accountDTO.setChangedPwd(enPw);

        repository.PwdEditOk(accountDTO);
    }

	@Override
	public void sendUserId(String userEmail, List<String> genie_id) {
		SimpleMailMessage simpleMailMessage = new  SimpleMailMessage();
		simpleMailMessage.setTo(userEmail);
		simpleMailMessage.setSubject("아이디 찾기");

		String sb = "가입하신 아이디는" +
				System.lineSeparator() +
				genie_id + "입니다";//genie_id.get(0)

		simpleMailMessage.setText(sb);

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
	public boolean emailCheck(String genie_id, String userEmail) {
		Map<String, Object> map = new HashMap<>();
		map.put("genie_id", genie_id);
		map.put("userEmail", userEmail);
		String result = cdao.emailCheck(map);
		return "1".equals(result);
	}

	@Override
	public void sendAuthNum(String userEmail, String authNum) {
		SimpleMailMessage simpleMailMessage = new  SimpleMailMessage();
		simpleMailMessage.setTo(userEmail);
		simpleMailMessage.setSubject("비밀번호 찾기 인증번호");

		String text = "인증번호는 " + authNum + "입니다";

		simpleMailMessage.setText(text);
		new Thread(() -> mailSender.send(simpleMailMessage)).start();
	}

}
