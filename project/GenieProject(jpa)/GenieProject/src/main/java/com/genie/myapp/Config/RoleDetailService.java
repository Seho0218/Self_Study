package com.genie.myapp.Config;

import com.genie.myapp.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.genie.myapp.dto.AccountDTO;

@Service
public class RoleDetailService implements UserDetailsService{

    @Autowired
    private UserDTO udto;
    
    @Override
    public UserDetails loadUserByUsername(String genie_id) throws UsernameNotFoundException {
        AccountDTO account = udto.findByGenie_id(genie_id).orElseThrow(()->{
            return new UsernameNotFoundException("에러");
        });
        return new RoleDetail(account);

    }
    
}
