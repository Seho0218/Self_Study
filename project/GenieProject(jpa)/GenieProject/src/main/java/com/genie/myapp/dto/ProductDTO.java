package com.genie.myapp.dto;

import com.genie.myapp.entity.Account.Seller;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDTO {

	private Long product_id;
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
	private Seller company_name;


	@QueryProjection
	public ProductDTO(Long product_id, String genie_id, String product_category, String product_tag, String product_name, int product_price, String product_info, int product_stock, int product_quantity, int product_hit, int product_like, String product_writedate, String product_image1, String product_image2, String product_image3, String product_mbti, Seller company_name) {
		this.product_id = product_id;
		this.genie_id = genie_id;
		this.product_category = product_category;
		this.product_tag = product_tag;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_info = product_info;
		this.product_stock = product_stock;
		this.product_quantity = product_quantity;
		this.product_hit = product_hit;
		this.product_like = product_like;
		this.product_writedate = product_writedate;
		this.product_image1 = product_image1;
		this.product_image2 = product_image2;
		this.product_image3 = product_image3;
		this.product_mbti = product_mbti;
		this.company_name = company_name;
	}
}