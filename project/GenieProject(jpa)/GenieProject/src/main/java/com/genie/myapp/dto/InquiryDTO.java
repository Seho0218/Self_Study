package com.genie.myapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InquiryDTO {
	public String genie_id;
	public int product_id;
	public String inquiry_title;
	public String inquiry_content;
	public String inquiry_status;
	public String inquiry_writedate;
	public String product_name;

}
