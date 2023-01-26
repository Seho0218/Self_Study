package com.genie.myapp.dto;

import com.genie.myapp.Config.CustomerModelMapper;
import com.genie.myapp.entity.Account.User;
import com.genie.myapp.entity.Address;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

import static org.modelmapper.convention.MatchingStrategies.*;

@Data
@NoArgsConstructor
public class AddressDTO {

	private int address_num;
	
	private User genie_id; // 이부분이 중요
	private String user_name;

	private String user_tel;
	private String user_phone_num1;
	private String user_phone_num2;
	private String user_phone_num3;

	private String user_zipcode;
	private String user_addr;
	private String user_detailaddr;

	public String getUser_tel() {
		return user_phone_num1 + "-"+user_phone_num2+"-"+user_phone_num3;
	}

	public void setUser_tel(String user_tel) {
		
		this.user_tel = user_tel;
		String[] telSplit = user_tel.split("-");
		user_phone_num1 = telSplit[0];
		user_phone_num2 = telSplit[1];
		user_phone_num3 = telSplit[2];
	}


	// Entity -> DTO (정적 팩토리 메서드)
	public static AddressDTO convertEntityToDTO(Address address){

		ModelMapper modelMapper = new CustomerModelMapper();
		// 매핑 전략 설정
		modelMapper.getConfiguration().setMatchingStrategy(STRICT);
		return modelMapper.map(address,AddressDTO.class);
	}

	// DTO -> Entyty
	public static Address convertDTOtoEntity(AddressDTO addressDTO) {

		ModelMapper modelMapper = new CustomerModelMapper();
		// 매핑 전략 설정
		modelMapper.getConfiguration().setMatchingStrategy(STRICT);
		return modelMapper.map(addressDTO, Address.class);
	}

	// Entity -> DTO (List의 경우)
	public static List<AddressDTO> convertEntityToDTO(List<Address> addressList) {
		return addressList.stream().map(AddressDTO::convertEntityToDTO).collect(Collectors.toList());
	}


}
