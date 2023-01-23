package com.genie.myapp.dao;

import java.util.List;

import com.genie.myapp.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDAO {

	//배송지 등록
	public int addDelivery(AddressDTO vo);

	public UserDTO getMypage(String dto);
	
	//찜한 상품 리스트
	public List<ProductDTO> getLikeList(String genie_id);

}
