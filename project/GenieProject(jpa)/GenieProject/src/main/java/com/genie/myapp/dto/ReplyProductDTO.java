package com.genie.myapp.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ReplyProductDTO {
    private String genie_id;
    private int reply_no;
    private int product_id;
    private String comment;
    private String writedate;
    private int rating;

    @QueryProjection
    public ReplyProductDTO(String genie_id, int reply_no, int product_id, String comment, String writedate, int rating) {
        this.genie_id = genie_id;
        this.reply_no = reply_no;
        this.product_id = product_id;
        this.comment = comment;
        this.writedate = writedate;
        this.rating = rating;
    }
}