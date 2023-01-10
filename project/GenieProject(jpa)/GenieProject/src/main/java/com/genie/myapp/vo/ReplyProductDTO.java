package com.genie.myapp.vo;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class ReplyProductDTO {
    private String genie_id;
    private int reply_no;
    private int product_id;
    private String comment;
    private String writedate;
    private int rating;
    
}