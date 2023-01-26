package com.genie.myapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TagDTO{

    private String genieWho;
    private String genieDay;
    private String genieOld;
    private String gender;
    private int productPrice;
    private int moneyMax;
    private int moneyLow;

}