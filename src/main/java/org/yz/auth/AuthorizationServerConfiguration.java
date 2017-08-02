//package org.yz.auth;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
//import org.yz.service.CustomUserDetailService;
//
//import javax.sql.DataSource;
//
///**
// * Created by 张鹏程 on 2017/6/8.
// */
//@Configuration
//@EnableAuthorizationServer
//public class AuthorizationServerConfiguration  extends AuthorizationServerConfigurerAdapter {
//
//    @Autowired
//    @Qualifier("authenticationManagerBean")
//    AuthenticationManager authenticationManager;
//
//    @Autowired
//    private DataSource dataSource;
//
//    @Autowired
//    private CustomUserDetailService customUserDetailService;
//
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//        security
//                .tokenKeyAccess("permitAll()")
//                .checkTokenAccess("isAuthenticated()");
//    }
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients
//               .jdbc(dataSource);
//    }
//
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints
//                .tokenStore(tokenStore())
//                .authenticationManager(authenticationManager)
//                .userDetailsService(customUserDetailService);
//    }
//
//    @Bean
//    @Primary
//    public TokenStore tokenStore() {
//        return new JdbcTokenStore(dataSource);
//    }
//}
