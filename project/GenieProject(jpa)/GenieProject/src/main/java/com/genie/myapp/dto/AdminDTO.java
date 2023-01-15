package com.genie.myapp.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminDTO {
	private String category_id;
	private String product_category;
	private String product_tag_id;
	private String product_tag;

	@QueryProjection

	public AdminDTO(String category_id, String product_category, String product_tag_id, String product_tag) {
		this.category_id = category_id;
		this.product_category = product_category;
		this.product_tag_id = product_tag_id;
		this.product_tag = product_tag;
	}
}
