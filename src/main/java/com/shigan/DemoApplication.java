package com.shigan;

import com.shigan.interceptor.Interceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class DemoApplication extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	public void addInterceptors(InterceptorRegistry interceptorRegistry){
		interceptorRegistry.addInterceptor(new Interceptor()).addPathPatterns("/market/**");
		interceptorRegistry.addInterceptor(new Interceptor()).addPathPatterns("/pm/**");
	}
}
