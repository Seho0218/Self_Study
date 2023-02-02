package com.genie.myapp.service;

import com.genie.myapp.dto.*;

import java.util.List;

public interface UserService {

	
	//아이디 중복검사
	long idCheck(String genie_id);

	//이메일 중복검사
	long emailCheck(UserDTO userDTO);

	//회원가입
	void UserWrite(UserDTO userDTO);

	//로그인
	AccountDTO loginOk(AccountDTO accountDTO);
	//회원 선택: 로그인 한 회원
	UserDTO getUser(AccountDTO accountDTO);

	//회원 정보 수정: DB 업데이트
	void UserEditOk(UserDTO userDTO);

	//비밀번호 변경
	void PwdEditOk(AccountDTO accountDTO);

	//배송지 등록
	void addDelivery(AddressDTO addressDTO);
	//배송지 리스트 가져오기
	List<AddressDTO> getDeliveryList(UserDTO userDTO);
	//배송지 삭제
	void delDelivery(int addressNum);

	//주문목록 가져오기
	List<OrderDTO> getOrder(UserDTO userDTO);

	//찜한 상품 리스트
	List<ProductDTO> getLikeList(String genie_id);
}
