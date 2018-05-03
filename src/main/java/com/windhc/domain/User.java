package com.windhc.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.windhc.config.Role;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户
 *
 * @author Administrator
 * @date 2015/8/27
 */
@Table(name = "tb_user")
@JsonIgnoreProperties(value = {"password"})
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String password;

    private String email;

    /**
     * 最后登陆时间，时间戳
     */
    private Long lastLogin;

    private Integer loginCounts;

    private String registerTime;

    private boolean enabled;

    private Role role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Long lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Integer getLoginCounts() {
        return loginCounts;
    }

    public void setLoginCounts(Integer loginCounts) {
        this.loginCounts = loginCounts;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    //    public List<Picture> getPictures() {
//        return pictures;
//    }
//
//    public void setPictures(List<Picture> pictures) {
//        this.pictures = pictures;
//    }

}