package com.genie.myapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class OrderDTO {

    private String order_num;
    private String genie_id;

    private String recipient_name;
    private String recipient_phone;
    private String recipient_address;
    private String recipient_request;
    private String recipient_delivery_status;

    private int cart_num;
	private List<Integer> cartList;
    private int product_id;
	private List<Integer> product_id_List;
    private String product_name;
	private List<String> product_name_List;
    private int cart_qty;
	private List<Integer> cart_qty_List;
    private int order_price;
    private int cart_price;
	private List<Integer> order_price_List;
    private int order_qty;

    private String order_writedate;
    private String payment_method;

    private String month_day;
    private int total_sales;

    private int sold_counts;
    private String product_image1;
    private String product_category;

	
}
