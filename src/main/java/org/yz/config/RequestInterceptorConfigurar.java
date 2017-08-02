package org.yz.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.yz.Interceptor.RequestInterceptor;

/**
 * Created by 张鹏程 on 2017/6/22.
 */
@Configuration
public class RequestInterceptorConfigurar extends WebMvcConfigurerAdapter {
    @Autowired
    private RequestInterceptor requestInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestInterceptor)
                .addPathPatterns("/edit")
                .excludePathPatterns("/login/**", "/oauth/**");
    }
}
