package com.genie.myapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDTO {

	private int product_id;
	private String genie_id;
	private String product_category;
	private String product_tag;
	private String product_name;
	private int product_price;
	private String product_info;
	private int product_stock;
	private int product_quantity;
	private int product_hit;
	private int product_like;
	private String product_writedate;
	private String product_image1;
	private String product_image2;
	private String product_image3;
	private String product_mbti;

	private String company_name;


	

}