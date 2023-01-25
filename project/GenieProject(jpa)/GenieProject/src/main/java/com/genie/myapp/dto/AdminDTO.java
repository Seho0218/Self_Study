package com.genie.myapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminDTO {
	private String category_id;
	private String product_category;
	private String product_tag_id;
	private String product_tag;

}
