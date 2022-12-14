package com.genie.myapp.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdministerDTO {

    private String genie_id;
    private String administer_name;
    private String administer_phone;
    private String genie_pwd;
    private String genie_pwd2;
    private String administer_email;
    private String ROLE;
    private String DATETIME;

    @QueryProjection
    public AdministerDTO(String genie_id, String administer_name,String ROLE) {
        this.genie_id = genie_id;
        this.administer_name = administer_name;
        this.ROLE = ROLE;

    }
}
