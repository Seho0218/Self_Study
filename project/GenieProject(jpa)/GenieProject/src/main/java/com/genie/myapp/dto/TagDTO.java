package com.genie.myapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TagDTO{
    private String genie_who;
    private String genie_day;
    private String genie_old;
    private String gender;
    private int product_price;
    private int money_low;
    private int money_max;

}