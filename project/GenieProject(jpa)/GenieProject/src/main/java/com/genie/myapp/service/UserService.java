package com.genie.myapp.service;

import com.genie.myapp.dto.*;
import com.genie.myapp.entity.Account.Account;
import com.genie.myapp.entity.Account.User;
import com.genie.myapp.entity.Address;
import com.genie.myapp.entity.Order;

import java.util.List;


public interface UserService {
	
	//아이디 중복검사
	public long idCheck(String genie_id);

	//회원가입
	public User UserWrite(User user);

	//로그인
	public UserDTO loginOk(UserDTO vo);
	//회원 선택: 로그인 한 회원
	public UserDTO getUser(String genie_id);
	//회원 정보 수정: DB 업데이트
	public int UserEditOk(UserDTO vo);
	//비밀번호 변경
	public int PwdEditOk(UserDTO vo);

	//배송지 추가
	public int Delivery(UserDTO vo);
	//배송지 등록
	public int addDelivery(UserDTO vo);
	//배송지 리스트 가져오기
	public List<Address> getDeliveryList(String genie_id);
	//배송지 삭제
	public int delDelivery(int address_num, String genie_id);

	//주문목록 가져오기
	public List<Order> getOrder(String genie_id);

	//찜한 상품 리스트
	public List<ProductDTO> getLikeList(String genie_id);
}
