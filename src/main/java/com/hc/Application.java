package com.hc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Administrator on 2015/7/26.
 */
@SpringBootApplication
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
