package com.genie.myapp.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LikeDTO {
    private String genie_id;
    private int product_id;
    private int like_num;

}
