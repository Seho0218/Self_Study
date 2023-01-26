package com.genie.myapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LikeDTO {
    private String genieId;
    private int productId;
    private int likeNum;

}
