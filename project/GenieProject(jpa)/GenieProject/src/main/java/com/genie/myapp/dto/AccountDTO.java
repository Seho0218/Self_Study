package com.genie.myapp.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;

@Data
@NoArgsConstructor
public class AccountDTO {

    private String genie_id;
	private String genie_pwd;
    private int withdrawal;

    private String ROLE;
    private Role role;

}

