package com.genie.myapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminProductDTO {

	private String product_id;
	private String seller_id;
	private String product_category;
	private String product_tag; 
	private String product_tag_id; 
	private String product_name; 
	private String product_price;
	private String product_info; 
	private int product_stock; 
	private int product_quantity; 
	private int product_hit; 
	private String product_writedate; 
	private String product_image1; 
	private String product_image2;
	private String product_image3;

}
