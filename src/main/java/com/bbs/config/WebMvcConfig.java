package com.bbs.config;

import com.bbs.interceptor.CommonInterceptor;
import com.bbs.interceptor.UserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description: WebMvcConfig
 * @author: zhenglubo
 * @create: 2019-09-11 13:52
 **/

@Component
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Autowired
    private UserInterceptor userInterceptor;
    @Autowired
    private CommonInterceptor commonInterceptor;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/", "file:./static/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 用户拦截器，拦截用户是否登录，除开管理端接口的所有接口
        registry.addInterceptor(commonInterceptor).addPathPatterns("/**");
        registry.addInterceptor(userInterceptor).addPathPatterns("/**").excludePathPatterns("/admin/**","/user/register","/user/login").excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
    }
}
