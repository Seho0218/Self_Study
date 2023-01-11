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
    private String ROLE;
    private boolean enabled;
    private Role role;

    @QueryProjection
    public AccountDTO(String genie_id, String genie_pwd, String ROLE, boolean enabled, Role role) {
        this.genie_id = genie_id;
        this.genie_pwd = genie_pwd;
        this.ROLE = ROLE;
        this.enabled = enabled;
        this.role = role;
    }
}
