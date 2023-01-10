package com.genie.myapp.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;

@Data
@NoArgsConstructor
public class AccountDTO {
    private String genie_id;
	private String genie_pwd;
    private String ROLE;
    private boolean enabled;
    private Role role;

}
