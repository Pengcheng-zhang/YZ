package org.yz.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * Created by 张鹏程 on 2017/6/7.
 */
@Configuration
@Component
public class ErrorConfiguration {
    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
                configurableEmbeddedServletContainer.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, "/400"));
                configurableEmbeddedServletContainer.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500"));
                configurableEmbeddedServletContainer.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404"));

            }
        };
    }
}
