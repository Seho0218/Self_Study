package com.genie.myapp.dto;

import com.querydsl.core.annotations.QueryProjection;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class getorderdto {

    private Long order_num;
    private String genie_id;
    private Integer order_qty;
    private Integer order_price;
    private String recipient_delivery_status;
    private LocalDateTime order_writedate;

    @QueryProjection
    public getorderdto(Long order_num, String genie_id, Integer order_qty, Integer order_price, String recipient_delivery_status, LocalDateTime order_writedate) {
        this.order_num = order_num;
        this.genie_id = genie_id;
        this.order_qty = order_qty;
        this.order_price = order_price;
        this.recipient_delivery_status = recipient_delivery_status;
        this.order_writedate = order_writedate;
    }

}

