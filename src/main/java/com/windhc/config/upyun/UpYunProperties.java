package com.windhc.config.upyun;

import main.java.com.UpYun;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author windhc
 */
@ConfigurationProperties(prefix = "upyun")
public class UpYunProperties {

    private String bucketName;

    private String username;

    private String password;

    private Boolean debug = false;

    private Integer timeout = 30;

    private String apiDomain = UpYun.ED_AUTO;

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getDebug() {
        return debug;
    }

    public void setDebug(Boolean debug) {
        this.debug = debug;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public String getApiDomain() {
        return apiDomain;
    }

    public void setApiDomain(String apiDomain) {
        this.apiDomain = apiDomain;
    }
}
