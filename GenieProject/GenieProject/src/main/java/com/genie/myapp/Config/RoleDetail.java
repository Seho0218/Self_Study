package com.genie.myapp.Config;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.genie.myapp.vo.AccountVO;

public class RoleDetail implements UserDetails{

    private AccountVO accountVO;

    public RoleDetail(AccountVO accountVO){
        this.accountVO=accountVO;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        
        Collection<GrantedAuthority> auth = new ArrayList<>();
        if(accountVO.getROLE().equals("ADMIN")){
            auth.add(new GrantedAuthority() {

                @Override
                public String getAuthority() {
                    return "ROLE_"+accountVO.getROLE();
                }
            });
        }else if(accountVO.getROLE().equals("SELLER")){
            auth.add(new GrantedAuthority() {

                @Override
                public String getAuthority() {
                    return "ROLE_"+accountVO.getROLE();
                }
            });
        }else{
            auth.add(new GrantedAuthority() {

                @Override
                public String getAuthority() {
                    return "ROLE_"+accountVO.getROLE();
                }       
            });
        }



        return auth;
    }

    @Override
    public String getPassword() {
        return accountVO.getGenie_pwd();
    }

    @Override
    public String getUsername() {
        return accountVO.getGenie_id();
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
