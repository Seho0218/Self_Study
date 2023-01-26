package com.genie.myapp.dto;

import com.genie.myapp.Config.CustomerModelMapper;
import com.genie.myapp.entity.Account.Seller;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import static org.modelmapper.convention.MatchingStrategies.*;

@Data
@NoArgsConstructor
public class SellerDTO {
	
	private String genieId;
	private String geniePwd;
	private String geniePwd2;
	private String ROLE;
	
	private String sellerTel;
	private String tel1;
	private String tel2;
	private String tel3;
	
	private String sellerEmail;
	private String sellerRegNo;
	private String companyName;
	private String ceoName;
	private String sellerWebsite;
	
	private String sellerAddress;
	private String selAddr;
	private String selDetailAddr;
	
	private String writeDate;
	private String sellerStatus;
	private String approvalDate;



	public String getSellerTel() {
		return tel1+"-"+tel2+"-"+tel3;
	}
	public void setSellerTel(String seller_tel) {
		this.sellerTel = sellerTel;
		String[] telSplit = seller_tel.split("-");
		tel1 = telSplit[0];
		tel2 = telSplit[1];
		tel3 = telSplit[2];
	}


	public String getSellerAddress() {
		return selAddr+","+selDetailAddr;
	}
	public void setSellerAddress(String sellerAddress) {
		this.sellerAddress = sellerAddress;
		String[] addrSplit = sellerAddress.split(",");
		selAddr = addrSplit[0];
		selDetailAddr = addrSplit[1];
	}


	// Entity -> DTO (정적 팩토리 메서드)
	public static SellerDTO convertEntityToDTO(Seller seller){

		ModelMapper modelMapper = new CustomerModelMapper();
		// 매핑 전략 설정
		modelMapper.getConfiguration().setMatchingStrategy(STRICT);
		return modelMapper.map(seller, SellerDTO.class);
	}

	// DTO -> Entity
	public static Seller convertDTOtoEntity(SellerDTO sellerDTO) {

		ModelMapper modelMapper = new CustomerModelMapper();
		// 매핑 전략 설정
		modelMapper.getConfiguration().setMatchingStrategy(STRICT);
		return modelMapper.map(sellerDTO, Seller.class);
	}

	public static SellerDTO createSellerDTO(String genieId) {
		SellerDTO sellerDTO = new SellerDTO();
		sellerDTO.setGenieId(genieId);
		return sellerDTO;
	}

	
	
}
