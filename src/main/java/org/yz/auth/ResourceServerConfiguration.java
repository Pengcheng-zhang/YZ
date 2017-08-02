//package org.yz.auth;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//
///**
// * Created by 张鹏程 on 2017/6/8.
// */
//@Configuration
//@EnableResourceServer
//public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
//
//    @Value("oauth2_resource_server")
//    private String resourceId;
//
//    @Autowired
//    private TokenStore tokenStore;
//
//    @Override
//    public void configure(ResourceServerSecurityConfigurer resource){
//        resource.tokenStore(tokenStore).resourceId(resourceId);
//    }
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/public/**", "/oauth/**").permitAll()
//                .antMatchers("/private").access("#oauth2.hasRole('ROLE_USER')")
//                .anyRequest().authenticated();
//    }
//}
