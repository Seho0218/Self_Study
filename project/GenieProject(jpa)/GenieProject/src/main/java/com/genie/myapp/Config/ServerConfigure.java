package com.genie.myapp.Config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class ServerConfigure implements WebMvcConfigurer {


	public final HandlerInterceptor AdminInterceptor;
	public final HandlerInterceptor SellerInterceptor;
	public final HandlerInterceptor UserInterceptor;
	public final HandlerInterceptor LogoutInterceptor;

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
