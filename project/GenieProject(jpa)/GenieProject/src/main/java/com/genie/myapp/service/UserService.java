package com.genie.myapp.service;

import com.genie.myapp.dto.*;

import java.util.List;

public interface UserService {

	
	//아이디 중복검사
	public long idCheck(String genie_id);

	//회원가입
	public void UserWrite(UserDTO userDTO);

	//로그인
	public UserDTO loginOk(UserDTO userDTO);
	//회원 선택: 로그인 한 회원
	public UserDTO getUser(UserDTO userDTO);

	//회원 정보 수정: DB 업데이트
	public void UserEditOk(UserDTO userDTO);

	//비밀번호 변경
	public void PwdEditOk(UserDTO userDTO);

	//배송지 등록
	public void addDelivery(AddressDTO addressDTO);
	//배송지 리스트 가져오기
	public List<AddressDTO> getDeliveryList(UserDTO userDTO);
	//배송지 삭제
	public void delDelivery(int addressNum);

	//주문목록 가져오기
	public List<OrderDTO> getOrder(UserDTO userDTO);

	//찜한 상품 리스트
	public List<ProductDTO> getLikeList(String genie_id);
}
