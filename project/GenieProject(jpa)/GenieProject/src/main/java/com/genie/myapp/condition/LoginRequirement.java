package com.genie.myapp.condition;

import com.genie.myapp.Config.Role;
import lombok.Data;

@Data
public class LoginRequirement {

    private String genie_id;
    private String genie_pwd;
    private String user_name;
    private Role role;
}
