package org.yz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;



/**
 * Created by 张鹏程 on 2017/6/7.
 */
@SpringBootApplication
@EnableAutoConfiguration
@MapperScan("org.yz.dao")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
