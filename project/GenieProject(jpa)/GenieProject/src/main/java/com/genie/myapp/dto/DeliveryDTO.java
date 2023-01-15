package com.genie.myapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DeliveryDTO {

    private int address_num;
    private String genie_id;
	private String receiver_name;
    private String receiver_tel;
    private String receiver_zipcode;
    private String receiver_addr;
    private String receiver_detailaddr;

}
