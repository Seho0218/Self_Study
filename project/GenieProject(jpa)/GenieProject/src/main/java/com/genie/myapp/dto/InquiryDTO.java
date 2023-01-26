package com.genie.myapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InquiryDTO {

	public String genieId;
	public int productId;
	public String inquiryTitle;
	public String inquiryContent;
	public String inquiryStatus;
	public String inquiryWriteDate;
	public String productName;

}
