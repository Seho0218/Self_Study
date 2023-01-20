package com.genie.myapp.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class OrderDTO {

    private String order_num;
    private String genie_id;
    private String product_name;

    private String recipient_name;
    private String recipient_phone;
    private String recipient_address;
    private String recipient_request;
    private String recipient_delivery_status;
    private String payment_method;
    private String order_writedate;

    private int cart_num;
    private List<Integer> cartList;
    private int product_id;
    private List<Integer> product_id_List;
    private List<String> product_name_List;
    private int cart_qty;
    private List<Integer> cart_qty_List;
    private int order_price;
    private int cart_price;
    private List<Integer> order_price_List;
    private int order_qty;


    private String month_day;
    private int total_sales;

    private int sold_counts;
    private String product_image1;
    private String product_category;


    @QueryProjection
    public OrderDTO(String order_num, String genie_id, String recipient_name, String recipient_phone, String recipient_address, String recipient_request, String recipient_delivery_status, int cart_num, List<Integer> cartList, int product_id, List<Integer> product_id_List, String product_name, List<String> product_name_List, int cart_qty, List<Integer> cart_qty_List, int order_price, int cart_price, List<Integer> order_price_List, int order_qty, String order_writedate, String payment_method, String month_day, int total_sales, int sold_counts, String product_image1, String product_category) {
        this.order_num = order_num;
        this.genie_id = genie_id;
        this.recipient_name = recipient_name;
        this.recipient_phone = recipient_phone;
        this.recipient_address = recipient_address;
        this.recipient_request = recipient_request;
        this.recipient_delivery_status = recipient_delivery_status;
        this.cart_num = cart_num;
        this.cartList = cartList;
        this.product_id = product_id;
        this.product_id_List = product_id_List;
        this.product_name = product_name;
        this.product_name_List = product_name_List;
        this.cart_qty = cart_qty;
        this.cart_qty_List = cart_qty_List;
        this.order_price = order_price;
        this.cart_price = cart_price;
        this.order_price_List = order_price_List;
        this.order_qty = order_qty;
        this.order_writedate = order_writedate;
        this.payment_method = payment_method;
        this.month_day = month_day;
        this.total_sales = total_sales;
        this.sold_counts = sold_counts;
        this.product_image1 = product_image1;
        this.product_category = product_category;
    }
}
