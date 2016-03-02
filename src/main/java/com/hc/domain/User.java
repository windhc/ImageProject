package com.hc.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * 用户
 * Created by Administrator on 2015/8/27.
 */
@Entity
@Table(name = "tb_user")
@JsonIgnoreProperties(value = {"password"})
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private String email;

    private String LastLogin; //最后登陆时间，时间戳

    private String LoginCounts;

    @Column(nullable = false)
    private String registerTime;

    @Column(nullable = false)
    private boolean enabled;

    @Enumerated(EnumType.STRING)
    private ROLE role;

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

    public String getLastLogin() {
        return LastLogin;
    }

    public void setLastLogin(String lastLogin) {
        LastLogin = lastLogin;
    }

    public String getLoginCounts() {
        return LoginCounts;
    }

    public void setLoginCounts(String loginCounts) {
        LoginCounts = loginCounts;
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

    public ROLE getRole() {
        return role;
    }

    public void setRole(ROLE role) {
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