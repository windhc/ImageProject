package com.windhc.config.upyun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author windhc
 */
@Configuration
@EnableConfigurationProperties(UpYunProperties.class)
public class UpYunAutoConfiguration {

    @Autowired
    private UpYunProperties upYunProperties;

    @Bean
    public UpYunService upYunService() {
        return new UpYunService();
    }
}
