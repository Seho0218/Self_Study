package com.genie.myapp.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private LoginFail loginFail;

	@Autowired
	private RoleDetailService RoleDetailService;

    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.cors().disable();
		
		http.authorizeRequests()
		.antMatchers("/**").permitAll()
		.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/seller/**").hasAnyRole("ADMIN", "SELLER")
		.antMatchers("/user/**", "/cert/**").hasRole("USER")
		.anyRequest().permitAll()
		.and()
		.formLogin()
		.loginPage("/login") // 인증 필요한 페이지 접근시 이동페이지
		.loginProcessingUrl("/login")
		.failureHandler(loginFail)
		.and()
		.logout()
		.logoutSuccessUrl("/")
		;
		
	}
	
	@Bean
	public BCryptPasswordEncoder encodePwd() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(RoleDetailService).passwordEncoder(encodePwd());
    }
}

