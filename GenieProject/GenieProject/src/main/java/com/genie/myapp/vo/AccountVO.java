package com.genie.myapp.vo;

import javax.management.relation.Role;

public class AccountVO {
    private String genie_id;
	private String genie_pwd;
    private String ROLE;
    private boolean enabled;
    private Role role;


    @Override
    public String toString() {
        return "AccountVO [genie_id=" + genie_id + ", genie_pwd=" + genie_pwd + ", ROLE=" + ROLE + ", enabled="
                + enabled + ", role=" + role + "]";
    }
    public String getGenie_id() {
        return genie_id;
    }
    public void setGenie_id(String genie_id) {
        this.genie_id = genie_id;
    }
    public String getGenie_pwd() {
        return genie_pwd;
    }
    public void setGenie_pwd(String genie_pwd) {
        this.genie_pwd = genie_pwd;
    }
    public String getROLE() {
        return ROLE;
    }
    public void setROLE(String rOLE) {
        ROLE = rOLE;
    }
    public boolean isEnabled() {
        return enabled;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    





  
}
