package com.genie.myapp.Config;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.genie.myapp.dto.AccountDTO;

public class RoleDetail implements UserDetails{

    private AccountDTO AccountDTO;

    public RoleDetail(AccountDTO AccountDTO){
        this.AccountDTO=AccountDTO;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        
        Collection<GrantedAuthority> auth = new ArrayList<>();
        if(AccountDTO.getROLE().equals("ADMIN")){
            auth.add(new GrantedAuthority() {

                @Override
                public String getAuthority() {
                    return "ROLE_"+AccountDTO.getROLE();
                }
            });
        }else if(AccountDTO.getROLE().equals("SELLER")){
            auth.add(new GrantedAuthority() {

                @Override
                public String getAuthority() {
                    return "ROLE_"+AccountDTO.getROLE();
                }
            });
        }else{
            auth.add(new GrantedAuthority() {

                @Override
                public String getAuthority() {
                    return "ROLE_"+AccountDTO.getROLE();
                }       
            });
        }



        return auth;
    }

    @Override
    public String getPassword() {
        return AccountDTO.getGenie_pwd();
    }

    @Override
    public String getUsername() {
        return AccountDTO.getGenie_id();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
