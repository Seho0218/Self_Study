package com.genie.myapp.dao;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.genie.myapp.dto.AccountDTO;
import com.genie.myapp.dto.DeliveryDTO;
import com.genie.myapp.dto.OrderDTO;
import com.genie.myapp.dto.ProductDTO;
import com.genie.myapp.dto.UserDTO;

@Mapper
@Repository
public interface UserDAO {


	//로그인
	public UserDTO loginOk(UserDTO vo);
	//회원 선택: 로그인 한 회원
	public UserDTO getUser(String genie_id);
	//회원 정보 수정: DB 업데이트
	public int UserEditOk(UserDTO vo);
	//비밀번호 변경
	public int PwdEditOk(UserDTO vo);

	//배송지 등록
	public int addDelivery(UserDTO vo);
	//배송지 리스트 가져오기
	public List<DeliveryDTO> getDeliveryList(String genie_id);
	//배송지 삭제
	public int delDelivery(int address_num, String genie_id);

	//주문목록 가져오기
	public List<OrderDTO> getOrder(String genie_id);
	
	//찜한 상품 리스트
	public List<ProductDTO> getLikeList(String genie_id);

	public Optional<AccountDTO> findByGenie_id(String Genie_id);
}
