package com.genie.myapp.service;

import java.util.List;

import com.genie.myapp.vo.AccountVO;
import com.genie.myapp.vo.DeliveryVO;
import com.genie.myapp.vo.OrderVO;
import com.genie.myapp.vo.ProductVO;
import com.genie.myapp.vo.UserVO;

public interface UserService {
	
	//아이디 중복검사
	public int idCheck(String genie_id);
	//어카운트 등록
	public int AccountWrite(AccountVO avo);
	//회원가입
	public int UserWrite(UserVO vo);

	//로그인
	public UserVO loginOk(UserVO vo);
	//회원 선택: 로그인 한 회원
	public UserVO getUser(String genie_id);
	//회원 정보 수정: DB 업데이트
	public int UserEditOk(UserVO vo);
	//비밀번호 변경
	public int PwdEditOk(UserVO vo);

	//배송지 추가
	public int Delivery(UserVO vo);
	//배송지 등록
	public int addDelivery(UserVO vo);
	//배송지 리스트 가져오기
	public List<DeliveryVO> getDeliveryList(String genie_id);
	//배송지 삭제
	public int delDelivery(int address_num, String genie_id);

	//주문목록 가져오기
	public List<OrderVO> getOrder(String genie_id);

	//찜한 상품 리스트
	public List<ProductVO> getLikeList(String genie_id);
}
