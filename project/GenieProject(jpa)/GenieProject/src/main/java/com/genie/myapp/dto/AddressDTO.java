package com.genie.myapp.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDTO {

	private int address_num;
	private String genie_id;
	private String receiver_name;
	private String receiver_tel;
	private String receiver_zipcode;
	private String receiver_addr;
	private String receiver_detailaddr;

	@QueryProjection
	public AddressDTO(int address_num, String genie_id, String receiver_name, String receiver_tel, String receiver_zipcode, String receiver_addr, String receiver_detailaddr) {
		this.address_num = address_num;
		this.genie_id = genie_id;
		this.receiver_name = receiver_name;
		this.receiver_tel = receiver_tel;
		this.receiver_zipcode = receiver_zipcode;
		this.receiver_addr = receiver_addr;
		this.receiver_detailaddr = receiver_detailaddr;
	}
}
