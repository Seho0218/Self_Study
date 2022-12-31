package com.genie.myapp.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.genie.myapp.dao.UserDAO;
import com.genie.myapp.vo.AccountVO;

@Service
public class RoleDetailService implements UserDetailsService{

    @Autowired
    private UserDAO userdao;
    
    @Override
    public UserDetails loadUserByUsername(String genie_id) throws UsernameNotFoundException {
        AccountVO account = userdao.findByGenie_id(genie_id).orElseThrow(()->{
            return new UsernameNotFoundException("에러");
        });
        return new RoleDetail(account);   
        
    }
    
}
