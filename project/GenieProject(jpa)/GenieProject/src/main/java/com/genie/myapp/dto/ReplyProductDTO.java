package com.genie.myapp.dto;

import lombok.Data;

@Data
public class ReplyProductDTO {

    private String genieId;
    private int replyNo;
    private int productId;
    private String comment;
    private String writeDate;
    private int rating;


}