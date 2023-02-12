package com.genie.myapp.dto;

import com.genie.myapp.Config.CustomerModelMapper;
import com.genie.myapp.entity.Address;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.List;
import java.util.stream.Collectors;

import static org.modelmapper.convention.MatchingStrategies.*;

@Data
@NoArgsConstructor
public class AddressDTO {

	private int addressNum;

	private String genieId; // 이부분이 중요
	private String userName;

	private String userTel;
	private String userPhoneNum1;
	private String userPhoneNum2;
	private String userPhoneNum3;

	private String zipCode;
	private String addr;
	private String detailAddr;

	public String getUserTel() {
		return userPhoneNum1 + "-"+userPhoneNum2+"-"+userPhoneNum3;
	}

	public void setUserTel(String userTel) {

		this.userTel = userTel;
		String[] telSplit = userTel.split("-");
		userPhoneNum1 = telSplit[0];
		userPhoneNum2 = telSplit[1];
		userPhoneNum3 = telSplit[2];
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

		//외래키 해결
		modelMapper.addMappings(new PropertyMap<AddressDTO, Address>() {

			@Override
			protected void configure() {
				map().getGenieId().setGenieId(source.getGenieId());
			}
		});

		return modelMapper.map(addressDTO, Address.class);
	}

	// Entity -> DTO (List의 경우)
	public static List<AddressDTO> convertEntityToDTO(List<Address> addressList) {
		return addressList.stream().map(AddressDTO::convertEntityToDTO).collect(Collectors.toList());
	}


}
