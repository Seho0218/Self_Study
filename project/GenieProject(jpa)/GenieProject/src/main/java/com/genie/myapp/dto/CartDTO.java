package com.genie.myapp.dto;

import java.util.List;

import lombok.*;

@Data
@NoArgsConstructor
public class CartDTO {
	
    private List<Integer> cartList;
    private int cart_num;
    private String genie_id;
    private int product_id;
    private String product_name;
	private List<String> product_name_List;
    private int cart_price;
    private int product_price;
    private int cart_qty;
    private String cart_writedate;
    private String product_image1;
    private int product_quantity;

}