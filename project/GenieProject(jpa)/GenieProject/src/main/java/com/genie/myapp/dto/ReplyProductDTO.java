package com.genie.myapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

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