package com.genie.myapp.service;

import com.genie.myapp.dto.*;
import com.genie.myapp.entity.Account.User;
import com.genie.myapp.entity.Address;
import com.genie.myapp.entity.MyOrder;

import java.util.List;

public interface UserService {
	
	//아이디 중복검사
	public long idCheck(String genie_id);

	//회원가입
	public User UserWrite(User user);

	//로그인
	public User loginOk(User vo);
	//회원 선택: 로그인 한 회원
	public User getUser(String genie_id);

	public UserDTO getMypage(String genie_id);

	//회원 정보 수정: DB 업데이트
	public int UserEditOk(UserDTO vo);
	//비밀번호 변경
	public int PwdEditOk(User vo);

	//배송지 등록
	public int addDelivery(Address vo);
	//배송지 리스트 가져오기
	public List<Address> getDeliveryList(String genie_id);
	//배송지 삭제
	public int delDelivery(int address_num);

	//주문목록 가져오기
	public List<MyOrder> getOrder(String genie_id);

	//찜한 상품 리스트
	public List<ProductDTO> getLikeList(String genie_id);
}
