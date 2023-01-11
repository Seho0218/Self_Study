package com.genie.myapp.service;

import java.util.List;

import com.genie.myapp.dto.AccountDTO;
import com.genie.myapp.dto.DeliveryDTO;
import com.genie.myapp.dto.OrderDTO;
import com.genie.myapp.dto.ProductDTO;
import com.genie.myapp.dto.UserDTO;

public interface UserService {
	
	//아이디 중복검사
	public int idCheck(String genie_id);
	//어카운트 등록
	public int AccountWrite(AccountDTO adto);
	//회원가입
	public int UserWrite(UserDTO dto);

	//로그인
	public UserDTO loginOk(UserDTO dto);
	//회원 선택: 로그인 한 회원
	public UserDTO getUser(String genie_id);
	//회원 정보 수정: DB 업데이트
	public int UserEditOk(UserDTO dto);
	//비밀번호 변경
	public int PwdEditOk(UserDTO dto);

	//배송지 추가
	public int Delivery(UserDTO dto);
	//배송지 등록
	public int addDelivery(UserDTO dto);
	//배송지 리스트 가져오기
	public List<DeliveryDTO> getDeliveryList(String genie_id);
	//배송지 삭제
	public int delDelivery(int address_num, String genie_id);

	//주문목록 가져오기
	public List<OrderDTO> getOrder(String genie_id);

	//찜한 상품 리스트
	public List<ProductDTO> getLikeList(String genie_id);
}
