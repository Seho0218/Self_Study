package com.genie.myapp.dto;

import com.genie.myapp.Config.CustomerModelMapper;
import com.genie.myapp.entity.Address;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

@Data
@NoArgsConstructor
public class AddressDTO {

	private int address_num;
	
	private String genie_id;
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

	// DTO -> Entyty
	public static Address convertDTOtoEntity(AddressDTO addressDTO) {

		ModelMapper modelMapper = new CustomerModelMapper();
		// 매핑 전략 설정
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper.map(addressDTO, Address.class);
	}
}
