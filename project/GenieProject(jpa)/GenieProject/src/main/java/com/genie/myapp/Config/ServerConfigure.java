package com.genie.myapp.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ServerConfigure implements WebMvcConfigurer {

	@Autowired
	@Qualifier("AdminInterceptor")
	HandlerInterceptor AdminInterceptor;

	@Autowired
	@Qualifier("SellerInterceptor")
	HandlerInterceptor SellerInterceptor;

	@Autowired
	@Qualifier("UserInterceptor")
	HandlerInterceptor UserInterceptor;

	@Autowired
	@Qualifier("LogoutInterceptor")
	HandlerInterceptor LogoutInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(UserInterceptor)//유저 로그인일때
		.addPathPatterns("/user/**","/order/**")//되도록
		.order(1);
		
		registry.addInterceptor(SellerInterceptor)
		.addPathPatterns("/seller/**")
		.order(2);
		
		registry.addInterceptor(AdminInterceptor)
		.addPathPatterns("/admin/**")
		.order(3);
	
		registry.addInterceptor(LogoutInterceptor)//로그인이 되어있다면
		.addPathPatterns("/login","/sellerForm","/loginOK","/Registration")//못 들어가게
		.order(4);

	}
}
